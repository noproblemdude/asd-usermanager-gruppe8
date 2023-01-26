package src.test.java;

import src.main.java.Service.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonLoaderTest {

    @Test
    public void testSaveJson() {
        // acc =
        // assertEquals(expected,hashedPass);
    }

    @Test
    public void testReadFromJson() {
        String enteredPassword = "1234";
        String hashedPass = RegistrationManager.PasswordHasher(enteredPassword);
        String expected = "81dc9bdb52d04dc20036dbd8313ed055";

        assertEquals(expected,hashedPass);
    }

    @Test
    public void testFromJson() {
        String enteredPassword = "1234";
        String hashedPass = RegistrationManager.PasswordHasher(enteredPassword);
        String expected = "81dc9bdb52d04dc20036dbd8313ed055";

        assertEquals(expected,hashedPass);
    }
/*
    void testToJson() {
        Account acc = new Account();
        acc.setBenutzername();
        acc.setVorname();
        acc.setNachname();
        acc.setPasswort();
    }
*/
}
