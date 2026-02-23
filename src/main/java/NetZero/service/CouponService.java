package NetZero.service;

import NetZero.domain.Coupon;
import NetZero.domain.Member;
import NetZero.domain.MemberCoupon;
import NetZero.domain.PointHistory;
import NetZero.dto.CouponResponse;
import NetZero.exception.BusinessException;
import NetZero.exception.ErrorCode;
import NetZero.repository.CouponRepository;
import NetZero.repository.MemberCouponRepository;
import NetZero.repository.MemberRepository;
import NetZero.repository.PointHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CouponService {
    private final CouponRepository couponRepository; //쿠폰 상점
    private final MemberRepository memberRepository;
    private final MemberCouponRepository memberCouponRepository; //쿠폰 영수증
    private final PointHistoryRepository pointHistoryRepository;


    @Transactional(readOnly = true)
    public List<CouponResponse> getMyCoupons(Member member) {
        return memberCouponRepository.findByMemberAndIsUsedFalse(member)
                .stream()
                .map(CouponResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void purchaseCoupon(String memberId, long couponId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() -> new BusinessException(ErrorCode.COUPON_NOT_FOUND));

        member.usePoint(coupon.getPrice()); //member내부에서 포인트가 충분한 지 검사

        pointHistoryRepository.save(new PointHistory(member, -coupon.getPrice(), coupon.getName() + "구매"));

        String couponName = UUID.randomUUID().toString().substring(0, 8);
        LocalDate validDate = LocalDate.now().plusMonths(1);

        MemberCoupon memberCoupon = new MemberCoupon(member, coupon, couponName, validDate);
        memberCouponRepository.save(memberCoupon);
    }
}
