/**
*Name: Car
* The class Car represents a car object.
* It is given to a pilot in order to compete on a track.
*
* @version  1.0
* @author   Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class Car implements Carable {
    private String name;
    private CarSpeed speed;
    private CarFuel fuel;
    private double currentFuel;

    /**
     * Name: Car
     * @return Car
     * @param name is the name of the car.
     * @param speed is the speed of the car.
     * @param fuel is the fuel of the car.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing since it is the class constructor.
     */

    public Car (String name, CarSpeed speed, CarFuel fuel) {
        setCarName (name);
        setCarSpeed (speed);
        setCarFuel (fuel);
        setCurrentFuel (getCarFuel ().getValue ());
    }


    /**
     * Name: getCarName
     * @return String
     *
     * Returns the name of the car.
    */

    @Override
    public String getCarName () {
        return name;
    }


    /**
     * Name: setCarName
     * @param _name is the name of the car
     * It sets the name of the car as the one given.
     *
     * This method returns nothing.
     */

    @Override
    public void setCarName (String _name) {
        name = _name;
    }


    /**
     * Name: getCarSpeed
     * @return CarSpeed
     *
     * It returns the value of the speed of the car.
     */

    @Override
    public CarSpeed getCarSpeed () {
        return speed;
    }


    /**
     * Name: setCarSpeed
     * @param _speed is the speed of the car.
     * It sets the speed of the car as the one given.
     *
     * This method returns nothing.
     */

    @Override
    public void setCarSpeed (CarSpeed _speed) {
        speed = _speed;
    }


    /**
     * Name: getCarFuel
     * @return CarFuel
     *
     * This method returns the fuel of the car.
     */

    @Override
    public CarFuel getCarFuel () {
        return fuel;
    }


    /**
     * Name: setCarFuel
     * @param _fuel is the fuel of the car.
     *
     * It sets the car fuel as the one given.
     *
     * This method returns nothing.
     */

    @Override
    public void setCarFuel (CarFuel _fuel) {
        fuel = _fuel;
    }


    /**
     * Name: getCurrentFuel
     * @return double
     *
     * This method returns the current fuel of the car
     */

    @Override
    public double getCurrentFuel () {
        return currentFuel;
    }


    /**
     * Name: setCurrentFuel
     * @param _fuel is the fuel of the car.
     *
     * It sets the current fuel of the car as the one given.
     *
     * This method returns nothing.
     */

    @Override
    public void setCurrentFuel (double _fuel) {
        currentFuel = _fuel;
    }


    /**
     * Name: calculateRealSpeed
     * @return double
     * @param t is the track where the car races.
     * @param p is the pilot that drives the car.
     *
     * It calculates the real speed the car will reach on a track while it is being driven by a pilot.
     *
     * The returned value is that said real speed.
     */

    @Override
    public double calculateRealSpeed (Trackable t, Pilot p) {
        double realSpeed = Math.round (((getCarSpeed ().getValue () * p.calculateSkill ()) / t.calculateComplexity ()) * 100d) / 100d;
        System.out.println ("+++ Under these conditions, the car is capable of reaching " + realSpeed + " km/h +++");
        return realSpeed;
    }


    /**
     * Name: calculateTime
     * @return double
     * @param t is the track where the car races.
     * @param p is the pilot that drives the car.
     *
     * It calculates the time while the car will be racing on a track while it is being driven by a pilot.
     *
     * The returned value is that said time.
     */

    @Override
    public double calculateTime (Trackable t, Pilot p) {
        return Math.round (((t.calculateDistance () / calculateRealSpeed (t, p)) * 60) * 100d) / 100d;
    }


    /**
     * Name: calculateRemainingFuel
     * @return double
     * @param t is the track where the car races.
     * @param p is the pilot that drives the car.
     * @param time is the time that the car takes to race in the track while it is being driven by the pilot.
     *
     * It calculates the remaining fuel that the car will have after racing in a certain track for a certain time and while it had been driven by a certain pilot.
     */

    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        return Math.round ((getCurrentFuel () - time) * 100d) / 100d;
    }


    /**
     * Name: toString
     * @return String
     *
     * It represents the information of the class on a String.
     *
     * The returned value is a String representation of the class.
     */

    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Normal> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + getCurrentFuel () + ")>";
    }
}

