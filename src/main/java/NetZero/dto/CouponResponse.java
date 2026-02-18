package NetZero.dto;

import NetZero.domain.CouponInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CouponResponse {
    private final String couponId;
    private final String couponName;
    private final boolean isUsed;
    private final LocalDate validDate;

    public CouponResponse(CouponInfo couponInfo) {
        this.couponId = couponInfo.getCouponId();
        this.couponName = couponInfo.getCouponName();
        this.validDate = couponInfo.getValidDate();
        this.isUsed = couponInfo.isUsed();
    }
}
