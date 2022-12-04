package App;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.security.MessageDigest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RegistrationManager {


    public static void register(){
        String Vorname = null;
        String Nachname = null;
        String Benutzername = null;
        String Passwort = null;

        //Creating a File object for directory
        File directoryPath = new File(".idea/src/App/Database/");
        //List of all files and directories
        String contents[] = directoryPath.list();

        List<String> Accounts =Arrays.asList(contents);

        System.out.println("Bitte gib einen Benutzernamen ein");
        Benutzername = TerminalReader();

        if(Accounts.contains(Benutzername+".json")){
            System.out.println("Benutzername ist schon vergeben");
        }
        else {
            Account Acc = new Account();

            System.out.println("Bitte gib deinen Vornamen ein");
            Vorname = TerminalReader();
            Acc.setVorname(Vorname);
            System.out.println("Bitte gib deinen Nachnamen ein");
            Nachname = TerminalReader();
            Acc.setNachname(Nachname);
            Acc.setBenutzername(Benutzername);
            System.out.println("Bitte gib einen Passwort ein");
            Passwort = TerminalReader();
            Acc.setPasswort(PasswordHasher(Passwort));

            JsonLoader.SaveJson(Acc);

            System.out.println("Account wurde angelegt!");

        }

    }

    public static void DeleteAccount(Account Acc){
        File myObj = new File(".idea/src/App/Database/"+Acc.getBenutzername()+".json");
        System.out.println("enter your password");
        String passwordHashed = RegistrationManager.PasswordHasher(RegistrationManager.TerminalReader());
        if (passwordHashed.equals(Acc.getPasswort())){
            if (myObj.delete()) {
                System.out.println("konto wurde gelöscht");}
            else {
            System.out.println("Konto konnte nicht gelöscht werden");
            }}
        else{
            System.out.println("password is not correct");
            }
    }

    public static String PasswordHasher(String Password){
        StringBuilder sb = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(Password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    public static String TerminalReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String Input;

        try {
            Input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Input;
    }


}
