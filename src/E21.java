import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.PublicKey;

public class E21 {

        public static byte[][] encryptWrappedData(byte[] data, PublicKey pub) {
            byte[][] encWrappedData = new byte[2][];
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(128);
                SecretKey sKey = kgen.generateKey();
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, sKey);
                byte[] encMsg = cipher.doFinal(data);
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.WRAP_MODE, pub);
                byte[] encKey = cipher.wrap(sKey);
                encWrappedData[0] = encMsg;
                encWrappedData[1] = encKey;
            } catch (Exception  ex) {
                System.err.println("Ha succeït un error xifrant: " + ex);
            }
            return encWrappedData;
        }

}
