/**
 * Name: ExperiencedPilot
 * It implements every method an ExperiencedPilot has.
 *
 * @version 1.0 (12/26/2020) 29/01/21
 * @author Raúl && Eduardo
 */

public class ExperiencedPilot  extends Pilot{

    private double EXTRA_SKILL_EXPERIENCED = 3;

    /**
     * Name: ExperiencedPilot
     *
     * @param name: String
     * @param concentration: Concentration
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "pilotName" corresponds to the name of the pilot.
     * The parameter "car" corresponds to the pilot's car.
     * The parameter "pilotConcentration" corresponds to the pilot's concentration.
     * The parameter "disqualified" corresponds to the pilot's disqualified status.
     *
     * This method returns nothing since it is the class constructor.
     */
    public ExperiencedPilot(String name, Car car, Concentration concentration, boolean disqualified){
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
        return Math.round((((getConcentrationValue() + EXTRA_SKILL_EXPERIENCED) / 130) *1.03) *100d) / 100d;
    }

    @Override
    public String toString(){   //echarle un ojo al isDisqualified
        return super.toString() + " <type: Experienced> <skill: " + calculateSkill() + "> " +
                getConcentration().toString() + "<disqualified: " + isDisqualified() + ">";
    }

}
