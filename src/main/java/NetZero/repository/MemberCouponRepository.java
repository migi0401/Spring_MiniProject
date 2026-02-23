package NetZero.repository;

import NetZero.domain.Member;
import NetZero.domain.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {
    List<MemberCoupon> findByMemberAndIsUsedFalse(Member member);
}
