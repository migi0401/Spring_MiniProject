package NetZero.controller;

import NetZero.domain.Member;
import NetZero.domain.MemberCoupon;
import NetZero.dto.CouponRequest;
import NetZero.dto.MyCouponResponse;
import NetZero.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping ("/{memberId}/coupons")
    public List<MyCouponResponse> getMyCoupons(@PathVariable("memberId") Member member){
        return couponService.getMyCoupons(member.getId());
    }

    @PostMapping ("/{couponId}/purchase")
    public MyCouponResponse purchaseCoupon(@PathVariable("couponId") Long couponId, @RequestBody CouponRequest couponRequest){
        MemberCoupon memberCoupon = couponService.purchaseCoupon(couponRequest.getMemberId(), couponId);

        return MyCouponResponse.from(memberCoupon);
    }
}
