package giuscar.blablacar.start;

import giuscar.blablacar.utils.InputFile;
import java.util.ArrayList;
import java.util.List;

public class Lawn {

    private List<Mower> mowers = new ArrayList<Mower>();
    private Coordinates lowerLeftCoordinates;

    public Lawn(String filename){
        if (filename.isEmpty())
            throw new IllegalArgumentException("Invalid argument!");

        List<String> lines = new InputFile(filename).readFile();
        int lineSize = lines.size();

        Coordinates lawnCoordinates = new Coordinates(lines.get(0));
        if (lawnCoordinates.getX() < 0 || lawnCoordinates.getY() < 0)
            throw new IllegalArgumentException("Invalid lawn coordinates!");

        this.lowerLeftCoordinates = lawnCoordinates;

        for (int i = 1; i < lineSize; i += 2) {
            try {
                Mower mower = new Mower(lines.get(i), lines.get(i + 1), lawnCoordinates);
                this.mowers.add(mower);
            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }

    public void runMowers(){
        try {
            mowers.forEach(mower -> mower.executeCommands());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
