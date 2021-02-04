/**
 * Name: Trackable
 * This interface indicates all the methods that every Track must have, and those which access to data that will be modified
 *      according to the functionality that is added (Decorator design pattern).
 *
 * @version 1.0 ()
 * @author Raul Hormigo Cerón and Eduardo Cano Garcia.
 *
 */

public interface Trackable {
    public abstract String getTrackName ();
    public abstract TrackComplexity getTrackComplexity ();
    public abstract TrackDistance getTrackDistance ();
    public abstract double calculateComplexity ();
    public abstract double calculateDistance ();
    public abstract String conditionString ();
    public abstract String toString ();
}
