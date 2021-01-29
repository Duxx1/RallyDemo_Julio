/**
 * Name: Track
 * It implements every method a Track has.
 *
 * @version 1.0 (12/23/2020) 01/29/21
 * @author Raúl && Eduardo
 */

public class Track implements Trackable{
    private String name;
    private TrackComplexity complexity;
    private TrackDistance distance;

    /**
     * Name: Track
     *
     * @param name: String
     * @param complexity: TrackComplexity
     * @param distance: TrackDistance
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "trackName" corresponds to the name of the track.
     * The parameter "trackComplexity" corresponds to the complexity of the track.
     * The parameter "trackDistance" corresponds to the distance of the track.
     *
     * This method returns nothing since it is the class constructor.
     */

    public Track (String name, TrackComplexity complexity, TrackDistance distance) {
        setName (name);
        setComplexity (complexity);
        setDistance (distance);
    }

    /**
     * Name: getTrackName
     * @return String
     *
     * Returns the name of the track.
     */
    @Override
    public String getTrackName() {
        return name;
    }

    /**
     * Name: setTrackName
     * @param name: String
     * Sets the given name to the track.
     * The parameter "trackName" corresponds to the name of the track.
     * This method returns nothing.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name: getTrackComplexity
     * @return TrackComplexity
     *
     * Returns the complexity of the track.
     */
    @Override
    public TrackComplexity getTrackComplexity() {
        return complexity;
    }

    /**
     * Name: setTrackComplexity
     * @param complexity: TrackComplexity
     * Sets the given complexity to the track.
     * The parameter "trackComplexity" corresponds to the complexity of the track.
     * This method returns nothing.
     */
    public void setComplexity(TrackComplexity complexity) {
        this.complexity = complexity;
    }

    /**
     * Name: getTrackDistance
     * @return TrackDistance
     *
     * Returns the distance of the track.
     */
    @Override
    public TrackDistance getTrackDistance() {
        return distance;
    }

    /**
     * Name: setTrackDistance
     * @param distance: TrackDistance
     * Sets the distance of the track to the one given.
     * The parameter "trackDistance" corresponds to the distance of the track.
     * This method returns nothing.
     */
     public void setDistance(TrackDistance distance) {
        this.distance = distance;
     }


    /**
     * Name: calculateComplexity
     * @return double
     * Returns the complexity value.
     */
     public double calculateComplexity(){
        return getTrackComplexity().getComplexityValue();
     }

    /**
     * Name: calculateDistance
     * @return double
     * Returns the distance value.
     */
     @Override
     public double calculateDistance() {
        return getTrackDistance().getDistanceValue();
     }

    /**
     * Name: conditionString
     * @return String
     * Returns a String indicating the applied conditions.
     */
     @Override
     public String conditionString() {
        return "";
     }

    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the track.
     */
    @Override
    public String toString () {
        return "<track: " + getTrackName() + "> <cond:> <comp: " + getTrackComplexity ().toString ()
                + "<dist: " + getTrackDistance ().toString ();
    }
}
