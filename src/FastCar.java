public class FastCar extends Car {
    private double nitro;

    /**
     * Name: FastCar
     *
     * @param name: String
     * @param speed: CarSpeed
     * @param fuel: CarFuel
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "name" corresponds to the name of the fast car.
     * The parameter "speed" corresponds to the speed of the fast car.
     * The parameter "fuel" corresponds to the fuel of the fast car.
     *
     * This method returns nothing since it is the class constructor.
     */
    public FastCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setNitro (80.0);
    }

    /**
     * Name: getNitro
     * @return double
     *
     * Returns the nitro of the fast car.
     */
    public double getNitro () {
        return nitro;
    }

    /**
     * Name: setNitro
     * @param nitro: double
     * Sets the given nitro to the fast car.
     * The parameter "nitro" corresponds to the nitro of the fast car.
     * This method returns nothing.
     */
    public void setNitro (double nitro) {
        this.nitro = nitro;
    }

    /**
     * Name: setNitro
     * @param t: Trackable
     * @param p: Pilot
     * @return double.
     * Calculates the real speed of a pilot in a track using this fast car.
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
     * Returns a String representation of the information stored in the fast car.
     */
    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Fast> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + Math.round(getCurrentFuel ()*100d)/100d + ")>> <remaining nitro: " + Math.round(getNitro ()*100d)/100d + ">";
    }
}
