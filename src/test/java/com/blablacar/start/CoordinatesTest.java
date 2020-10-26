package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void setX() {
        Coordinates coordinate = new Coordinates(1, 1);

        //Passing negative X coordinates
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setX(-1),
                "Wrong X coordinate"
        );

    }

    @Test
    void setY() {
        Coordinates coordinate = new Coordinates(1, 1);
        //Passing Wrong Y coordinates
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setY(-1),
                "Wrong Y coordinate"
        );
    }

    @Test
    void getX() {
        Coordinates coordinate = new Coordinates(1, 1);
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
        Coordinates coordinate = new Coordinates(1, 1);
        //Verify the value is unchanged after having set up a negative Y coordinate.
        assertThrows(
                IllegalArgumentException.class,
                () ->coordinate.setY(-1),
                "Wrong X coordinate"
        );

        assertEquals(coordinate.getY(), 1);
    }
}