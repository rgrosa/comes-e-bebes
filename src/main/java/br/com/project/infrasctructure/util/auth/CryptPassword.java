package br.com.project.infrasctructure.util.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

@Component
public class CryptPassword implements PasswordEncoder {

    private static SecretKey myKey;

    static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static final Logger log = LoggerFactory.getLogger(CryptPassword.class);


    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }

    @Override
    public String encode(CharSequence msg) {
        Cipher c;
        String ret = "";
        try {
            String strKey = "EIR=5EXA";
            byte[] byteKey = strKey.getBytes();
            DESKeySpec desKeySpec = new DESKeySpec(byteKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            myKey = keyFactory.generateSecret(desKeySpec);
            c = Cipher.getInstance("DES");
            c.init(Cipher.ENCRYPT_MODE, myKey);
            byte[] cipherText = c.doFinal(((String) msg).getBytes());
            ret = toHexString(cipherText);
        } catch (Exception e) {
            log.error("Exception password");
        }
        return ret;
    }

    private   String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            // look up high nibble char
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            // look up low nibble char
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }
}
