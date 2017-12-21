package pl.mwojcik.domain.model.pin;

import lombok.Builder;
import lombok.Value;

import javax.persistence.*;

@Value
@Builder
@Entity
@Table
public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long keyId;
    private String encryptedPin;
}
