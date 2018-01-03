package pl.mwojcik.domain.model.key;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Size;

@Value
@Builder
public class KeyIn {

    @Size(min = 1,max = 1)
    private String mode;

    private final String KEY_TYPE = "FFF";

    private String keyScheme;

    private String dukptMasterKeyType;

    private String dukptMasterKey;

    private String ksn;

    @Size(min = 2, max = 2)
    private String lmkIdentifier;

    private String keyUsage;

    private String algorithm;

    private String modeOfUse;

    private String keyVersionNumber;

    private String exportability;
}
