package com.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    private Orientation expectedOrientation, returnedOrientation;

    @Test
    void rotateToLeft() {

        //Rotation to left: N->W
        expectedOrientation = Orientation.W;
        returnedOrientation = Orientation.retrieveOrientationByVal("N").rotateToLeft();
        assertEquals(returnedOrientation, expectedOrientation);

        //Rotation to left: W->S
        expectedOrientation = Orientation.S;
        returnedOrientation = Orientation.retrieveOrientationByVal("W").rotateToLeft();
        assertEquals(returnedOrientation, Orientation.S);

        //Wrong orientation value:
        assertThrows(
                IllegalArgumentException.class,
                () -> Orientation.retrieveOrientationByVal("P").rotateToLeft(),
                "Invalid orientation argument!"
        );
    }

    @Test
    void rotateToRight() {
        //Rotation to right: N->E
        expectedOrientation = Orientation.E;
        returnedOrientation = Orientation.retrieveOrientationByVal("N").rotateToRight();
        assertEquals(returnedOrientation, expectedOrientation);

        //Rotation to right: W->N
        expectedOrientation = Orientation.N;
        returnedOrientation = Orientation.retrieveOrientationByVal("W").rotateToRight();
        assertEquals(returnedOrientation, expectedOrientation);

        //Wrong orientation value:
        assertThrows(
                IllegalArgumentException.class,
                () -> Orientation.retrieveOrientationByVal("P").rotateToRight(),
                "Invalid orientation argument!"
        );
    }

    @Test
    void getVal() {
        //Successful use case
        expectedOrientation = Orientation.N;
        returnedOrientation = Orientation.retrieveOrientationByVal("N");
        assertEquals(expectedOrientation.getVal(), returnedOrientation.getVal());

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Orientation.retrieveOrientationByVal("P").getVal(),
                "Invalid orientation argument!"
        );
    }

    @Test
    void retrieveOrientationByVal() {
        //Successful use case
        expectedOrientation = Orientation.N;
        returnedOrientation = Orientation.retrieveOrientationByVal("N");
        assertEquals(expectedOrientation, returnedOrientation);

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Orientation.retrieveOrientationByVal("P"),
                "Invalid orientation argument!"
        );
    }
}