package NetZero.repository;

import NetZero.domain.Member;
import NetZero.domain.PointHistory;
import NetZero.domain.StepInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface StepInfoRepository extends JpaRepository<StepInfo, Long> {
    StepInfo findByMemberAndRecordDate(Member member, LocalDate recordDate);
}

