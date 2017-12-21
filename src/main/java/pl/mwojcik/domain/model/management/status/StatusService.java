package pl.mwojcik.domain.model.management.status;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mwojcik.domain.model.error.ErrorCode;

@Slf4j
@Service
@AllArgsConstructor
public class StatusService {

    private static final String MODE_FLAG_STATUS = "00";
    private static final String MODE_FLAG_PCI = "01";

    public StatusOut getHsmStatus(StatusIn statusIn) {
        if (MODE_FLAG_STATUS.equals(statusIn.getModeFlag())) {
            return getHsmInfo();
        } else if (MODE_FLAG_PCI.equals(statusIn.getModeFlag())) {
            return getPciCompiliance();
        } else return StatusOut.builder().errorCode(ErrorCode.CODE_68).build();

    }


    private StatusOut getHsmInfo() {
        return StatusOut.builder().bufferSize("2").errorCode(ErrorCode.CODE_00)
                .ethernetType("1").firmwareNumber("12cd-5678").numberOfTcpSockets(17).build();
    }

    private StatusOut getPciCompiliance() {
        return StatusOut.builder().pciHsmCompiliance("1").errorCode(ErrorCode.CODE_00).build();
    }


}
