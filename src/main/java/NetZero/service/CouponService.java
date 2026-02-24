package NetZero.service;

import NetZero.domain.Coupon;
import NetZero.domain.Member;
import NetZero.domain.MemberCoupon;
import NetZero.domain.PointHistory;
import NetZero.dto.MyCouponResponse;
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

@Service
@RequiredArgsConstructor

public class CouponService {
    private final CouponRepository couponRepository; //쿠폰 상점
    private final MemberRepository memberRepository;
    private final MemberCouponRepository memberCouponRepository; //쿠폰 영수증
    private final PointHistoryRepository pointHistoryRepository;


    @Transactional(readOnly = true)
    public List<MyCouponResponse> getMyCoupons(String memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        List<MemberCoupon> myCoupons = memberCouponRepository.findByMemberAndIsUsedFalse(member);

        return myCoupons.stream()
                .map(MyCouponResponse::from)//DTO에 있는 팩토리 메서드 사용, static이라 바로 호출
                .toList();
    }

    @Transactional
    public MemberCoupon purchaseCoupon(String memberId, long couponId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() -> new BusinessException(ErrorCode.COUPON_NOT_FOUND));

        member.usePoint(coupon.getPrice()); //member내부에서 포인트가 충분한 지 검사

        pointHistoryRepository.save(new PointHistory(member, -coupon.getPrice(), coupon.getName() + "구매"));

        String barcode = UUID.randomUUID().toString().substring(0, 8);
        LocalDate validDate = LocalDate.now().plusMonths(1);

        MemberCoupon memberCoupon = new MemberCoupon(member, coupon, barcode, validDate);
        return memberCouponRepository.save(memberCoupon);
    }
}
