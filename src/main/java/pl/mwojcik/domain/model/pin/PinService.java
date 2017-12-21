package pl.mwojcik.domain.model.pin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mwojcik.domain.model.error.ErrorCode;

import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class PinService {

    private PinRepository pinRepository;

    GeneratePinOut generatePin(GeneratePinIn generatePinIn) {
        if (!checkLengthIsValid(generatePinIn.getPinLength())) {
            return GeneratePinOut.builder().errorCode(ErrorCode.CODE_81).build();
        }
        String pin = getClearPin(Integer.valueOf(generatePinIn.getPinLength()));
        pinRepository.save(Pin.builder().encryptedPin(pin).build());
        return GeneratePinOut.builder().errorCode(ErrorCode.CODE_00).pin(pin).build();
    }

    private String getClearPin(int pinLength) {
        String pin = "";
        Random randomGenerator = new Random();
        for (int i = 1; i <= pinLength; i++) {
            int randomInt = randomGenerator.nextInt(10);
            pin += String.valueOf(randomInt);
        }
        return pin;
    }

    private boolean checkLengthIsValid(String pinLength) {
        log.info("The length of pin is: {}", pinLength);
        int length = Integer.valueOf(pinLength);
        if (length > 12 || length < 4) {
            return false;
        }
        return true;
    }
}
