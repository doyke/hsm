package pl.mwojcik.domain.model.key;

import lombok.Builder;
import lombok.Value;
import pl.mwojcik.domain.model.error.ErrorCode;

@Value
@Builder
public class KeyOut {

    private ErrorCode errorCode;

    private String key;

    private String keyCheckValue;
}
