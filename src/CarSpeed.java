/**
 * Name: CarSpeed
 * The enumerated is used to represent the information of the name and the value of the speed used on the car.
 *
 * @version     1.0 (01/29/2021)
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
     * @param name is the name of the speed value.
     * @param value is the value of stored speed.
     * It initialises the attributes of the class as the given values.
     */

    CarSpeed (String name, double value) {
        speedName = name;
        speedValue = value;
    }


    /**
     * Name: getName
     * @return String
     *
     * Returns the name of stored speed.
     */

    public String getName () {
        return speedName;
    }


    /**
     * Name: getValue
     * @return double
     *
     * Returns the value of stored speed.
     */

    public double getValue () {
        return speedValue;
    }


    /**
     * Name: toString
     * @return String
     *
     * It represents the information of the class on a String.
     *
     * The returned value is the String representation of the class.
     */

    @Override
    public String toString () {
        return "<theo_speed: " + getName () + " (" + getValue () + ")> ";
    }
}
