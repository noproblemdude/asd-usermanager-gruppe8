package App;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import App.*;

public class LoginService {

    public static boolean areLoginAndPasswordCorrect(String username, String password) {
        Account account = new Account();
        account = JsonLoader.ReadFromJson(username);

        if( (account != null) && (account.getPasswort().equals(RegistrationManager.PasswordHasher(password))) ) {
            return true;
        } else {
            return false;
        }
    }

    public static Account requestUserCredentials() {
        short failedLoginAttempts = 0;
        boolean userLocked = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Bitte gib einen Benutzernamen ein:");
        String userInputUsername = keyboard.next();
        System.out.println("Bitte gib einen Passwort ein:");
        String userInputPassword = keyboard.next();
        while ((failedLoginAttempts <= 3) && userLocked == false) {
           if(areLoginAndPasswordCorrect(userInputUsername, userInputPassword) == false) {
               failedLoginAttempts++;
               System.out.println("Benutzername oder Passwort nicht korrekt.");
               if (failedLoginAttempts == 3) {
                    userLocked = true;
                    // TODO: algorithm for locking the user
               }
           } else {
               System.out.println("Du bist erfolgreich eingeloggt.");
           }
        }
        Account account = new Account();
        account = JsonLoader.ReadFromJson(userInputUsername);
        return account;
    }
/*
    static String inputPath = ".idea/src/App/Database/";

    public static void getUsernameInputAndCheckIfExists() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your username:");
        String userInputUsername = keyboard.next();
        File tmpFileObj = new File(inputPath + userInputUsername + ".json");
        if (tmpFileObj.exists()) {
            getPasswordInputAndCheckIfValid(userInputUsername);
        } else {
            System.out.println("No user registered with this username.");
            getUsernameInputAndCheckIfExists();
        }
        keyboard.close();
    }

    public static void getPasswordInputAndCheckIfValid(String username) {
        short numberOfFailedLogins = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your password:");
        String userInputPassword = keyboard.next();
        if (isPasswordCorrect(username, userInputPassword)) {
            System.out.println("You are successfully logged in.");
        } else {
            numberOfFailedLogins = +1;
            System.out.println("Benutzername oder Passwort nicht korrekt.");
            if (numberOfFailedLogins != 3) {
                getPasswordInputAndCheckIfValid(username);
            } else {
                // TODO: implement countdown
                return;
            }
        }
    }

    public static boolean isPasswordCorrect(String username, String password) {
        Account account = new Account();
        account = JsonLoader.ReadFromJson(username);
        return account.getPasswort().equals(password);
    }

 */
}
