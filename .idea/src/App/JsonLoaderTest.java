package App;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonLoaderTest {

    @Test
    void testSaveJson() {
        // acc =
        // assertEquals(expected,hashedPass);
    }
    void testReadFromJson() {
        String enteredPassword = "1234";
        String hashedPass = RegistrationManager.PasswordHasher(enteredPassword);
        String expected = "81dc9bdb52d04dc20036dbd8313ed055";
        assertEquals(expected,hashedPass);
    }

    void testFromJson() {
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
