package giuscar.blablacar.utils;

import giuscar.blablacar.start.Orientation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputFileTest {

    @Test
    void readFile() {
        //Passing a wrong file name use case
        assertDoesNotThrow(() -> new InputFile("badFile.txt").readFile());

        //Successful use case
        List<String> lines = new InputFile("test/resources/input.txt").readFile();
        assertEquals(lines.get(0), "5 5");
        assertEquals(lines.get(1), "1 2 N");
        assertEquals(lines.get(2), "LFLFLFLFF");
        assertEquals(lines.get(3), "3 3 E");
        assertEquals(lines.get(4), "FFRFFRFRRF");
    }
}