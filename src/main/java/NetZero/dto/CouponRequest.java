package NetZero.dto;

import NetZero.domain.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CouponRequest {
    private String memberId;
}
