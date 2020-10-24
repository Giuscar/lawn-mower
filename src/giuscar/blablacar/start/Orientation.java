package giuscar.blablacar.start;

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
        public Orientation rotateToRight() {
            return Orientation.W;
        }
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

    Orientation(String val)
    {
        this.val=val;
    }

    public abstract Orientation rotateToLeft();
    public abstract Orientation rotateToRight();


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
        throw new IllegalArgumentException("Invalid orientation argument");
    }
}
