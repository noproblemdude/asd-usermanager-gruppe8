package src.test.java;

import src.main.java.Service.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationManagerTest {

    boolean AuxTestDeleteAccount(String username){
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(username.getBytes());
        System.setIn(in);

        Account acc = new Account();
        acc.setUsername(username);

        JsonLoader.SaveJson(acc);

        RegistrationManager.DeleteAccount(acc);

        System.setIn(sysInBackup);

        File directoryPath = new File(".idea/src/App/Database/");
        //List of all files and directories
        String contents[] = directoryPath.list();

        List<String> Accounts = Arrays.asList(contents);

        if(Accounts.contains(username+".json")){
            return false;
        }

        return true;

    }
    @Test
<<<<<<< HEAD:src/test/java/RegistrationManagerTest.java
    public void passwordHasher() {
        String enteredPassword = "1234";
        String hashedPass = RegistrationManager.PasswordHasher(enteredPassword);
        String expected = "81dc9bdb52d04dc20036dbd8313ed055";
        assertEquals(expected,hashedPass);
=======
    void testDeleteAccount() {

        assertEquals(false,AuxTestDeleteAccount("papapa"));
        assertEquals(true,AuxTestDeleteAccount("9856213696"));
        assertEquals(true,AuxTestDeleteAccount("($§)§$/("));

    }

    void testPasswordHasher() {

        assertEquals("69cfe5c6868bee77e441981d6e015fca",RegistrationManager.PasswordHasher("68945642"));
        assertEquals("e64dbaf67dbceb08c17425587133f2eb",RegistrationManager.PasswordHasher("alahsder"));
        assertEquals("383c9f5f9ecef488877844c2d7053709",RegistrationManager.PasswordHasher("$(§)&$§$"));

    }

    boolean AUXTestTerminalReader(String input){
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean output = input.equals(RegistrationManager.TerminalReader());

        System.setIn(sysInBackup);

        return output;


    }
    void testTerminalReader() {

        assertEquals(true,AUXTestTerminalReader("hallo"));
        assertEquals(true,AUXTestTerminalReader("dskjalfd"));
        assertEquals(true,AUXTestTerminalReader("($&%$)$)=/)"));


>>>>>>> 5f22af9f3f7f1b5f1b99db0fed9b8a464a1ad2b8:.idea/src/App/RegistrationManagerTest.java
    }
}