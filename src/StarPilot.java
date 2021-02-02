/**
 * Name: StarPilot
 * It implements every method a star pilot has.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class StarPilot extends Pilot{
    private double EXTRA_SKILL_STAR = 6;


    /**
     * Name: StarPilot
     *
     * @param name is the pilot's name.
     * @param concentration is the pilot's concentration.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public StarPilot (String name, PilotConcentration concentration){
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
        return Math.round (((((getConcentration ().getConcentrationValue () + EXTRA_SKILL_STAR) / 140) * 1.06) + 0.05) * 100d) / 100d;
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
        return super.toString () + " <type: Star> <skill: " + calculateSkill () + "> " +
                getConcentration ().toString () + "<disqualified: " + isDisqualified () + ">";
    }
}
