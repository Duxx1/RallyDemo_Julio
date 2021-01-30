public class DurableCar extends Car {
    private double extraFuel;

    public DurableCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setExtraFuel (100);
    }

    public double getExtraFuel () {
        return extraFuel;
    }

    public void setExtraFuel (double fuel) {
        extraFuel = fuel;
    }

    @Override
    public double calculateRemainingFuel (Trackable t, Pilot p, double time) {
        double fuel = getCurrentFuel ();
        if ((getExtraFuel () > 0.0) && (fuel < time)) {
            fuel += getExtraFuel ();
            setExtraFuel (0);
            System.out.println ("+++ The " + super.getCarName () + " needs to use the extra tank to keep racing +++");
        }
        else {
            fuel = super.calculateRemainingFuel (t, p, time);
        }
        return Math.round ((fuel) * 100d) / 100d;
    }
}
