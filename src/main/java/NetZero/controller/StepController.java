package NetZero.controller;

import NetZero.dto.StepRequest;
import NetZero.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/steps")
@RequiredArgsConstructor
public class StepController {

    private final StepService stepService;

    @PostMapping
    public Map<String, String> recordStep(@RequestBody StepRequest request) {
        stepService.saveStep(request);
        return Collections.singletonMap("message", "걸음 수 저장 성공");
    }
}
