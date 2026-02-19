package NetZero.repository;

import NetZero.domain.Member;
import NetZero.domain.StepInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface StepInfoRepository extends JpaRepository<StepInfo, Long> {
    Optional<StepInfo> findByMemberAndRecordDate(Member member, LocalDate recordDate);
}

