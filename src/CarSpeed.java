//29/01/2021

/**
 * Name: CarSpeed
 * The enum used to represent the information of the name an the value of the speed of the cars.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public enum CarSpeed {
    TURTLE ("TURTLE", 200.0),
    SLOW ("SLOW", 210.0),
    AVERAGE ("AVERAGE", 220.0),
    FAST ("FAST", 230.0),
    CHEETAH ("CHEETAH", 240.0);

    private final String speedName;
    private final double speedValue;

    /**
     * Name: CarSpeed
     * @param name: String
     * @param value: double
     * Initialises the values of the attributes of the enum to the given ones.
     */
    CarSpeed (String name, double value) {
        this.speedName = name;
        this.speedValue = value;
    }

    /**
     * Name: getName
     * @return String
     * Returns the value of the attribute speedName.
     */
    public String getName () {
        return speedName;
    }

    /**
     * Name: getValue
     * @return double
     * Returns the value of the attribute speedValue.
     */
    public double getValue () {
        return speedValue;
    }

    /**
     * Name: toString
     * @return String
     * Represents the information of the enum on a String.
     */
    @Override
    public String toString () {
        return "<theo_speed: " + getName () + " (" + getValue () + ")> ";
    }
}
