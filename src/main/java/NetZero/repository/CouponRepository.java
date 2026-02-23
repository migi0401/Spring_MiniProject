package NetZero.repository;

import NetZero.domain.Coupon;
import NetZero.domain.MemberCoupon;
import NetZero.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
