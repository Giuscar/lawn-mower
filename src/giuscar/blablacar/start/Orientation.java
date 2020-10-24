package giuscar.blablacar.start;

public enum Orientation {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
    private String val;

    Orientation(String val)
    {
        this.val=val;
    }

    public String getVal()
    {
        return val;
    }

    public static Orientation retrieveOrientationByVal(String val){
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getVal().equals(val)) {
                return orientation;
            }
        }
        return null;
    }

}
