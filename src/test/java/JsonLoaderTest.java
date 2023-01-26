package src.test.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import src.main.java.Service.*;

import org.junit.Test;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonLoaderTest {


    public boolean AuxTestSaveJson(String username){
        Account acc = new Account();
        acc.setUsername(username);

        JsonLoader.SaveJson(acc);

        File directoryPath = new File("src/main/resources/Database/");
        //List of all files and directories
        String contents[] = directoryPath.list();

        List<String> Accounts = Arrays.asList(contents);

        if(Accounts.contains(username+".json")){
            return true;
        }

        return false;
    }
    @Test
    public void testSaveJson() {

        assertEquals(true,AuxTestSaveJson("hihi"));
        assertEquals(true,AuxTestSaveJson("13469"));
        assertEquals(true,AuxTestSaveJson("blabla"));

    }
    public boolean AuxTestReadFromJson(String username){
        Account acc = new Account();
        acc.setUsername(username);
        JsonLoader.SaveJson(acc);

        return acc.getUsername().equals(JsonLoader.ReadFromJson(username).getUsername());


    }
    @Test
    public void testReadFromJson() {
        assertEquals(true,AuxTestReadFromJson("Maxi"));
        assertEquals(true,AuxTestReadFromJson("69387"));
        assertEquals(true,AuxTestReadFromJson("/§&$!"));
    }

    public boolean AuxTestFromJson(String jsonString,String username,String firstname,String lastname, String password){
        Account acc = new Account();
        Account acc2 = null;
        try {
            acc2 = JsonLoader.FromJson(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        acc.setUsername(username);
        acc.setFirstname(firstname);
        acc.setLastname(lastname);
        acc.setPassword(RegistrationManager.PasswordHasher(password));

        return acc.getUsername().equals(acc2.getUsername());
    }
    @Test
    public void testFromJson() {
        assertEquals(AuxTestFromJson("{\"firstname\":\"turgut\",\"lastname\":\"Aydemir\",\"username\":\"Turgut\",\"password\":\"c37bf859faf392800d739a41fe5af151\",\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false}","Turgut","turgut","Aydemir","98765"),true);
        assertEquals(AuxTestFromJson("{\"firstname\":\"Max\",\"lastname\":\"Musterman\",\"username\":\"MaxMus\",\"password\":\"c62921e93ffbb700e080d89c0b3fb314\",\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false}","MaxMus","Max","Musterman","abce2"),true);
    }

    public String AuxTestToJson(String username,String firstname,String lastname,String password){
        Account acc = new Account();
        acc.setUsername(username);
        acc.setFirstname(firstname);
        acc.setLastname(lastname);
        acc.setPassword(RegistrationManager.PasswordHasher(password));

        return JsonLoader.ToJson(acc);

    }
    @Test
    public void testToJson() {
        assertEquals(AuxTestToJson("Turgut","turgut","Aydemir","98765"),"{\"firstname\":\"turgut\",\"lastname\":\"Aydemir\",\"username\":\"Turgut\",\"password\":\"c37bf859faf392800d739a41fe5af151\",\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false}");
        assertEquals(AuxTestToJson("MaxMus","Max","Musterman","abce2"),"{\"firstname\":\"Max\",\"lastname\":\"Musterman\",\"username\":\"MaxMus\",\"password\":\"c62921e93ffbb700e080d89c0b3fb314\",\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false}");
    }

}
