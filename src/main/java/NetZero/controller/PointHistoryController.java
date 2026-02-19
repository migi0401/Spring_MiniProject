package NetZero.controller;

import NetZero.domain.Member;
import NetZero.dto.PointHistoryResponse;
import NetZero.service.PointHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class PointHistoryController {

    private final PointHistoryService pointHistoryService;

    @GetMapping("/{memberId}/histories")
    public List<PointHistoryResponse> getPointHistories(@PathVariable("memberId") Member member) {
        return pointHistoryService.getPointHistories(member);
    }
}
