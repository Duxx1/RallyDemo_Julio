/**
 * Name: StarPilot
 * It implements every method an StarPilot has.
 *
 * @version 1.0 (12/26/2020)
 * @author Raúl
 */

public class StarPilot extends Pilot{

    private double EXTRA_SKILL_STAR = 6;

    /**
     * Name: StarPilot
     *
     * @param name: String
     * @param concentration: Concentration
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "pilotName" corresponds to the name of the pilot.
     * The parameter "car" corresponds to the pilot's car.
     * The parameter "pilotConcentration" corresponds to the pilot's concentration.
     *
     * This method returns nothing since it is the class constructor.
     */
    public StarPilot(String name, Car car, Concentration concentration, boolean disqualified){
        super(name, car, concentration, disqualified);
    }

    /**
     * Name: calculateSkill
     * @return double
     *
     * Returns the skill from the pilot.
     */
    @Override
    public Double calculateSkill(){
        return Math.round(((((this.getConcentrationValue() + EXTRA_SKILL_STAR) / 140) * 1.06) +0.05) *100d) /100d;
    }

    /**
     * Name: toString
     * @return String
     * Represents the class information in a String.
     */
    @Override
    public String toString(){
        return super.toString() + " <type: Star> <skill: " + calculateSkill() + "> " +
                getConcentration().toString() + "<disqualified: " + isDisqualified() + ">";
    }
}
