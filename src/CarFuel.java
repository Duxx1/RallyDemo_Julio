/**
 * Name: CarFuel
 * The enumerated is used to represent the information of the name and the value of the fuel used on the car.
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
     * @param name is the name of the fuel value.
     * @param value is the value of stored fuel.
     * It initialises the attributes of the class as the given values.
     */

    CarFuel (String name, double value) {
        fuelName = name;
        fuelValue = value;
    }


    /**
     * Name: getName
     * @return String
     *
     * Returns the name of stored fuel.
     */

    public String getName () {
        return fuelName;
    }


    /**
     * Name: getValue
     * @return double
     *
     * Returns the value of stored fuel.
     */

    public double getValue () {
        return fuelValue;
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
        return "<fuel: " + getName () + " (" + getValue () + ")";
    }
}
