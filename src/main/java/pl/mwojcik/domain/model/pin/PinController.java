package pl.mwojcik.domain.model.pin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class PinController {

    private PinService pinService;

    @PostMapping(value = "/client/JA")
    public GeneratePinOut getPin(@RequestBody @Valid GeneratePinIn generatePinIn) {
        return pinService.generatePin(generatePinIn);
    }
}
