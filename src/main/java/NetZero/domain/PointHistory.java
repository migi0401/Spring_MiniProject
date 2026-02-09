package NetZero.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int amount;          // 변동량 (+100, -3000)
    private String description;  // 내용 (걷기보상 등)
    private LocalDateTime createdAt;

    public PointHistory(Member member, int amount, String description) {
        this.member = member;
        this.amount = amount;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
}