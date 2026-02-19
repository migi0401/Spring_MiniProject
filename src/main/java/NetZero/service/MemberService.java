package NetZero.service;

import NetZero.domain.Member;
import NetZero.dto.MemberResponse;
import NetZero.exception.BusinessException;
import NetZero.exception.ErrorCode;
import NetZero.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getMemberInfo(String memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        return new MemberResponse(member);
    }
}
