package giuscar.blablacar.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void rotateToLeft() {
        //Rotation to left: N->W
        assertEquals(Orientation.retrieveOrientationByVal("N").rotateToLeft(), Orientation.W);

        //Rotation to left: W->S
        assertEquals(Orientation.retrieveOrientationByVal("W").rotateToLeft(), Orientation.S);

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
        assertEquals(Orientation.retrieveOrientationByVal("N").rotateToRight(), Orientation.E);

        //Rotation to right: W->N
        assertEquals(Orientation.retrieveOrientationByVal("W").rotateToRight(), Orientation.N);

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
        Orientation expectedOrientation = Orientation.N;
        Orientation returnedOrientation = Orientation.retrieveOrientationByVal("N");
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
        Orientation expectedOrientation = Orientation.N;
        Orientation returnedOrientation = Orientation.retrieveOrientationByVal("N");
        assertEquals(expectedOrientation, returnedOrientation);

        //Failure use case
        assertThrows(
                IllegalArgumentException.class,
                () -> Orientation.retrieveOrientationByVal("P"),
                "Invalid orientation argument!"
        );
    }
}