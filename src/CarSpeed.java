//29/01/2021
public enum CarSpeed {
    TURTLE ("TURTLE", 200.0),
    SLOW ("SLOW", 210.0),
    AVERAGE ("AVERAGE", 220.0),
    FAST ("FAST", 230.0),
    CHEETAH ("CHEETAH", 240.0);

    private final String speedName;
    private final double speedValue;

    CarSpeed (String name, double value) {
        this.speedName = name;
        this.speedValue = value;
    }

    public String getName () {
        return speedName;
    }

    public double getValue () {
        return speedValue;
    }

    @Override
    public String toString () {
        return "<theo_speed: " + getName () + "(" + getValue () + ")> ";
    }
}
