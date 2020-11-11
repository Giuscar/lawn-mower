package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {
    private Command expectedCommand, returnedCommand;

    @Test
    void getCommand() {
        //Successful use case
        expectedCommand = Command.LEFT;
        returnedCommand = Command.retrieveCommandByVal("L");
        assertEquals(expectedCommand.getCommand(), returnedCommand.getCommand());

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Command.retrieveCommandByVal("P").getCommand(),
                "Invalid command"
        );
    }

    @Test
    void retrieveCommandByVal() {
        //Successful use case
        expectedCommand = Command.LEFT;
        returnedCommand = Command.retrieveCommandByVal("L");
        assertEquals(expectedCommand, returnedCommand);

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Command.retrieveCommandByVal("P"),
                "Invalid command"
        );
    }
}
