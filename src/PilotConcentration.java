/**
 * Name: PilotConcentration
 * This enumerator stores the different values of concentration that a pilot can possess (clueless, standard, focused or zen).
 *
 * @version 1.0 (01/29/2021)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
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
     * @param newConcentrationName is the name of the concentration status.
     * @param newConcentrationValue is the value of the concentration status.
     *
     * It tnitialises the enumerator given certain values.
     *
     * This method returns nothing.
     */

    PilotConcentration (String newConcentrationName, double newConcentrationValue) {
        concentrationName = newConcentrationName;
        concentrationValue = newConcentrationValue;
    }


    /**
     * Name: getConcentrationName
     * @return String
     *
     * It returns the concentration name from its pilot.
     */

    public String getConcentrationName () {
        return concentrationName;
    }


    /**
     * Name: getConcentrationValue
     * @return String
     *
     * It returns the concentration value from its pilot.
     */

    public double getConcentrationValue () {
        return concentrationValue;
    }


    /**
     * Name: toString
     * @return String
     *
     * It returns a String representation of the information stored in the class.
     */

    @Override
    public String toString () {
        return "<conc: " + getConcentrationName () + " (" + getConcentrationValue () + ")> ";
    }
}
