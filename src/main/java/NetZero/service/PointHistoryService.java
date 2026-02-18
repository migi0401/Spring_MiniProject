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
public class PointHistoryService {

    private final PointHistoryRepository pointHistoryRepository;

    public List<PointHistoryResponse> getPointHistories(Member member){
        List<PointHistory> histories = pointHistoryRepository.findByMember(member);

        return histories.stream() //엔티티 리스트들을 DTO 리스트로 변환
                .map(PointHistoryResponse::new) //하나하나를 DTO로 바꿈
                .collect(Collectors.toList());  // 다시 리스트로 묶음
    }
}
