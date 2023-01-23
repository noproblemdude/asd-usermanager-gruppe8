package App;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class JsonLoader{

    //Auxiliary Function to convert a json String to a java class(Account)
    public static Account FromJson(String JsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account Acc = mapper.readValue(JsonString, Account.class);
        return Acc;
    }

    //Auxiliary class to convert a Java class(account) into a json string
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

    //takes an Account class, converts it to a Json string and saves it into a file in teh database directory
    public static void SaveJson(Account Acc){

        String JsonString = ToJson(Acc);

        try {
            FileWriter myWriter = new FileWriter(".idea/src/App/Database/"+Acc.getUsername()+".json");
            myWriter.write(JsonString);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ein Fehler ist aufgetreten");
            e.printStackTrace();
        }


    }

    //Reads the file from the database directory with the name "AccName" and turns the Json String in the file into a Java class (Account)
    public static Account ReadFromJson(String AccName) {
        String jsonString = null;
        try {
            File myObj = new File(".idea/src/App/Database/"+AccName+".json");
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
