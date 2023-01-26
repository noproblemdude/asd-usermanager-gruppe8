package App.Tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import App.*;
import org.junit.jupiter.api.Test;
import App.Service.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonLoaderTest {


    boolean AuxTestSaveJson(String username){
        Account acc = new Account();
        acc.setUsername(username);

        JsonLoader.SaveJson(acc);

        File directoryPath = new File(".idea/src/App/Database/");
        //List of all files and directories
        String contents[] = directoryPath.list();

        List<String> Accounts = Arrays.asList(contents);

        if(Accounts.contains(username+".json")){
            return true;
        }

        return false;
    }

    @Test
    void testSaveJson() {
        assertEquals(true,AuxTestSaveJson("hihi"));
        assertEquals(true,AuxTestSaveJson("13469"));
        assertEquals(true,AuxTestSaveJson("blabla"));

    }

    boolean AuxTestReadFromJson(String username){
        Account acc = new Account();
        acc.setUsername(username);
        JsonLoader.SaveJson(acc);

        return acc.getUsername().equals(JsonLoader.ReadFromJson(username).getUsername());

    }

    @Test
    void testReadFromJson() {
        assertEquals(true,AuxTestReadFromJson("Maxi"));
        assertEquals(true,AuxTestReadFromJson("69387"));
        assertEquals(true,AuxTestReadFromJson("/§&$!"));
    }


    boolean AuxTestFromJson(String jsonString,String username,String firstname,String lastname, String password){
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
        acc.setPassword(password);

        return acc.getUsername().equals(acc2.getUsername());
    }
    void testFromJson() {
        assertEquals(AuxTestFromJson("{\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false,\"passwort\":\"c37bf859faf392800d739a41fe5af151\",\"nachname\":\"Aydemir\",\"vorname\":\"turgut\",\"benutzername\":\"Turgut\"}","Turgut","turgut","Aydemir","98765"),true);
        assertEquals(AuxTestFromJson("{\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false,\"passwort\":\"c62921e93ffbb700e080d89c0b3fb314\",\"nachname\":\"Musterman\",\"vorname\":\"Max\",\"benutzername\":\"MaxMus\"}","MaxMus","Max","Musterman","abce2"),true);
    }

    String AuxTestToJson(String username,String firstname,String lastname,String password){
        Account acc = new Account();
        acc.setUsername(username);
        acc.setFirstname(firstname);
        acc.setLastname(lastname);
        acc.setPassword(password);

        return JsonLoader.ToJson(acc);

    }
    void testToJson() {
        assertEquals(AuxTestToJson("Turgut", "turgut", "Aydemir", "98765"), "{\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false,\"passwort\":\"c37bf859faf392800d739a41fe5af151\",\"nachname\":\"Aydemir\",\"vorname\":\"turgut\",\"benutzername\":\"Turgut\"}");
        assertEquals(AuxTestToJson("MaxMus", "Max", "Musterman", "abce2"), "{\"numberOfFailedLogins\":0,\"dateTimeWhenUserWasLocked\":null,\"dateTimeTillUserWasLocked\":null,\"isLocked\":false,\"passwort\":\"c62921e93ffbb700e080d89c0b3fb314\",\"nachname\":\"Musterman\",\"vorname\":\"Max\",\"benutzername\":\"MaxMus\"}");
    }
}
