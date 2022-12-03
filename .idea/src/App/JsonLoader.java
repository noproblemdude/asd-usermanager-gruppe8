package App;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import App.common.*;

public class JsonLoader{
    public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
        Account Acc1 = new Account();
        Acc1.setBenutzername("Musterman");
        SaveJson(Acc1);
        Account Acc2 = ReadFromJson("Musterman");
    }

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


        File myObj = new File("C:\\Users\\leona\\IdeaProjects\\asd-usermanager-gruppe8\\.idea\\src\\App\\Database\\"+Acc.getBenutzername()+".json");

        String JsonString = ToJson(Acc);

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\leona\\IdeaProjects\\asd-usermanager-gruppe8\\.idea\\src\\App\\Database\\"+Acc.getBenutzername()+".json");
            myWriter.write(JsonString);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static Account ReadFromJson(String AccName) {
        String jsonString = null;
        try {
            File myObj = new File("C:\\Users\\leona\\IdeaProjects\\asd-usermanager-gruppe8\\.idea\\src\\App\\Database\\" + AccName + ".json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                jsonString = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            return FromJson(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
