package giuscar.blablacar.start;

import giuscar.blablacar.utils.InputFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lawn {

    private String filename;
    private List<Mower> mowers = new ArrayList<Mower>();
    private Coordinates lowerLeftCoordinates;

    public Lawn(String filename){
        try {
            if (filename.isEmpty())
                throw new IllegalArgumentException("Invalid argument!");

            List<String> lines = new InputFile("input.txt").readFile();
            int lineSize = lines.size();

            Coordinates lawnCoordinates = new Coordinates(lines.get(0));
            if (lawnCoordinates.getX() < 0 || lawnCoordinates.getY() < 0)
                throw new IllegalArgumentException("Invalid argument!");

            this.lowerLeftCoordinates = lawnCoordinates;

            for (int i = 1; i < lineSize; i += 2) {
                Mower mower = new Mower(lines.get(i), lines.get(i + 1), lawnCoordinates);
                this.mowers.add(mower);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void runMowers(){
        try {
            mowers.forEach(mower -> mower.executeCommands());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
