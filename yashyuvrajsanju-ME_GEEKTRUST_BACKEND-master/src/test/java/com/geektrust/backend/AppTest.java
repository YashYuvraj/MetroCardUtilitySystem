package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("App Test")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test #1")
    public void Application_Test() throws Exception{
        // Arrange
          
        List<String> arguments= new ArrayList<>(List.of("sample_input/input2.txt"));
        String expectedOutput="TOTAL_COLLECTION CENTRAL 457 50\n"+
        "PASSENGER_TYPE_SUMMARY\n"+
        "ADULT 2\n"+
        "SENIOR_CITIZEN 1\n"+
        "TOTAL_COLLECTION AIRPORT 252 100\n"+
        "PASSENGER_TYPE_SUMMARY\n"+
        "ADULT 1\n"+
        "KID 1\n"+
        "SENIOR_CITIZEN 1";

        // Act 
        App.run(arguments);
        
     // Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

   

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
