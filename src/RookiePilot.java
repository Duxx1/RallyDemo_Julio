/**
 * Name: RookiePilot
 * It implements every method a rookie pilot has.
 *
 * @version 1.0 (01/29/2021)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class RookiePilot extends Pilot {
    private double EXTRA_SKILL_ROOKIE = 0.97;


    /**
     * Name: RookiePilot
     *
     * @param name is the pilot's name.
     * @param concentration is the pilot's concentration.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public RookiePilot (String name, PilotConcentration concentration){
        super (name, concentration);
    }


    /**
     * Name: calculateSkill
     * @return double
     *
     * Returns the skill from the pilot.
     */

    @Override
    public double calculateSkill () {
        return Math.round ((((getConcentration ().getConcentrationValue () * EXTRA_SKILL_ROOKIE) / 120 ) - 0.03) *100d) / 100d;
    }


    /**
     * Name: toString
     * @return String
     *
     * Represents the class information in a String variable.
     *
     * Returns a String variable.
     */

    @Override
    public String toString () {
        return super.toString () + " <type: Rookie> <skill: " + calculateSkill () + "> " +
                getConcentration ().toString () + "<disqualified: "  + isDisqualified () + ">";
    }
}
