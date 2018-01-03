package pl.mwojcik.domain.model.key.aes;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

@Service
public class AesService {

    private static final String KEY_TYPE = "AES";

    public SecretKey generateAesKey(String keyLength) {
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
