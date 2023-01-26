package src.main.java.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonLoader {

    public static Account FromJson(String JsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account Acc = mapper.readValue(JsonString, Account.class);
        return Acc;
    }

    public static String ToJson(Account Acc){
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(Acc);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }

    public static void SaveJson(Account Acc){

        String JsonString = ToJson(Acc);

        try {
            FileWriter myWriter = new FileWriter("src/main/resources/Database/"+Acc.getUsername()+".json");
            myWriter.write(JsonString);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ein Fehler ist aufgetreten");
            e.printStackTrace();
        }


    }

    public static Account ReadFromJson(String AccName) {
        String jsonString = null;
        try {
            File myObj = new File("src/main/resources/Database/"+AccName+".json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                jsonString = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ein Fehler ist aufgetreten");
            e.printStackTrace();
        }

        try {
            return FromJson(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
