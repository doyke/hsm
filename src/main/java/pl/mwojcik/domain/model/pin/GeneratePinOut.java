package pl.mwojcik.domain.model.pin;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import pl.mwojcik.domain.model.error.ErrorCode;

@Value
@Builder
public class GeneratePinOut {

    private ErrorCode errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pin;

}
