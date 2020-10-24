package giuscar.blablacar;
import giuscar.blablacar.start.Coordinates;
import giuscar.blablacar.start.Mower;
import giuscar.blablacar.utils.InputFile;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> lines = new InputFile("input.txt").readFile();
            int lineSize = lines.size();
            Coordinates lawnCoordinates = new Coordinates(lines.get(0));
            ArrayList<Mower> mowers = new ArrayList<Mower>();

            for (int i = 1; i < lineSize; i += 2) {
                Mower mower = new Mower(lines.get(i), lines.get(i + 1), lawnCoordinates);
                mowers.add(mower);
            }

            for (Mower mower : mowers) {
                mower.executeCommands();
                System.out.println(mower.getCoordinates().getX() + " " + mower.getCoordinates().getY() + " " + mower.getOrientation());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
