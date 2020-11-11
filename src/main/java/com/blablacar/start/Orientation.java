package com.blablacar.start;
/**
 * This enum class represents the list of possible mower orientations (N, S, E, W).
 * Based on its orientation, two possible rotations can be executed:
 * - rotateToLeft
 * - rotateToRight
 */
public enum Orientation {
    N("N"){
        @Override
        public Orientation rotateToLeft(){
            return Orientation.W;
        }

        @Override
        public Orientation rotateToRight(){
            return Orientation.E;
        }
    }, S("S"){
        @Override
        public Orientation rotateToLeft(){
            return Orientation.E;
        }

        @Override
        public Orientation rotateToRight() { return Orientation.W; }
    }, E("E"){
        @Override
        public Orientation rotateToLeft(){
            return Orientation.N;
        }

        @Override
        public Orientation rotateToRight(){
            return Orientation.S;
        }

    }, W("W"){
        @Override
        public Orientation rotateToLeft(){
            return Orientation.S;
        }

        @Override
        public Orientation rotateToRight(){
            return Orientation.N;
        }
    };

    private String val;

    /**
     * @param val
     */
    Orientation(String val)
    {
        this.val=val;
    }

    public abstract Orientation rotateToLeft();
    public abstract Orientation rotateToRight();

    /**
     * @return string
     */
    public String getVal()
    {
        return val;
    }

    /**
     * Method that returns the Orientation corresponding to the input val. In
     * case val is not contained in the list of the Orientation constants,
     * an IllegalArgumentException is thrown.
     * @param val
     * @return Orientation
     */
    public static Orientation retrieveOrientationByVal(String val){
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getVal().equals(val)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid orientation argument");
    }
}
