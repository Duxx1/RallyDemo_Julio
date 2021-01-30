/**
 * Name: NewbiePilot
 * It implements every method a NewbiePilot has.
 *
 * @version 1.0 (12/26/2020) 29/01/2021
 * @author Raúl && Eduardo
 */

public class RookiePilot extends Pilot{

    private double EXTRA_SKILL_ROOKIE = 0.97;

    /**
     * Name: NewbiePilot
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
    public RookiePilot(String name, Car car, Concentration concentration, boolean disquialified){
        super(name, car, concentration, disquialified);
    }

    /**
     * Name: calculateSkill
     * @return double
     *
     * Returns the skill from the pilot.
     */
    @Override
    public Double calculateSkill(){
        return Math.round((((getConcentration().getConcentrationValue() * EXTRA_SKILL_ROOKIE) / 120 ) - 0.03) *100d)/100d;
    }


    /**
     * Name: toString
     * @return String
     * Represents the class information in a String.
     */
    @Override
    public String toString(){   //echarle un ojo al isDisqualified
        return super.toString() + " <type: Newbie> <skill: " + calculateSkill() + "> " +
                getConcentration().toString() + "<disqualified: "  + isDisqualified() + ">";
    }
}
