public enum CarFuel {
    LIMITED ("LIMITED", 350.0),
    NORMAL ("NORMAL", 440.0),
    GENEROUS ("GENEROUS", 460.0),
    ELEPHANT ("ELEPHANT", 480.0);

    private final String fuelName;
    private final double fuelValue;

    CarFuel (String name, double value) {
        this.fuelName = name;
        this.fuelValue = value;
    }

    public String getName () {
        return fuelName;
    }

    public double getValue () {
        return fuelValue;
    }

    @Override
    public String toString () {
        return "<fuel: " + getName () + " (" + getValue () + ")";
    }
}
