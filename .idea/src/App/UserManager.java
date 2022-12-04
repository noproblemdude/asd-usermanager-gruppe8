package App;

import java.io.File;
import java.util.Scanner;
import App.*;
import App.common.*;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class UserManager {
    //TODO: set inputPath or save as separate parameter file and convert it to constant
    static String inputPath = "";
    public static void getUsernameInputAndCheckIfExists() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your username:");
        String userInputUsername = keyboard.next();
        File tmpFileObj = new File(inputPath + userInputUsername + ".json");
        if (!tmpFileObj.exists()) {
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

    public static void main(String args[]){
        boolean exit = false;
        while (exit == false){

        }

    }
}
