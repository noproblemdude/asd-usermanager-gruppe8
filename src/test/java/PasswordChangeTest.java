package src.test.java;

import src.main.java.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordChangeTest {  //generating test resulted in creating test cases for each individual method in the class. Lecturer said we should test the smallest components (unit testing). See passwordHasher test in RegistrationManagerTest.java

    @org.junit.jupiter.api.Test //polarity: negative
    void confirmEnteredPasswordsSame() {
        String initiallyEnteredPassword = "a1234";
        String secondlyEnteredPassword = "12345";
        boolean expected = false;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }
    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame2() { //Test polarity: positive
        String initiallyEnteredPassword = "1234b";
        String secondlyEnteredPassword = "1234b";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame3() { //polarity: positive (expected should be true)
        String initiallyEnteredPassword = "12345Ab";
        String secondlyEnteredPassword = "12345Ab";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame4() { //polarity: negative (the expected should be false)
        String initiallyEnteredPassword = "12345";
        String secondlyEnteredPassword = "1234A";
        boolean expected = false;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame5() { //polarity: positive (with null values)
        String initiallyEnteredPassword = "";
        String secondlyEnteredPassword = "";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame6() { //polarity: positive (with spaced values)
        String initiallyEnteredPassword = "Ax B4 C56";
        String secondlyEnteredPassword = "Ax B4 C56";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame7() { //polarity: positive (with special characters and spaces)
        String initiallyEnteredPassword = "/% +'&$$ß>";
        String secondlyEnteredPassword = "/% +'&$$ß>";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame8() { //polarity: positive (with special characters)
        String initiallyEnteredPassword = "%=§?'*;>!$";
        String secondlyEnteredPassword = "%=§?'*;>!$";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @Test
    void changePassword() { //we can try changing the password for a user and then try to login with the old pass. however this cannot be automatized with our system for now :/ (manual testing)
        Account testAccount = new Account();
        testAccount.setPassword("TestPassword");
        String expected = "TestPassword";
        //String expected = testAccount.password;
        assertEquals(expected,testAccount.getPassword());
    }

}

