package giuscar.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void executeCommands() {

        //Use case 1: the mower will stop at position 1 4 N
        Mower mower_case_1 = new Mower("1 2 N", "FFFFFFFFFFFFF", new Coordinates(5,5));
        mower_case_1.executeCommands();
        assertEquals(mower_case_1.getCoordinates().getX(), 1);
        assertEquals(mower_case_1.getCoordinates().getY(), 5);
        assertEquals(mower_case_1.getOrientation(), Orientation.N);

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
}