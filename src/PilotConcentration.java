/**
 * Name: PilotConcentration
 * This enumerator stores the different values of concentration that a pilot can possess (clueless, standard, focused or zen).
 *
 * @version 1.0 (12/24/2020) 29/01/21
 * @author Raúl && Eduardo
 */

public enum PilotConcentration {
    CLUELESS ("CLUELESS", 90.0),
    STANDARD ("STANDARD", 100.0),
    FOCUSED ("FOCUSED", 110.0),
    ZEN ("ZEN", 120.0);

    private final String concentrationName;
    private final double concentrationValue;

    /**
     * Name: PilotConcentration
     *
     * @param concentrationValue: double
     *
     * Initialises the enumerator given certain values.
     * The parameter "concentrationName" corresponds to the name of the fuel.
     * The parameter "concentrationValue" corresponds to the value of the fuel.
     *
     * This method returns nothing since it is the class constructor.
     */

    PilotConcentration (String concentrationName, double concentrationValue) {
        this.concentrationName = concentrationName;
        this.concentrationValue = concentrationValue;
    }


    /**
     * Name: getConcentrationName
     * @return String
     *
     * Returns the concentration name from its pilot.
     */

    public String getConcentrationName () {
        return concentrationName;
    }


    /**
     * Name: getConcentrationValue
     * @return String
     *
     * Returns the concentration value from its pilot.
     */

    public double getConcentrationValue () {
        return concentrationValue;
    }


    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the TrackComplexity.
     */

    @Override
    public String toString () {
        return "<conc: " + getConcentrationName () + " (" + getConcentrationValue () + ")> ";
    }
}
