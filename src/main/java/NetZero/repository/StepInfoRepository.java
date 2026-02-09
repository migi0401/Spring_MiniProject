package NetZero.repository;

import NetZero.domain.PointHistory;
import NetZero.domain.StepInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepInfoRepository extends JpaRepository<StepInfo, Long> {
    StepInfo findByMemberAndRecordDate(String member,String recordDate);
}

