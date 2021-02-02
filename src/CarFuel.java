/**
 * Name: CarFuel
 * The enum used to represent the information of the name and the value of the fuel used by cars.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public enum CarFuel {
    LIMITED ("LIMITED", 350.0),
    NORMAL ("NORMAL", 440.0),
    GENEROUS ("GENEROUS", 460.0),
    ELEPHANT ("ELEPHANT", 480.0);

    private final String fuelName;
    private final double fuelValue;

    /**
     * Name: CarFuel
     * @param name: name
     * @param value: double
     * Initalises the attributes of the class to the given values.
     */
    CarFuel (String name, double value) {
        this.fuelName = name;
        this.fuelValue = value;
    }

    /**
     * Name: getName
     * @return String
     * Returns the name of the attribute fuelName.
     */
    public String getName () {
        return fuelName;
    }

    /**
     * Name: getValue
     * @return double
     * Returns the value of the attribute fuelValue.
     */
    public double getValue () {
        return fuelValue;
    }

    /**
     * Name: toString
     * @return String
     *
     * Represents the information of the enum on a String.
     */
    @Override
    public String toString () {
        return "<fuel: " + getName () + " (" + getValue () + ")";
    }
}
