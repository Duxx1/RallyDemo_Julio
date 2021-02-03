/**
 * Name: DurableCar
 * This class represents a type of car called "DurableCar" that has special features.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class DurableCar extends Car {
    private double extraFuel;

    /**
     * Name: DurableCar
     * @param name: String
     * @param speed: CarSpeed
     * @param fuel: CarFuel
     * The param "name" is the name of the durable car.
     * The param "speed" is the speed of the car
     * The param "fuel" is the fuel of the car
     *
     * Initialises the class to the given attributes.
     */
    public DurableCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setExtraFuel (100);
    }

    /**
     * Name: getExtraFuel
     * @return double
     *
     * Returns the extra fuel of the car.
     */
    public double getExtraFuel () {
        return extraFuel;
    }

    /**
     * Name: setExtraFuel
     * @param fuel: double
     *
     * Sets the extra fuel of the car to the given.
     */
    public void setExtraFuel (double fuel) {
        extraFuel = fuel;
    }

    /**
     * Name: calculateRemainingFuel
     * @param t: Trackable
     * @param p: Pilot
     * @param time: double
     * @return double
     *
     * Calculates the remaining fuel of the car.
     */
    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        double fuel = getCurrentFuel ();
        if ((getExtraFuel () > 0.0) && (fuel < time)) {
            fuel += getExtraFuel ();
            setExtraFuel (0);
            //
            super.setCurrentFuel(fuel);
            //
            System.out.println ("+++ The " + super.getCarName () + " needs to use the extra tank to keep racing +++");
        }
        else {
            fuel = super.calculateRemainingFuel (t, p, time);
        }
        return Math.round ((fuel) * 100d) / 100d;
    }

    /**
     * Name: toString
     * @return String
     *
     * Represents the information of a durable car on a String.
     */
    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Durable> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + Math.round(getCurrentFuel ()*100d)/100d + ")>> <tank: " + Math.round(getExtraFuel ()*100d)/100d + ">";
    }
}
