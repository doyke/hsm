package pl.mwojcik.domain.model.key.des;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
@AllArgsConstructor
public class DesService {

    private final static String KEY_TYPE = "DES";

    public SecretKey generateDesKey(String keyLength) {
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance(KEY_TYPE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGen.init(Integer.valueOf(keyLength));
        return keyGen.generateKey();

    }
}
