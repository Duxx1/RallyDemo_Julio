/**
 * Name: NightTrack
 * Stores all the features necessary for a Night-decorated Track.
 *
 * @version 1.0 (12/23/2020) 20/01/21
 * @author Raúl && Eduardo
 */

public class NightTrack extends ExtraComplications{
    private final double complexityFactor = 1.2;
    private final double distanceFactor = 0.8;

    /**
     * Name: NightTrack
     *
     * @param track: Trackable
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "trackable" corresponds to the track that will be decorated.
     *
     * This method returns nothing since it is the class constructor.
     */

    public NightTrack (Trackable track) {
        super (track);
    }


    /**
     * Name: calculateComplexity
     * @return double
     *
     * Changes the currentComplexity applying a Cold-decorated track complexity factor.
     */

    @Override
    public double calculateComplexity () {
        return Math.round ((super.calculateComplexity () * complexityFactor) * 100d) / 100d;
    }


    /**
     * Name: calculateDistance
     * @return double
     *
     * Changes the currentDistance applying a Cold-decorated track distance factor.
     */

    @Override
    public double calculateDistance () {
        return Math.round ((super.calculateDistance () * distanceFactor) * 100d) / 100d;
    }


    /**
     * Name: conditionString
     * @return String
     * Returns a String indicating the applied conditions.
     */

    @Override
    public String conditionString () {
        return super.conditionString () + " Night";
    }


    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the track.
     */

    @Override
    public String toString () {
        return "<track: " + super.getTrackName() + "> <cond:" + conditionString() + "> <comp: " + getTrackComplexity ().toString () + " (current: "
                + calculateComplexity () + ")> <dist: " + getTrackDistance ().toString () + " (current: " + calculateDistance () + ")>";
    }
}
