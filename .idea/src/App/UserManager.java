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

        while (exit == false){
            System.out.println("Willkommen bei RegistrationManager!");
            System.out.println("Wählen sie eine der folgenden Optionen aus: Registrieren, Einloggen,Schliessen");
            Choice = RegistrationManager.TerminalReader();

            switch(Choice) {
                case "Registrieren":
                    RegistrationManager.register();
                case "Einloggen":
                    if(UserAccount==null){
                        loggedin = false;
                    }
                    else {
                        loggedin = true;
                    }

                case "Schliessen":
                    System.out.println("Auf wiedersehen");
                    exit = true;
                default:
                    System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
            }

            while(loggedin){
                System.out.println("Sie wurden eingeloggt");
                System.out.println("Wählen sie eine der folgenden Optionen aus: Passwort aendern,Konto löschen,Ausloggen");

                switch(Choice) {
                    case "Passwort aendern":

                    case "Konto löschen":
                        RegistrationManager.DeleteAccount(UserAccount);
                        loggedin = false;
                    case "Ausloggen":
                        loggedin = false;
                        System.out.println("Sie wurden ausgeloggt");
                    default:
                        System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
                }


            }
        }
    }
}
