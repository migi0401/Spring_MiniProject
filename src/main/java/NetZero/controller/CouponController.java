package NetZero.controller;

import NetZero.domain.Member;
import NetZero.dto.CouponResponse;
import NetZero.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/api/members/{memberId}/coupons")
    public List<CouponResponse> getMyCoupons(@PathVariable("memberId") Member member){
        return couponService.getMyCoupons(member);
    }
}
