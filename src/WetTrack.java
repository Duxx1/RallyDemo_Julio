/**
 * Name: WetTrack
 * Stores all the features necessary for a Wet-decorated Track.
 *
 * @version 1.0 (01/29/2021)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia.
 *
 */

public class WetTrack extends ExtraComplications {
    private final double complexityFactor = 1.15;
    private final double distanceFactor = 0.85;


    /**
     * Name: WetTrack
     * @param track is the one that is being decorated.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public WetTrack (Trackable track) {
        super (track);
    }


    /**
     * Name: calculateComplexity
     * @return double
     *
     * Changes the currentComplexity applying a Wet-decorated track complexity factor.
     */

    @Override
    public double calculateComplexity () {
        return Math.round ((super.calculateComplexity () * complexityFactor) * 100d) / 100d;
    }


    /**
     * Name: calculateDistance
     * @return double
     *
     * Changes the currentDistance applying a Wet-decorated track distance factor.
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
