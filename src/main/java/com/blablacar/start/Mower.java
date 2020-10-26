package com.blablacar.start;

import com.blablacar.utils.Constants;

public class Mower {

    private Coordinates coordinates, lawnCoordinates;
    private Orientation orientation;
    private char[] commands;

    /**
     * @param coordinatesAndOrientation
     * @param commands
     * @param lawnCoordinates
     */
    public Mower(String coordinatesAndOrientation, String commands, Coordinates lawnCoordinates){
        //If the coordinates don't respect the requirements, an IllegalArgumentException si thrown.
        if (!checkLawnCoordinates(lawnCoordinates)) {
            throw new IllegalArgumentException("Invalid lawn coordinates!");
        }

        this.lawnCoordinates = lawnCoordinates;
        this.commands = commands.toCharArray();
        this.coordinates = retrieveMowerCoordinates(coordinatesAndOrientation);
        this.orientation = retrieveOrientation(coordinatesAndOrientation);
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return orientation
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * @param lawnCoordinates
     * @return
     */
    private boolean checkLawnCoordinates(Coordinates lawnCoordinates){
        return (lawnCoordinates.getX() >= 0 &&
                lawnCoordinates.getY() >= 0);
    }

    /**
     * @param coordinatesAndOrientation
     * @return
     */
    private Coordinates retrieveMowerCoordinates(String coordinatesAndOrientation){
        String[] strings = coordinatesAndOrientation.split(" ");
        int x=0, y=0;

        /*If the number of elements is bigger than one defined in the constant
           NUMBER_OF_COORDINATES, it means the input file is wrong.*/
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

    /**
     * Checks the requirements are respected for mower coordinates.
     * @param x
     * @param y
     * @return boolean
     */
    private boolean validateMowerCoordinates(int x, int y){
        return ( x >= 0 &&
                x <= lawnCoordinates.getX() &&
                y >= 0 &&
                y <= lawnCoordinates.getY());
    }

    /**
     * @param coordinatesAndOrientation
     * @return string
     */
    private Orientation retrieveOrientation(String coordinatesAndOrientation){
        return Orientation.retrieveOrientationByVal(
                coordinatesAndOrientation.split(" ")[2]
        );
    }

    /**
     * Excution of the commands for one mower only.
     * @param grid
     */
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

    /**
     * Moving the mower to the next position based on its orientation. It's synchronized method,
     * because the grid matrix is modified into this method in case the mower will move to the next
     * position.
     * @param grid
     */
    private synchronized void moveToNextPosition(boolean[][] grid){
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
                if (validateMowerCoordinates(x-1, y) && !grid[x-1][y]) {
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
