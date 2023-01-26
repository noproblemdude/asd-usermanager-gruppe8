package src.test.java;

import org.junit.Test;
import src.main.java.Service.Account;
import src.main.java.Service.JsonLoader;
import src.main.java.Service.LoginService;
import src.main.java.Service.RegistrationManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static src.main.java.Service.LoginService.*;

public class LoginServiceTest {

    @Test
    public void testAreLoginAndPasswordCorrect_whenCorrectCredentials_returnsTrue() {
        JsonLoader jsonloader = new JsonLoader();
        // Arrange
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        jsonloader.SaveJson(account);

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

    @Test
    public void testHandleLockedAccount() {
        String username = "testuser";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        account.setIsLocked(true);
        account.setNumberOfFailedLogins(4);
        account.setDateTimeTillUserWasLocked(LocalDateTime.now().plusSeconds(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        //call the method
        handleLockedAccount(account);
        //check that the account is still locked
        assertTrue(account.getIsLocked());
        assertTrue(account.getNumberOfFailedLogins() == 4);
        //wait for some time
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //call the method
        handleLockedAccount(account);
        //check that the account is unlocked
        assertFalse(account.getIsLocked());
        assertTrue(account.getNumberOfFailedLogins() == 0);
    }

    @Test
    public void testHandleCorrectCredentials() {
        Account account = new Account();
        account.setNumberOfFailedLogins(3);
        handleCorrectCredentials(account);
        assertEquals(0, account.getNumberOfFailedLogins());
    }


    @Test
    public void testHandleIncorrectCredentials() {
        String username = "testuserIncCred";
        String password = "testpassword";
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(RegistrationManager.PasswordHasher(password));
        account.setIsLocked(false);
        account.setNumberOfFailedLogins(3);
        JsonLoader.SaveJson(account);
        handleIncorrectCredentials(username);
        account = JsonLoader.ReadFromJson(username);
        assertEquals(4, account.getNumberOfFailedLogins());
        assertTrue(account.getIsLocked());
    }




}