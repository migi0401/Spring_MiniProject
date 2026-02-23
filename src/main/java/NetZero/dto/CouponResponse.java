package NetZero.dto;

import NetZero.domain.MemberCoupon;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CouponResponse {
    private final String couponId;
    private final String couponName;
    private final boolean isUsed;
    private final LocalDate validDate;

    public CouponResponse(MemberCoupon memberCoupon) {
        this.couponId = memberCoupon.getCouponId();
        this.couponName = memberCoupon.getCouponName();
        this.validDate = memberCoupon.getValidDate();
        this.isUsed = memberCoupon.isUsed();
    }
}
