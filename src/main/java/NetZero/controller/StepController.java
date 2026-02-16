package NetZero.controller;

import NetZero.dto.StepRequest;
import NetZero.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StepController {

    private final StepService stepService;

    @PostMapping("/api/steps")
    public String recordStep(@RequestBody StepRequest request) {
        stepService.saveStep(request);
        return "걸음 수 저장 성공!";
    }
}
