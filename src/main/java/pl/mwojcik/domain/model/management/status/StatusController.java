package pl.mwojcik.domain.model.management.status;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class StatusController {

    private StatusService statusService;

    @PostMapping("/management/NO")
    private StatusOut getHsmStatusInfo(@RequestBody @Valid StatusIn statusIn) {
        return statusService.getHsmStatus(statusIn);
    }
}
