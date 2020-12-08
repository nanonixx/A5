import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class E21 {

//ENCRYPT WRAPPED DATA

        public static byte[][] encryptWrappedData(byte[] data, PublicKey pub) {
            byte[][] encWrappedData = new byte[2][];
            try {

        //Se genera una clave secreta:
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(128);
                SecretKey sKey = kgen.generateKey();

        //Con esta clave secreta se encripta el mensaje original:
        //(Algoritmo simétrico)
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, sKey);
                byte[] encMsg = cipher.doFinal(data);

        //Con la clave pública de la clave asimétrica se encripta la clave secreta
        // que hemos creado anteriormente:  (Algoritmo asimétrico)
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.WRAP_MODE, pub);
                byte[] encKey = cipher.wrap(sKey);

        //Guardamos en mensaje encriptado y la clave secreta encriptada en un array:
                encWrappedData[0] = encMsg;
                encWrappedData[1] = encKey;

            } catch (Exception  ex) {
                System.err.println("Ha succeït un error xifrant: " + ex);
            }

        //Devuelve una pareja: los datos originales encriptados [0] y la clave encriptada [1]:
            return encWrappedData;
        }



//DECRYPT WRAPPED DATA

    public static byte[] decryptWrappedData(byte[][] data, PrivateKey sec) {
        byte[] msgDes = null;

    //En esta posición se encuentra el mensaje encriptado:
        byte[] encMsg = data[0];

        try {

    //Primero de toddo hemos de descifrar la clave necesaria para desencriptar
    // el mensaje. Para eso la desencriptamos con el mismo algoritmo con el
    // que la hemos encriptado:
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.UNWRAP_MODE, sec);
            SecretKey sKey;
            sKey = (SecretKey)cipher.unwrap(data[1], "AES", Cipher.SECRET_KEY);

    //Ahora que ya tenemos la clave, desencriptamos el mensaje con el algoritmo usado para encriptarlo
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sKey);

            msgDes = cipher.doFinal(encMsg);


        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException ex) {
            System.err.println("Ha succeït un error desxifrant: " + ex);
        }

    //devuelve una cosa: el mensaje desencriptado:
        return msgDes;
    }

}
