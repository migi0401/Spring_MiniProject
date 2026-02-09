package NetZero.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;
    private String username;
    private String nickname;
    private int userPoint;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PointHistory> pointHistories = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<StepInfo> stepInfos = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CouponInfo> couponInfos = new ArrayList<>();

    public Member(String id, String username, String nickname, int userPoint){
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.userPoint = 0;
    }

}
