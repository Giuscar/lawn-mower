package giuscar.blablacar.start;

import java.util.Arrays;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(String coordinates){
        Integer[] ints = formatLawnCoordinates(coordinates);
        if (ints[0] < 0 || ints[1] < 0)
            throw new IllegalArgumentException("Wrong inputs");
        this.x = ints[0];
        this.y = ints[1];
    }

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private Integer[] formatLawnCoordinates(String lawnCoordinates){

        return Arrays.stream(lawnCoordinates.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
