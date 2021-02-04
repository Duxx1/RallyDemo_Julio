import java.util.Objects;

/**
 * Name: Track
 * It implements every method a Track has.
 *
 * @version 1.0 (01/29/21)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia.
 *
 */

public class Track implements Trackable {
    private String name;
    private TrackComplexity complexity;
    private TrackDistance distance;


    /**
     * Name: Track
     * @param name is the Track's name.
     * @param complexity is the Track complexity value.
     * @param distance is the Track distance value.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
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
    public String getTrackName () {
        return name;
    }


    /**
     * Name: setTrackName
     * @param name is the Track's name.
     * Sets the given name to the track.
     *
     * This method returns nothing.
     */

    public void setName (String name) {
        this.name = name;
    }


    /**
     * Name: getTrackComplexity
     * @return TrackComplexity
     *
     * Returns the complexity of the track.
     */

    @Override
    public TrackComplexity getTrackComplexity () {
        return complexity;
    }


    /**
     * Name: setTrackComplexity
     * @param complexity is the Track's complexity.
     * Sets the given complexity to the track.
     *
     * This method returns nothing.
     */

    public void setComplexity (TrackComplexity complexity) {
        this.complexity = complexity;
    }


    /**
     * Name: getTrackDistance
     * @return TrackDistance
     *
     * Returns the distance of the track.
     */

    @Override
    public TrackDistance getTrackDistance () {
        return distance;
    }


    /**
     * Name: setTrackDistance
     * @param distance is the track's distance.
     * Sets the distance of the track to the one given.
     *
     * This method returns nothing.
     */

     public void setDistance (TrackDistance distance) {
        this.distance = distance;
     }


    /**
     * Name: calculateComplexity
     * @return double
     *
     * Returns the complexity value.
     */

    @Override
     public double calculateComplexity (){
        return getTrackComplexity ().getComplexityValue ();
     }


    /**
     * Name: calculateDistance
     * @return double
     *
     * Returns the distance value.
     */

     @Override
     public double calculateDistance () {
        return getTrackDistance ().getDistanceValue ();
     }


    /**
     * Name: conditionString
     * @return String
     *
     * Returns a String indicating the applied conditions.
     */

     @Override
     public String conditionString () {
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
