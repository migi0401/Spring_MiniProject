package NetZero.controller;

import NetZero.dto.MemberResponse;
import NetZero.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberResponse getMemberInfo(@PathVariable("memberId") String memberId) {
        return memberService.getMemberInfo(memberId);
    }
}
