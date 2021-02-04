/**
 * Name: TrackComplexity
 * This enumerator stores the different values of complexity that a track can possess (low, medium or high).
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia.
 *
 */

public enum TrackComplexity {
    LOW ("LOW", 1.0),
    MEDIUM ("MEDIUM", 1.25),
    HIGH ("HIGH", 1.5);

    private final String complexityName;
    private final double complexityValue;


    /**
     * Name: TrackComplexity
     *
     * @param complexityName is the name for the complexity.
     * @param complexityValue is the value for the complexity.
     *
     * Initialises the enumerator given certain values.
     *
     * This method returns nothing.
     */

    TrackComplexity (String complexityName, double complexityValue) {
        this.complexityName = complexityName;
        this.complexityValue = complexityValue;
    }


    /**
     * Name: getComplexityName.
     * @return String
     *
     * Returns the name stored in the complexity.
     */

    public String getComplexityName () {
        return complexityName;
    }


    /**
     * Name: getComplexityValue.
     * @return double
     *
     * Returns the value stored in the complexity.
     */

    public double getComplexityValue () {
        return complexityValue;
    }


    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the TrackComplexity.
     */

    @Override
    public String toString () {
        return getComplexityName () + " (original: " + getComplexityValue () + ")";
    }
}
