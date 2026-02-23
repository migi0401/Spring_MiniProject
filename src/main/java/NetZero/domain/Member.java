package NetZero.domain;

import NetZero.exception.ErrorCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private int totalSteps;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PointHistory> pointHistories = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<StepInfo> stepInfos = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberCoupon> couponInfos = new ArrayList<>();

    public Member(String id, String username, String nickname, int userPoint){
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.userPoint = 0;
        this.totalSteps = 0;
    }

    public void appPoint(int point){
        if(point>0){
            this.userPoint += point;
        }
    }

    public void usePoint(int price){
        //예외 처리 필요
        this.userPoint -= price;
    }

    public void addTotalSteps(int addSteps){
        if(addSteps>0){
            this.totalSteps += addSteps;
        }
    }
}
