package NetZero.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class StepInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stepId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int stepCount;
    private LocalDate recordDate;

    public StepInfo(Member member, int stepCount, LocalDate recordDate) {
        this.member = member;
        this.stepCount = stepCount;
        this.recordDate = recordDate;
    }
}
