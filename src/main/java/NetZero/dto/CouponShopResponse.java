package NetZero.dto;

import NetZero.domain.Coupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CouponShopResponse {
    private long couponId;
    private int price;
    private String name;

    public static CouponShopResponse from(Coupon coupon) {
        return new CouponShopResponse(
                coupon.getCouponId(),
                coupon.getPrice(),
                coupon.getName()
        );
    }
}
