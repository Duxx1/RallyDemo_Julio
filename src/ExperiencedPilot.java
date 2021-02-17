/**
 * Name: ExperiencedPilot
 * It implements every method an ExperiencedPilot must have.
 *
 * @version     1.0 (01/29/2021)
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class ExperiencedPilot extends Pilot {
    private double extraSkill = 3;

    /**
     * Name: ExperiencedPilot
     *
     * @param name is the pilot's name.
     * @param concentration is the pilot's concentration.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public ExperiencedPilot (String name, PilotConcentration concentration){
        super (name, concentration);
    }


    /**
     * Name: calculateSkill
     * @return double
     *
     * It calculates the pilot's skill.
     */

    @Override
    public double calculateSkill () {
        return Math.round ((((getConcentration ().getConcentrationValue () + extraSkill) / 130) * 1.03) * 100d) / 100d;
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
        return super.toString () + " <type: Experienced> <skill: " + calculateSkill () + "> " +
                getConcentration ().toString () + "<disqualified: " + isDisqualified () + ">";
    }

}
