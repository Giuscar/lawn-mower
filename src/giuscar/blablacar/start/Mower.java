package giuscar.blablacar.start;

import giuscar.blablacar.utils.Constants;

public class Mower {

    private Coordinates coordinates, lawnCoordinates;
    private Orientation orientation;
    private char[] commands;

    public Mower(String coordinatesAndOrientation, String commands, Coordinates lawnCoordinates){
        if (!checkLawnCoordinates(lawnCoordinates)) {
            throw new IllegalArgumentException("Invalid lawn coordinates!");
        }

        this.lawnCoordinates = lawnCoordinates;
        this.commands = commands.toCharArray();
        this.coordinates = retrieveMowerCoordinates(coordinatesAndOrientation);
        this.orientation = retrieveOrientation(coordinatesAndOrientation);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private Boolean checkLawnCoordinates(Coordinates lawnCoordinates){

        return lawnCoordinates.getX() > 0 && lawnCoordinates.getY() > 0;
    }

    private Coordinates retrieveMowerCoordinates(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        int x=0, y=0;
        if (strings.length > Constants.NUMBER_OF_COORDINATES) {
            try {
                x = Integer.parseInt(strings[0]);
                y = Integer.parseInt(strings[1]);
                if (validateMowerCoordinates(x, y))
                    return new Coordinates(x, y);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Error while formatting mower coordinates");
            }
        }
        throw new IllegalArgumentException("Invalid mower coordinates");
    }

    private Boolean validateMowerCoordinates(int x, int y){
        return ( x >= 0 &&
                x <= lawnCoordinates.getX() &&
                y >= 0 &&
                y <= lawnCoordinates.getY());
    }

    private Orientation retrieveOrientation(String coordinatesAndOrientation){
        return Orientation.retrieveOrientationByVal(
                coordinatesAndOrientation.split(" ")[2]
        );
    }

    public void executeCommands(boolean[][] grid){
        for(char command: commands)
        {
            try {
                Command c = Command.retrieveCommandByVal(command + "");
                switch (c) {
                    case LEFT:
                        this.orientation = this.orientation.rotateToLeft();
                        break;
                    case FORWARD:
                        moveToNextPosition(grid);
                        break;
                    case RIGHT:
                        this.orientation = this.orientation.rotateToRight();
                        break;
                    default:
                        throw new IllegalArgumentException("Wrong command");
                }
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }

        System.out.println(getCoordinates().getX() + " " + getCoordinates().getY() + " " + getOrientation());
    }

    private void moveToNextPosition(boolean[][] grid){
        int x = coordinates.getX(), y = coordinates.getY();
        switch (orientation){
            case N:
                if (validateMowerCoordinates(x, y+1) && !grid[x][y+1]) {
                    grid[x][y] = false;
                    grid[x][y+1] = true;
                    coordinates.setY(y + 1);
                }
                break;
            case S:
                if (validateMowerCoordinates(x, y-1) && !grid[x][y - 1]) {
                    grid[x][y] = false;
                    grid[x][y-1] = true;
                    coordinates.setY(y - 1);
                }
                break;
            case E:
                if (validateMowerCoordinates(x+1, y) && !grid[x+1][y]) {
                    grid[x][y] = false;
                    grid[x+1][y] = true;
                    coordinates.setX(x + 1);
                }
                break;
            case W:
                if (validateMowerCoordinates(x-1, y)&& !grid[x-1][y]) {
                    grid[x][y] = false;
                    grid[x-1][y] = true;
                    coordinates.setX(x - 1);
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong command");
        }
    }
}
