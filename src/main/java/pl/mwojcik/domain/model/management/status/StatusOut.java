package pl.mwojcik.domain.model.management.status;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import pl.mwojcik.domain.model.error.ErrorCode;

@Value
@Builder
public class StatusOut {

    private ErrorCode errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bufferSize;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ethernetType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numberOfTcpSockets;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firmwareNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pciHsmCompiliance;
}
