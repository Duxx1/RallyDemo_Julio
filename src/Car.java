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
     *
     * @param name: String
     * @param speed: CarSpeed
     * @param fuel: CarFuel
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "name" corresponds to the name of the car.
     * The parameter "speed" corresponds to the speed of the car.
     * The parameter "fuel" corresponds to the fuel of the car.
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
    *Name: getCarName
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
     * @param name: String
     * The parameter "name" is the name that will be assigned to the car.
     * This method sets the name of the car to the given.
     */
    @Override
    public void setCarName (String name) {
        this.name = name;
    }

    /**
     * Name: getCarSpeed
     * @return CarSpeed
     *
     * Returns the enum used for the speed of the cars.
     */
    @Override
    public CarSpeed getCarSpeed () {
        return speed;
    }

    /**
     * Name: setCarSpeed
     * @param speed: CarSpeed
     * The parameter "speed" is the enum type of the speed of the cars.
     * This method sets the speed to the enum type given.
     */
    @Override
    public void setCarSpeed (CarSpeed speed) {
        this.speed = speed;
    }

    /**
     * Name: getCarFuel
     * @return CarFuel
     *
     * This method returns the enum type of the fuel of the car.
     */
    @Override
    public CarFuel getCarFuel () {
        return fuel;
    }

    /**
     * Name: setCarFuel
     * @param fuel: CarFuel
     * The param "fuel" is the enum type used for the fuel of the car.
     *
     * This method sets the car fuel to the given.
     */
    @Override
    public void setCarFuel (CarFuel fuel) {
        this.fuel = fuel;
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
     * @param fuel: double
     * The param "fuel" is the fuel you want to set to the car.
     *
     * This method sets the current fuel of the car to the given.
     */
    @Override
    public void setCurrentFuel (double fuel) {
        this.currentFuel = fuel;
    }

    /**
     * Name: calculateRealSpeed
     * @param t: Trackable
     * @param p: Pilot
     * @return double
     * The param "t" is the interface used for tracks.
     * The param "p" is the pilot that will drive.
     *
     * This method calculates the real speed the car will reach on a circuit being driven by a pilot.
     */
    @Override
    public double calculateRealSpeed (Trackable t, Pilot p) {
        double realSpeed = Math.round (((getCarSpeed ().getValue () * p.calculateSkill ()) / t.calculateComplexity ()) * 100d) / 100d;
        System.out.println ("+++ Under these conditions, the car is capable of reaching " + realSpeed + " km/h +++");
        return realSpeed;
    }

    /**
     * Name: calculateTime
     * @param t: Trackable
     * @param p: Pilot
     * @return double
     * The param "t" is the interface used for tracks.
     * The param "p" is the pilot that will drive.
     *
     * This method calculates the time that the car will be racing on a track being driven by a pilot.
     */
    @Override
    public double calculateTime (Trackable t, Pilot p) {
        return Math.round (((t.calculateDistance () / calculateRealSpeed (t, p)) * 60) * 100d) / 100d;
    }

    /**
     * Name: calculateRemainingFuel
     * @param t: Trackable
     * @param p: Pilot
     * @param time: double
     * @return double
     * The param "t" is the interface used for tracks
     * The param "p" is the pilot that will drive.
     * The param "time" is the time that the car will be racing.
     */
    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        return Math.round ((getCurrentFuel () - time) * 100d) / 100d;
    }

    /**
     * Name: toString
     * @return String
     *
     * Represents the information of the class on a String.
     */
    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Normal> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + getCurrentFuel () + ")>>";
    }
}

