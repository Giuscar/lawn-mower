package giuscar.blablacar.start;

import java.util.Arrays;

public class Mower {
    private Coordinates coordinates;
    private Orientation orientation;
    private char[] commands;

    public Mower(String coordinatesAndOrientation, String commands, Coordinates lowerLeftCoordinates){
        this.coordinates = retrieveCoordinates(coordinatesAndOrientation);
        this.orientation = retrieveOrientation(coordinatesAndOrientation);
        this.commands = commands.toCharArray();
    }

    private Coordinates retrieveCoordinates(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        int x=0, y=0;
        if (strings.length > 2) {
            try {
                x = Integer.parseInt(strings[0]);
                y = Integer.parseInt(strings[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Coordinates");
            }
        }
        return new Coordinates(x, y);
    }

    private Orientation retrieveOrientation(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        return Orientation.retrieveOrientationByVal(strings[2]);
    }
}
