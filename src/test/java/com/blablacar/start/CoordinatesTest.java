package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private Coordinates coordinate;
    CoordinatesTest(){
        coordinate = new Coordinates(1, 1);
    }

    @Test
    void setX() {
        //Passing negative X coordinates
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setX(-1),
                "Wrong X coordinate"
        );
    }

    @Test
    void setY() {
        //Passing Wrong Y coordinates
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setY(-1),
                "Wrong Y coordinate"
        );
    }

    @Test
    void getX() {
        //Verify the value is unchanged after having set up a negative X coordinate.
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setX(-1),
                "Wrong X coordinate"
        );

        assertEquals(coordinate.getX(), 1);
    }

    @Test
    void getY() {
        //Verify the value is unchanged after having set up a negative Y coordinate.
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setY(-1),
                "Wrong Y coordinate"
        );

        assertEquals(coordinate.getY(), 1);
    }
}
