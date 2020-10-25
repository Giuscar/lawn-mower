package giuscar.blablacar;
import giuscar.blablacar.start.Coordinates;
import giuscar.blablacar.start.Lawn;
import giuscar.blablacar.start.Mower;
import giuscar.blablacar.utils.InputFile;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Lawn lawn = new Lawn("input.txt");
            lawn.runMowers();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
