package NetZero.repository;

import NetZero.domain.CouponInfo;
import NetZero.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponInfoRepository extends JpaRepository<CouponInfo, Long> {
    List<CouponInfo> findByMemberAndIsUsedFalse(Member member);
}
