package src.test.resources;

import src.main.resources.*;
import src.main.resources.Service.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void testAreLoginAndPasswordCorrect_whenCorrectCredentials_returnsTrue() {
        // Arrange
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        JsonLoader.SaveJson(account);

        // Act
        boolean result = LoginService.areLoginAndPasswordCorrect(username, password);

        // Assert
        assertTrue(result);

    }

    @Test
    public void testAreLoginAndPasswordCorrect_whenIncorrectCredentials_returnsFalse() {
        // Arrange
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher("wrongpassword"));
        JsonLoader.SaveJson(account);

        // Act
        boolean result = LoginService.areLoginAndPasswordCorrect(username, password);

        // Assert
        assertFalse(result);

    }

    @Test
    public void testIsUserLocker_whenUserIsLocked_returnsTrue() {
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        account.setIsLocked(true);
        JsonLoader.SaveJson(account);

        boolean result = LoginService.isUserLocked(username);

        assertTrue(result);
    }

    @Test
    public void testIsUserLocker_whenUserIsNotLocked_returnsFalse() {
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        account.setIsLocked(false);
        JsonLoader.SaveJson(account);

        boolean result = LoginService.isUserLocked(username);

        assertFalse(result);

    }

}