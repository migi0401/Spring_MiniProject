package NetZero.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class StepRequest {
    private String userId;
    private int stepCount;
    private LocalDate recordDate;

    public StepRequest(String userId, int stepCount, LocalDate recordDate) {
        this.userId = userId;
        this.stepCount = stepCount;
        this.recordDate = recordDate;
    }
}
