/**
 * Name: ColdTrack
 * Stores all the features necessary for a Cold-decorated Track.
 *
 * @version 1.0 (12/23/2020)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class ColdTrack extends ExtraComplications{
    private final double complexityFactor = 1.1;
    private final double distanceFactor = 0.9;

    /**
     * Name: ColdTrack
     *
     * @param track: Trackable
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "trackable" corresponds to the track that will be decorated.
     *
     * This method returns nothing since it is the class constructor.
     */

    public ColdTrack (Trackable track) {
        super (track);
    }

    /**
     * Name: calculateComplexity
     * @return double
     *
     * Calculates the currentComplexity applying a Cold-decorated track complexity factor.
     */

    @Override
    public double calculateComplexity () {
        return Math.round ((super.calculateComplexity () * complexityFactor) * 100d) / 100d;
    }

    /**
     * Name: calculateDistance
     * @return double
     *
     * Calculates the currentDistance applying a Cold-decorated track distance factor.
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
        return super.conditionString () + " Cold";
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
