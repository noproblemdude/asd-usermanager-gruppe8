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
            System.out.println("Wählen sie eine der folgenden Optionen aus: 1:Registrieren,2:Einloggen,3:Schliessen");
            Choice = RegistrationManager.TerminalReader();


                if(Choice=="1") {
                    RegistrationManager.register();
                }
                if(Choice=="2") {
                    UserAccount = LoginService.requestUserCredentials();

                    if (UserAccount == null) {
                        loggedin = false;
                    } else {
                        loggedin = true;
                    }
                }
                if(Choice=="3") {
                    System.out.println("Auf wiedersehen");
                    exit = true;
                }

                else{
                    System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
                }

            while(loggedin){
                System.out.println("Sie wurden eingeloggt");
                System.out.println("Wählen sie eine der folgenden Optionen aus: 1:Passwort aendern,2:Konto löschen,3:Ausloggen");
                Choice = RegistrationManager.TerminalReader();

               if(Choice=="1") {
                       PasswordChange.changePassword(UserAccount);
               }
                if(Choice=="2") {
                        RegistrationManager.DeleteAccount(UserAccount);
                        loggedin = false;
                }
                if(Choice=="3") {
                        loggedin = false;
                        System.out.println("Sie wurden ausgeloggt");
                }
                else{
                        System.out.println("Dies ist keine gültige Option, bitte nochmal versuchen");
                }


            }
        }
    }
}
