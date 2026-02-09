package NetZero.repository;

import NetZero.domain.Member;
import NetZero.domain.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointHistoryRepository extends JpaRepository<PointHistory, String> {
    List<PointHistory> findByMember(Member member);
}
