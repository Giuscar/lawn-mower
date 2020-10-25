package giuscar.blablacar.start;

import giuscar.blablacar.utils.Constants;

public class Mower {

    private Coordinates coordinates, lawnCoordinates;
    private Orientation orientation;
    private char[] commands;

    public Mower(String coordinatesAndOrientation, String commands, Coordinates lowerLeftCoordinates){
        if (!checkLawnCoordinates(lowerLeftCoordinates)) {
            throw new IllegalArgumentException("Invalid Arguments");
        }

        this.lawnCoordinates = lowerLeftCoordinates;
        this.coordinates = retrieveMowerCoordinates(coordinatesAndOrientation);
        this.orientation = retrieveOrientation(coordinatesAndOrientation);
        this.commands = commands.toCharArray();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private Boolean checkLawnCoordinates(Coordinates lawnCoordinates){
        Boolean isValidCoordinate = false;

        if (lawnCoordinates.getX() > 0 && lawnCoordinates.getY() > 0)
            isValidCoordinate = true;

        return isValidCoordinate;
    }

    private Coordinates retrieveMowerCoordinates(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        int x=0, y=0;
        if (strings.length > Constants.NUMBER_OF_COORDINATES) {
            try {
                x = Integer.parseInt(strings[0]);
                y = Integer.parseInt(strings[1]);
                return new Coordinates(x, y);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Error while formatting mower coordinates");
            }
        }
        throw new IllegalArgumentException("Invalid mower coordinates");
    }

    private Orientation retrieveOrientation(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        return Orientation.retrieveOrientationByVal(strings[2]);
    }

    public void executeCommands(){
        for(char command: commands)
        {
            Command c = Command.retrieveCommandByCommand(command+"");
            switch (c){
                case LEFT:
                    this.orientation = this.orientation.rotateToLeft();
                    break;
                case FORWARD:
                    moveToNextPosition();
                    break;
                case RIGHT:
                    this.orientation = this.orientation.rotateToRight();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong command");
            }
        }
        System.out.println(getCoordinates().getX() + " " + getCoordinates().getY() + " " + getOrientation().getVal());
    }

    public void moveToNextPosition(){
        int x = coordinates.getX(), y = coordinates.getY();
        switch (orientation){
            case N:
                coordinates.setY(y + 1);
                break;
            case S:
                coordinates.setY(y - 1);
                break;
            case E:
                coordinates.setX(x + 1);
                break;
            case W:
                coordinates.setX(x - 1);
                break;
            default:
                throw new IllegalArgumentException("Wrong command");
        }
    }
}
