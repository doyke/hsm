package pl.mwojcik.domain.model.pin;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Size;

@Value
@Builder
public class GeneratePinIn {

    @Size(min = 12, max = 12, message = "Account number should have 12 characters")
    private String accountNumber;
    @Size(min = 2, max = 2, message = "Pin length should be between 4 and 12")
    private String pinLength;
}
