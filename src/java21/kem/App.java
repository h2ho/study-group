package java21.kem;

import java.security.KeyPairGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.SequencedCollection;

import javax.crypto.KEM;

public class App {

    public static void main(String[] args) throws Exception {

        // https://docs.oracle.com/en/java/javase/21/docs/specs/security/standard-names.html#kem-algorithms
        // Receiver side
        var kpg = KeyPairGenerator.getInstance("X25519");
        var kp = kpg.generateKeyPair();

        // Sender side
        var kem1 = KEM.getInstance("DHKEM");
        var sender = kem1.newEncapsulator(kp.getPublic());
        var encapsulated = sender.encapsulate();
        var k1 = encapsulated.key();

        // Receiver side
        var kem2 = KEM.getInstance("DHKEM");
        var receiver = kem2.newDecapsulator(kp.getPrivate());
        var k2 = receiver.decapsulate(encapsulated.encapsulation());

        assert Arrays.equals(k1.getEncoded(), k2.getEncoded());
    }

}
