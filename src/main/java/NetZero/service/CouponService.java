package NetZero.service;

import NetZero.domain.Member;
import NetZero.dto.CouponResponse;
import NetZero.repository.CouponInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {
    private final CouponInfoRepository couponInfoRepository;

    public List<CouponResponse> getMyCoupons(Member member) {
        return couponInfoRepository.findByMemberAndIsUsedFalse(member)
                .stream()
                .map(CouponResponse::new)
                .collect(Collectors.toList());
    }
}
