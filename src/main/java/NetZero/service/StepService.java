package NetZero.service;

import NetZero.domain.Member;
import NetZero.domain.StepInfo;
import NetZero.dto.StepRequest;
import NetZero.exception.BusinessException;
import NetZero.exception.ErrorCode;
import NetZero.repository.MemberRepository;
import NetZero.repository.StepInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepInfoRepository stepInfoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveStep(StepRequest stepRequest) {
        Member member = memberRepository.findById(stepRequest.getUserId()).orElseThrow(
                () -> new BusinessException(ErrorCode.USER_NOT_FOUND)
        );

        StepInfo stepInfo = new StepInfo(member, stepRequest.getStepCount(), stepRequest.getRecordDate());

        stepInfoRepository.save(stepInfo);
    }
}
