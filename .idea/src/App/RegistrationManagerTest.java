package App;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationManagerTest {

    @Test
    void passwordHasher() {
        String enteredPassword = "1234";
        String hashedPass = RegistrationManager.PasswordHasher(enteredPassword);
        String expected = "81dc9bdb52d04dc20036dbd8313ed055";
        assertEquals(expected,hashedPass);
    }
}