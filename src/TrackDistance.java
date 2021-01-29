/**
 * Name: TrackDistance
 * This enumerator stores the different values of distance that a track can possess (short, intermediate or long).
 *
 * @version 1.0 (12/23/2020) 29/01/21
 * @author Raúl && Eduardo
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
     * @param distanceValue: double
     *
     * Initialises the enumerator given certain values.
     * The parameter "distanceName" corresponds to the name of the distance.
     * The parameter "distanceValue" corresponds to the value of the distance.
     *
     * This method returns nothing since it is the class constructor.
     */

    TrackDistance (String distanceName, double distanceValue) {
        this.distanceName = distanceName;
        this.distanceValue = distanceValue;
    }


    /**
     * Name: getDistanceName
     * @return String
     *
     * Returns the value stored in the distance name.
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
