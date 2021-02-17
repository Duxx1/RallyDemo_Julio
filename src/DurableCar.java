/**
 * Name: DurableCar
 * This class represents all the information that a durable car must have.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class DurableCar extends Car {
    private double extraFuel;

    /**
     * Name: DurableCar
     * @param name is the name of the car.
     * @param speed is the speed of the car.
     * @param fuel is the fuel of the car.
     *
     * It initialises the class attributes according to the given ones.
     *
     * This method returns nothing.
     */

    public DurableCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setExtraFuel (100);
    }


    /**
     * Name: getExtraFuel
     * @return double
     *
     * It returns the extra fuel of the durable car.
     */

    public double getExtraFuel () {
        return extraFuel;
    }


    /**
     * Name: setExtraFuel
     * @param fuel is the fuel of the car.
     *
     * It sets the extra fuel of the car as the given one.
     */

    public void setExtraFuel (double fuel) {
        extraFuel = fuel;
    }


    /**
     * Name: calculateRemainingFuel
     * @return double
     * @param t is the track where the car races.
     * @param p is the pilot that drives the car.
     * @param time is the time that the car takes to race in the track while it is being driven by the pilot.
     *
     * It calculates the remaining fuel of the durable car after a race.
     *
     * The returned value is that said remaining fuel.
     */

    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        double fuel = getCurrentFuel ();
        if ((getExtraFuel () > 0.0) && (fuel < time)) {
            fuel += getExtraFuel ();
            setExtraFuel (0);
            super.setCurrentFuel (fuel);
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
     * It represents the information of the class on a String.
     *
     * The returned value is the String representation of the class.
     */

    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Durable> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + Math.round(getCurrentFuel ()*100d)/100d + ")>> <tank: " + Math.round (getExtraFuel () * 100d) / 100d + ">";
    }
}
