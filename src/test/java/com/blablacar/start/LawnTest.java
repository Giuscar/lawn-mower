package com.blablacar.start;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void runMowersSuccess() {
        //Basic successful usecase
        List<Mower> mowers = new ArrayList<Mower>();
        Lawn lawnSuccess = new Lawn("src/test/resources/input.txt");
        lawnSuccess.runMowers();
        mowers = lawnSuccess.getMowers();

        assertEquals(mowers.get(0).getCoordinates().getX(), 1);
        assertEquals(mowers.get(0).getCoordinates().getY(), 3);
    }

    @Test
    void runMowersFailures(){
        //Passing Wrong coordinates
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lawn("src/test/resources/invalid_lawn_coordinates.txt").runMowers(),
                "Invalid lawn coordinates"
        );
    }
}