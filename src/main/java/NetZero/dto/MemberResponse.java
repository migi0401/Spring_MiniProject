package NetZero.dto;

import NetZero.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {
    private String nickname;
    private int userPoint;

    public MemberResponse(Member member) {
        this.nickname = member.getNickname();
        this.userPoint = member.getUserPoint();
    }
}
