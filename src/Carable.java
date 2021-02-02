/**
 * Name: Carable
 * The interface that is implemented on the class car and that contains methods for the cars.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public interface Carable {
    public abstract String getCarName ();
    public abstract void setCarName (String name);
    public abstract CarSpeed getCarSpeed ();
    public abstract void setCarSpeed (CarSpeed speed);
    public abstract CarFuel getCarFuel ();
    public abstract void setCarFuel (CarFuel fuel);
    public abstract double getCurrentFuel ();
    public abstract void setCurrentFuel (double fuel);
    public abstract double calculateRealSpeed (Trackable t, Pilot p);
    public abstract double calculateTime (Trackable t, Pilot p);
    public abstract double calculateRemainingFuel (Trackable t, Pilot p, double time);
    public abstract String toString ();
}
