package giuscar.blablacar.start;

public class Mower {

    private Coordinates coordinates, lawnCoordinates;
    private Orientation orientation;
    private char[] commands;

    public Mower(String coordinatesAndOrientation, String commands, Coordinates lowerLeftCoordinates){
        this.coordinates = retrieveCoordinates(coordinatesAndOrientation);
        this.orientation = retrieveOrientation(coordinatesAndOrientation);
        this.commands = commands.toCharArray();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
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
                    System.out.println("Wrong command");
            }
        }
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
        }
    }

}
