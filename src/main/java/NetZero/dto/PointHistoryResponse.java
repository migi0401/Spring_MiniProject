package NetZero.dto;

import NetZero.domain.PointHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PointHistoryResponse {
    private int amount;
    private String description;
    private LocalDate historyDate;

    public PointHistoryResponse(PointHistory pointHistory) {
        this.amount = pointHistory.getAmount();
        this.description = pointHistory.getDescription();
        this.historyDate = pointHistory.getCreatedAt().toLocalDate();
    }
}
