public class Car implements Carable {
    private String name;
    private CarSpeed speed;
    private CarFuel fuel;
    private double currentFuel;

    public Car (String name, CarSpeed speed, CarFuel fuel) {
        setCarName (name);
        setCarSpeed (speed);
        setCarFuel (fuel);
        setCurrentFuel (getCarFuel ().getValue ());
    }

    @Override
    public String getCarName () {
        return name;
    }

    @Override
    public void setCarName (String name) {
        this.name = name;
    }

    @Override
    public CarSpeed getCarSpeed () {
        return speed;
    }

    @Override
    public void setCarSpeed (CarSpeed speed) {
        this.speed = speed;
    }

    @Override
    public CarFuel getCarFuel () {
        return fuel;
    }

    @Override
    public void setCarFuel (CarFuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public double getCurrentFuel () {
        return currentFuel;
    }

    @Override
    public void setCurrentFuel (double fuel) {
        this.currentFuel = fuel;
    }

    @Override
    public double calculateRealSpeed (Trackable t, Pilot p) {
        double realSpeed = Math.round (((getCarSpeed ().getValue () * p.calculateSkill ()) / t.calculateComplexity ()) * 100d) / 100d;
        System.out.println ("+++ Under these conditions, the car is capable of reaching " + realSpeed + " km/h +++");
        return realSpeed;
    }

    @Override
    public double calculateTime (Trackable t, Pilot p) {
        return Math.round (((t.calculateDistance () / calculateRealSpeed (t, p)) * 60) * 100d) / 100d;
    }

    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        return Math.round ((getCurrentFuel () - time) * 100d) / 100d;
    }

    @Override
    public String toString () {
        return "<car: " + getCarName () + "> <type: Normal> " + getCarSpeed ().toString ()
                + getCarFuel ().toString () + "(current: " + getCurrentFuel () + ")>";
    }
}

