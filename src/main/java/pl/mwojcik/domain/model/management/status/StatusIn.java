package pl.mwojcik.domain.model.management.status;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Size;

@Value
@Builder
public class StatusIn {

    @Size(min = 2, max = 2)
    private String modeFlag;
}
