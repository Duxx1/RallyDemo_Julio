/**
 * Name: FastCar
 * This class represents all the information that a fast car must have.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class FastCar extends Car {
    private double nitro;

    /**
     * Name: FastCar
     * @param name is the name of the car.
     * @param speed is the speed of the car.
     * @param fuel is the fuel of the car.
     *
     * It initialises the class attributes according to the given ones.
     *
     * This method returns nothing.
     */

    public FastCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setNitro (80.0);
    }


    /**
     * Name: getNitro
     * @return double
     *
     * It returns the nitro of the fast car.
     */

    public double getNitro () {
        return nitro;
    }


    /**
     * Name: setNitro
     * @param _nitro: double
     *
     * It sets the given nitro to the fast car.
     *
     * This method returns nothing.
     */

    public void setNitro (double _nitro) {
        nitro = _nitro;
    }


    /**
     * Name: calculateRealSpeed
     * @return double.
     * @param t is the track where the car races.
     * @param p is the pilot that drives the car.
     *
     * It calculates the real speed of a car in the track while it is being drive by a pilot.
     */

    @Override
    public double calculateRealSpeed (Trackable t, Pilot p) {
        double realSpeed = super.calculateRealSpeed (t, p);
        double limit = realSpeed * 0.2;
        if (getNitro () > 0.0) {
            if (getNitro () >= limit) {
                realSpeed += limit;
                setNitro (getNitro () - limit);
            }
            else {
                realSpeed += getNitro ();
                limit = getNitro ();
                setNitro (0);
            }
            limit = Math.round ((limit) * 100d) / 100d;
            realSpeed = Math.round ((realSpeed) * 100d) / 100d;
            System.out.println ("+++ The " + getCarName () + " has used " + limit + " litres from nitro to reach " + realSpeed +
            " km/h, and the remaining nitro is " + Math.round ((getNitro ()) * 100d) / 100d + " +++");
        }
        return realSpeed;
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
        return "<car: " + getCarName () + "> <type: Fast> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + Math.round (getCurrentFuel () * 100d) / 100d + ")>> <remaining nitro: " + Math.round (getNitro () * 100d) / 100d + ">";
    }
}
