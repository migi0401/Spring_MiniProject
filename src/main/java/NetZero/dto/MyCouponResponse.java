package NetZero.dto;

import NetZero.domain.MemberCoupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MyCouponResponse {
    private Long memberCouponId;
    private String couponName;
    private String barcode;
    private LocalDate validDate;
    private boolean isUsed;

    public static MyCouponResponse from(MemberCoupon memberCoupon){
        return new MyCouponResponse(
                memberCoupon.getMemberCouponId(),
                memberCoupon.getCoupon().getName(),
                memberCoupon.getBarcode(),
                memberCoupon.getValidDate(),
                memberCoupon.isUsed()
        );
    }
}
