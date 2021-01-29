/**
 * Name: WetTrack
 * Stores all the features necessary for a Night-decorated Track.
 *
 * @version 1.0 (12/23/2020) 29/01/21
 * @author Raúl && Eduardo
 */

public class WetTrack extends ExtraComplications{
    private final double complexityFactor = 1.15;
    private final double distanceFactor = 0.85;

    /**
     * Name: WetTrack
     *
     * @param track: Trackable
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "trackable" corresponds to the track that will be decorated.
     *
     * This method returns nothing since it is the class constructor.
     */

    public WetTrack (Trackable track) {
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
        return super.conditionString () + " Wet";
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
