package NetZero.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class CouponInfo {

    @Id
    private String couponId; // 쿠폰 ID (문자열)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String couponName;
    private LocalDate validDate;
    private boolean isUsed;

    public CouponInfo(String couponId, Member member, String couponName, LocalDate validDate) {
        this.couponId = couponId;
        this.member = member;
        this.couponName = couponName;
        this.validDate = validDate;
        this.isUsed = false;
    }
}
