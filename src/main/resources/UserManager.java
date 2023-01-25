package src.main.resources;

import src.main.resources.Service.*;

public class UserManager {

    public static void main(String[] args){

        boolean exit = false;
        boolean loggedin = false;
        String Choice = null;
        Account userAccount = null;

        while (exit == false) {
            System.out.println("Willkommen bei RegistrationManager!");
            System.out.println("Wählen sie eine der folgenden Optionen aus:\n1: Registrieren\n2: Einloggen\n3: Schliessen");
            Choice = RegistrationManager.TerminalReader();


            switch (Choice) {


                case "1":
                    RegistrationManager.register();
                    break;
                case "2":
                    userAccount = LoginService.requestUserCredentials();

                    if (userAccount == null) {
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
                // System.out.println("Sie wurden eingeloggt");
                System.out.println("Wählen sie eine der folgenden Optionen aus:\n1: Passwort aendern\n2: Konto löschen\n3: Ausloggen");
                Choice = RegistrationManager.TerminalReader();

                switch(Choice) {

                    case "1":
                        PasswordChange.changePassword(userAccount);
                        break;

                    case "2":
                        RegistrationManager.DeleteAccount(userAccount);
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