package NetZero.service;

import NetZero.domain.Member;
import NetZero.domain.PointHistory;
import NetZero.dto.PointHistoryResponse;
import NetZero.repository.PointHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PointService {

    private final PointHistoryRepository pointHistoryRepository;

    public List<PointHistoryResponse> getPointHistories(Member member){
        List<PointHistory> histories = pointHistoryRepository.findByMember(member);

        return histories.stream() //엔티티 리스트들을 DTO 리스트로 변환
                .map(PointHistoryResponse::new) //하나하나를 DTO로 바꿈
                .collect(Collectors.toList());  // 다시 리스트로 묶음
    }

    public void rewardStepPoints(Member member, int oldSteps, int newSteps){
        int oldPoints = oldSteps / 100;
        int newPoints = newSteps / 100;
        int earnedPoints = newPoints - oldPoints;

        if(earnedPoints > 0){
            member.appPoint(earnedPoints);
            pointHistoryRepository.save(new PointHistory(member, earnedPoints, "걸음 수 달성 보상"));
        }
    }
}
