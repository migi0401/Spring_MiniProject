package NetZero.repository;

import NetZero.domain.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PointHistoryRepository extends JpaRepository<PointHistory, String> {
    List<PointHistory> findByMemberId(String memberId);
}
