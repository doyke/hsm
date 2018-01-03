package pl.mwojcik.domain.model.key;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import pl.mwojcik.domain.model.error.ErrorCode;
import pl.mwojcik.domain.model.key.aes.AesService;
import pl.mwojcik.domain.model.key.des.DesService;
import pl.mwojcik.domain.model.util.RandomStringUtil;

import javax.crypto.SecretKey;
import java.security.SecureRandom;

@Slf4j
@Service
@AllArgsConstructor
public class KeyService {

    private AesService aesService;
    private DesService desService;


    public KeyOut generateKey(KeyIn keyIn) {
        SecretKey generatedKey;
        String key = "";
        String keyAlgorithm = keyIn.getAlgorithm();
        if ("A1".equals(keyAlgorithm) || "A2".equals(keyAlgorithm) || "A3".equals(keyAlgorithm)) {
            generatedKey = aesService.generateAesKey(getKeyLength(keyAlgorithm));
            key = new String(Base64.encodeBase64(generatedKey.getEncoded()));
        } else if ("D1".equals(keyAlgorithm) || "T2".equals(keyAlgorithm) || "T3".equals(keyAlgorithm)) {
            generatedKey = desService.generateDesKey(getKeyLength(keyAlgorithm));
            key = new String(Base64.encodeBase64(generatedKey.getEncoded()));
        }
        log.info("The aes key is: {}", key);
        String keyCheckValue = generateCheckValue();
        log.info("The keyCheckValue: {}", keyCheckValue);
        return KeyOut.builder()
                .errorCode(ErrorCode.CODE_00).key(key).keyCheckValue(keyCheckValue).build();
    }


    private String generateCheckValue() {
        String dictionary = RandomStringUtil.ALPHANUM;
        RandomStringUtil tickets = new RandomStringUtil(6, new SecureRandom(), dictionary);
        return tickets.nextString();
    }

    private String getKeyLength(String algorithm) {
        switch (algorithm) {
            case "A1":
                return "128";
            case "A2":
                return "192";
            case "A3":
                return "256";
            case "D1":
                return "56";
            case "T2":
                return "56";
            case "T3":
                return "56";
            default:
                log.error("Invalid algorithm");
                return "256";
        }
    }
}
