package NetZero.service;

import NetZero.domain.Member;
import NetZero.domain.PointHistory;
import NetZero.domain.StepInfo;
import NetZero.dto.StepRequest;
import NetZero.exception.BusinessException;
import NetZero.exception.ErrorCode;
import NetZero.repository.MemberRepository;
import NetZero.repository.PointHistoryRepository;
import NetZero.repository.StepInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepInfoRepository stepInfoRepository;
    private final MemberRepository memberRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final PointService pointService;

    @Transactional
    public void saveStep(StepRequest stepRequest) {
        Member member = memberRepository.findById(stepRequest.getUserId()).orElseThrow(
                () -> new BusinessException(ErrorCode.USER_NOT_FOUND)
        );

        StepInfo existingStep = stepInfoRepository.findByMemberAndRecordDate(member, stepRequest.getRecordDate()).orElse(null);

        int oldStep = 0;

        if(existingStep != null){ //기존에 있던 날짜의 걸음 수를 저장
            oldStep = existingStep.getStepCount();
            existingStep.updateSteps(stepRequest.getStepCount());
        }else{ //새로운 날짜의 걸음 수를 저장
            StepInfo newStep = new StepInfo(member, stepRequest.getStepCount(), stepRequest.getRecordDate());
            stepInfoRepository.save(newStep);
        }

        int addedStep = stepRequest.getStepCount() - oldStep; //걸음이 늘어난 만큼 요청이 올 때 계속해서 더해준다.

        if(addedStep > 0){
            member.addTotalSteps(addedStep); //누적 걸음 수 더해준다.
        }

        pointService.rewardStepPoints(member, oldStep, stepRequest.getStepCount());
    }
}
