package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getCommand() {
        //Successful use case
        Command expectedCommand = Command.LEFT;
        Command returnedCommand = Command.retrieveCommandByVal("L");
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
        Command expectedCommand = Command.LEFT;
        Command returnedCommand = Command.retrieveCommandByVal("L");
        assertEquals(expectedCommand, returnedCommand);

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Command.retrieveCommandByVal("P"),
                "Invalid command"
        );
    }
}
