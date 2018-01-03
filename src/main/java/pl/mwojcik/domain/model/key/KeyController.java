package pl.mwojcik.domain.model.key;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class KeyController {

    private KeyService keyService;

    @PostMapping("/client/A0")
    public KeyOut generateKey(@Valid @RequestBody KeyIn keyIn) {
        return keyService.generateKey(keyIn);
    }
}
