package App;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import App.*;
//import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LoginService {

    public static boolean jsonExist(String username) {
        File f = new File(".idea/src/App/Database/"+username+".json");
        return f.exists() && !f.isDirectory();
    }

    public static Account getAccountFromUsername(String username) {
        if (jsonExist(username)) {
            Account account = new Account();
            account = JsonLoader.ReadFromJson(username);
            return account;
        }
        return null;
    }

    public static boolean areLoginAndPasswordCorrect(String username, String password) {
        Account account = new Account();
        account = getAccountFromUsername(username);
        if (account.getPasswort().equals(RegistrationManager.PasswordHasher(password))) {
                return true;
        }
        return false;
    }

    public static boolean isUserLocked(String username) {
        Account account = new Account();
        account = getAccountFromUsername(username);
        if (account.getIsLocked()) {
                return true;
        }
        return false;
    }

    public static String getCurrentDateTimeString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String currentDateTimeString = dtf.format(currentDateTime).toString();
        return currentDateTimeString;
    }

    public static Account requestUserCredentials() {
        boolean userLocked = false;
        boolean correctpassword = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Bitte gib einen Benutzernamen ein:");
        String userInputUsername = keyboard.next();
        System.out.println("Bitte gib einen Passwort ein:");
        String userInputPassword = keyboard.next();
        if (areLoginAndPasswordCorrect(userInputUsername, userInputPassword)) {
            correctpassword = true;
            Account account = new Account();
            account = JsonLoader.ReadFromJson(userInputUsername);
            if (account.getIsLocked()) {
                System.out.println("Dein Benutzer ist bis zum " + account.getDateTimeTillUserWasLocked() + " gesperrt.");
                // TODO: check the time and unlock user
                account.setIsLocked(false);
                JsonLoader.SaveJson(account);
                return null;
            }
            System.out.println("Du bist erfolgreich eingeloggt.");
            account.setNumberOfFailedLogins(0);
            JsonLoader.SaveJson(account);
            return account;
        } else {
            System.out.println("Benutzername oder Passwort ist falsch.");
            if (jsonExist(userInputUsername)) {
                Account account = new Account();
                account = JsonLoader.ReadFromJson(userInputUsername);
                int numberOfFailedLogins = 0;
                numberOfFailedLogins = account.getNumberOfFailedLogins() + 1;
                account.setNumberOfFailedLogins(numberOfFailedLogins);
                if (numberOfFailedLogins >= 4) {
                    account.setIsLocked(true);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                    LocalDateTime dateTimeWhenUserWasLocked = LocalDateTime.now();
                    LocalDateTime dateTimeTillUserWasLocked = dateTimeWhenUserWasLocked.plusSeconds(60);

                    String dateTimeWhenUserWasLockedString = dtf.format(dateTimeWhenUserWasLocked).toString();
                    String dateTimeTillUserWasLockedString = dtf.format(dateTimeTillUserWasLocked).toString();

                    account.setDateTimeWhenUserWasLocked(dateTimeWhenUserWasLockedString);
                    account.setDateTimeTillUserWasLocked(dateTimeTillUserWasLockedString);

                    System.out.println("Dein Account ist gesperrt.");
                }
                JsonLoader.SaveJson(account);


            }
            return null;
        }
    }
}
