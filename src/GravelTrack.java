/**
 * Name: GravelTrack
 * It stores all the features necessary for a Gravel-decorated Track.
 *
 * @version 1.0
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class GravelTrack extends ExtraComplications {
    private final double complexityFactor = 1.05;
    private final double distanceFactor = 0.95;


    /**
     * Name: GravelTrack
     * @param track is the track that will be decorated.
     *
     * It initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public GravelTrack (Trackable track) {
        super (track);
    }


    /**
     * Name: calculateComplexity
     * @return double
     *
     * It calculates the currentComplexity applying a Gravel-decorated track complexity factor.
     */

    @Override
    public double calculateComplexity () {
        return Math.round ((super.calculateComplexity () * complexityFactor) * 100d) / 100d;
    }


    /**
     * Name: calculateDistance
     * @return double
     *
     * It calculates the currentDistance applying a Gravel-decorated track distance factor.
     */

    @Override
    public double calculateDistance () {
        return Math.round ((super.calculateDistance () * distanceFactor) * 100d) / 100d;
    }


    /**
     * Name: conditionString
     * @return String
     *
     * It returns a String indicating the applied conditions.
     *
     * The returned String is an explanation of all the applied conditions.
     */

    @Override
    public String conditionString () {
        return super.conditionString () + " Gravel";
    }


    /**
     * Name: toString
     * @return String
     *
     * It represents the information of the class on a String.
     *
     * The returned value is the String representation of the class.
     */

    @Override
    public String toString () {
        return "<track: " + super.getTrackName () + "> <cond:" + conditionString () + "> <comp: " + getTrackComplexity ().toString () + " (current: "
                + calculateComplexity () + ")> <dist: " + getTrackDistance ().toString () + " (current: " + calculateDistance () + ")>";
    }
}
