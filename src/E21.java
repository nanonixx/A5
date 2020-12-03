import java.security.KeyStore;
import java.util.Enumeration;

public class E21 {
    public static void main(String[] args) throws Exception {
        System.out.println("EJERCICIO 2.1\n");

        String ksFilePath = "/home/dam2a/.keystore";
        String password = "passwd";

        KeyStore ks= Xifrar.loadKeyStore(ksFilePath, password);

        System.out.println(ks);

        // Tipus de keystore que és (JKS, JCEKS, PKCS12, ...)
        System.out.println("\nTipo de keystore: " + ks.getType());

        // Mida del magatzem (quantes claus hi ha?)
        System.out.println("\nTamaño: " + ks.size());

        // Àlies de totes les claus emmagatzemades

        Enumeration<String> aliases = ks.aliases();

        System.out.print("\nAlias de las claves: ");
        while(aliases.hasMoreElements()){
            System.out.print(aliases.nextElement()+"  ");
        }


        // El certificat d’una de les claus

        //System.out.println("\nCertificado: " + ks.getCertificate("lamevaclaum9"));

        // L'algorisme de xifrat d’alguna de les claus


        System.out.println("\n\nAlgoritmo de 'lamevaclaum9: " + ks.getCertificate("lamevaclaum9").getPublicKey().getAlgorithm());



    }
}
