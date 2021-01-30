public class FastCar extends Car {
    private double nitro;

    public FastCar (String name, CarSpeed speed, CarFuel fuel) {
        super (name, speed, fuel);
        setNitro (80.0);
    }

    public double getNitro () {
        return nitro;
    }

    public void setNitro (double nitro) {
        this.nitro = nitro;
    }

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
}
