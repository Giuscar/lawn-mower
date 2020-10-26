package com.blablacar.start;

import java.util.Arrays;

public class Coordinates {

    private int x;
    private int y;

    /**
     * This constructor executes the following steps:
     * @param coordinates
     */
    public Coordinates(String coordinates){
        /*
         * Conversion of a string (containing x and y coordinates) into an array of integers.
         * In case the two coordinates are < 0, an IllegalArgumentException is thrown.
         */
        Integer[] ints = formatLawnCoordinates(coordinates);
        if (ints[0] < 0 || ints[1] < 0)
            throw new IllegalArgumentException("Wrong inputs");

        this.x = ints[0];
        this.y = ints[1];
    }

    /**
     * @param x
     * @param y
     */
    public Coordinates(int x, int y){
        //In case the two coordinates are < 0, an IllegalArgumentException is thrown.
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Wrong inputs");

        this.x = x;
        this.y = y;
    }

    /**
     * Update of X coordinate whose value always needs to be > 0. In case this
     * requirement is not respected an IllegalArgumentException is thrown.
     * @param x
     */
    public void setX(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Wrong X coordinate");
        this.x = x;
    }

    /**
     * Update of Y coordinate whose value always needs to be > 0. In case this
     * requirement is not respected an IllegalArgumentException is thrown.
     * @param y
     */
    public void setY(int y) {
        if (y < 0)
            throw new IllegalArgumentException("Wrong Y coordinate");
        this.y = y;
    }

    /**
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Conversion of a string into an array of integers.
     * Ex.
     *     "1 2"  ====> [1, 2]
     * @param lawnCoordinates
     * @return Integer[]
     */
    private Integer[] formatLawnCoordinates(String lawnCoordinates){

        return Arrays.stream(lawnCoordinates.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
