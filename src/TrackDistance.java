/**
 * Name: TrackDistance
 * This enumerator stores the different values of distance that a track can possess (short, intermediate or long).
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia.
 *
 */

public enum TrackDistance {
    SHORT ("SHORT", 250),
    INTERMEDIATE ("INTERMEDIATE", 275),
    LONG ("LONG", 300);

    private final String distanceName;
    private final double distanceValue;


    /**
     * Name: TrackDistance
     *
     * @param distanceName is the name for the distance.
     * @param distanceValue is the value for the distance.
     *
     * Initialises the enumerator given certain values.
     *
     * This method returns nothing.
     */

    TrackDistance (String distanceName, double distanceValue) {
        this.distanceName = distanceName;
        this.distanceValue = distanceValue;
    }


    /**
     * Name: getDistanceName.
     * @return String
     *
     * Returns the name stored in the distance.
     */

    public String getDistanceName () {
        return distanceName;
    }


    /**
     * Name: getDistanceValue
     * @return double
     *
     * Returns the value stored in the distance.
     */

    public double getDistanceValue () {
        return distanceValue;
    }


    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the TrackDistance.
     */

    @Override
    public String toString () {
        return getDistanceName () + " (original: " + getDistanceValue () + ")";
    }
}
