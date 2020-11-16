package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {
    private Mower mower;
    private boolean[][] grid;

    MowerTest(){
        mower = new Mower("1 2 N", "FFFFFFFFFFFFF", new Coordinates(5,5));
        grid = initGrid();
    }

    @Test
    void executeCommands() {

        mower.executeCommands(grid);
        assertEquals(mower.getCoordinates().getX(), 1);
        assertEquals(mower.getCoordinates().getY(), 5);
        assertEquals(mower.getOrientation(), Orientation.N);

        //Use case 2: exception x lawn coordinates.
        assertThrows(
                IllegalArgumentException.class,
                () -> new Mower("-1 2 N", "FFFFFFFFFFFFF", new Coordinates(5,5)),
                "Invalid mower coordinates!"
        );

        //Use case 2: exception y lawn coordinates.
        assertThrows(
                IllegalArgumentException.class,
                () -> new Mower("1 -2 N", "FFFFFFFFFFFFF", new Coordinates(5,5)),
                "Invalid mower coordinates!"
        );

        //Use case 3: invalid lawn orientation
        assertThrows(
                IllegalArgumentException.class,
                () -> new Mower("1 2 P", "FFFFFFFFFFFFF", new Coordinates(5,5)),
                "Invalid orientation argument"
        );

        //Use case 4: wrong lawn coordinates
        assertThrows(
                IllegalArgumentException.class,
                () -> new Mower("1 2 N", "FFFFFFFFFFFFF", new Coordinates(-90,90)),
                "Invalid lawn coordinates!"
        );
    }

    @Test
    void getFormattedPosition()
    {
        String expectedString = "1 2 N";
        String stringToPrint = mower.getFormattedPosition();
        assertEquals(expectedString.length(), stringToPrint.length());
        assertEquals(expectedString, stringToPrint);
    }


    private boolean[][] initGrid() {
        boolean[][] grid = new boolean[6][6];
        for (int i = 0; i < 5; i ++){
            for (int j = 0; j < 5; j++)
                grid[i][j] = false;
        }
        grid[1][2] = true;

        return grid;
    }
}