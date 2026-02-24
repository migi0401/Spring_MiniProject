package NetZero.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class MemberCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberCouponId; //영수증 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    private String barcode;
    private LocalDate validDate;
    private boolean isUsed;

    public MemberCoupon(Member member, Coupon coupon, String barcode, LocalDate validDate) {
        this.member = member;
        this.coupon = coupon;
        this.barcode = barcode;
        this.validDate = validDate;
        this.isUsed = false;
    }
}
