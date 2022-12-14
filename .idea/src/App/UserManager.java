package App;

import java.io.File;
import java.util.Scanner;
import App.*;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class UserManager {

    public static void main(String args[]){

        boolean exit = false;
        boolean loggedin = false;
        String Choice = null;
        Account UserAccount = null;

        while (exit == false) {
            System.out.println("Willkommen bei RegistrationManager!");
            System.out.println("Wählen sie eine der folgenden Optionen aus: 1:Registrieren,2:Einloggen,3:Schliessen");
            Choice = RegistrationManager.TerminalReader();


            switch (Choice) {


                case "1":
                    RegistrationManager.register();
                    break;
                case "2":
                    UserAccount = LoginService.requestUserCredentials();

                    if (UserAccount == null) {
                        loggedin = false;
                    } else {
                        loggedin = true;
                    }
                    break;

                case "3":
                    System.out.println("Auf wiedersehen");
                    exit = true;
                    break;

                default:
                    System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
            }


            while(loggedin){
                System.out.println("Sie wurden eingeloggt");
                System.out.println("Wählen sie eine der folgenden Optionen aus: 1:Passwort aendern,2:Konto löschen,3:Ausloggen");
                Choice = RegistrationManager.TerminalReader();

                switch(Choice) {

                    case "1":
                        PasswordChange.changePassword(UserAccount);
                        break;

                    case "2":
                        RegistrationManager.DeleteAccount(UserAccount);
                        loggedin = false;
                        break;

                    case "3":
                        loggedin = false;
                        System.out.println("Sie wurden ausgeloggt");
                        break;

                    default:
                        System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
                }

            }
        }
    }
}