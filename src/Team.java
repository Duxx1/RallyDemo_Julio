import java.util.*;

/**
 * Name: Team
 * Keeps all its pilots and cars withing, as well as a map of disqualified pilots.
 *
 * @version 1.0 (01/30/2021) 30/01/21
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class Team {
    private String name;
    private List<Pilot> pilotList;
    private List <Carable> carList;
    private Map <String, Pilot> disqualifiedPilots;
    private Comparator pilotSorter;
    private Comparator carSorter;


    /**
     * Name: Team
     *
     * @param name is the Team's name.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public Team (String name) {
        setName (name);
        pilotList = new ArrayList <Pilot> ();
        carList = new ArrayList <Carable> ();
        disqualifiedPilots = new TreeMap <String, Pilot> ();
    }


    /**
     * Name: getName
     * @return String
     *
     * Returns the name of the team.
     */

    public String getName () {
        return name;
    }


    /**
     * Name: setTeamName
     * @param name is the new Team's name.
     *
     * Sets the given name to the team.
     *
     * This method returns nothing.
     */

    public void setName (String name) {
        this.name = name;
    }


    /**
     * Name: getPilotList
     * @return ArrayList <Pilot>
     *
     * Returns the ArrayList of pilots that belong to the Team.
     */

    public List <Pilot> getPilotList () {
        return pilotList;
    }


    /**
     * Name: setPilotList
     * @param pilotList is the new list of pilots.
     *
     * Sets the given list of pilots of the team's one.
     *
     * This method returns nothing.
     */

    public void setPilotList (List <Pilot> pilotList) {
        this.pilotList = pilotList;
    }


    /**
     * Name: getCarList
     * @return List <Carabler>
     *
     * Returns the List of cars.
     */

    public List <Carable> getCarList () {
        return carList;
    }


    /**
     * Name: setCarList
     * @param carList is the new list of cars.
     *
     * Sets the given list of cars to the team's one.
     *
     * This method returns nothing.
     */

    public void setCarList (List <Carable> carList) {
        this.carList = carList;
    }


    /**
     * Name: getDisqualifiedPilots
     * @return Map <String, Pilot>
     *
     * Returns a map which contains a list of the disqualified pilots and their names..
     */

    public Map <String, Pilot> getDisqualifiedPilots() {
        return disqualifiedPilots;
    }


    /**
     * Name: setDisqualifiedPilots
     * @param disqualifiedPilots is the new Map of pilots.
     *
     * Sets the given map of the disqualified pilots to the team's.
     *
     * This method returns nothing.
     */

    public void setDisqualifiedPilots (Map <String, Pilot> disqualifiedPilots) {
        this.disqualifiedPilots = disqualifiedPilots;
    }


    /**
     * Name: getPilotSorter
     * @return Comparator
     *
     * Returns a comparator to sort the pilots.
     */

    public Comparator getPilotSorter () {
        return pilotSorter;
    }


    /**
     * Name: setPilotSorter
     * @param pilotSorter is the sorting criteria.
     * @param reverseSorting indicates if it must be reversed (true), or un-reversed (false).
     *
     * This method returns nothing.
     */

    public void setPilotSorter (Comparator pilotSorter, boolean reverseSorting) {
        if (reverseSorting) {
            this.pilotSorter = Collections.reverseOrder (pilotSorter);
        }
        else {
            this.pilotSorter = pilotSorter;
        }
        sortPilots ();
    }


    /**
     * Name: sortPilots
     *
     * Sorts the pilots according to the sorting criteria that was previously set.
     *
     * This method returns nothing.
     */

    public void sortPilots () {
        Collections.sort (getPilotList (), getPilotSorter ());
    }


    /**
     * Name: getCarSorter
     * @return Comparator
     *
     * Returns a comparator to sort the team's cars.
     */

    public Comparator getCarSorter () {
        return carSorter;
    }


    /**
     * Name: setCarSorter
     * @param carSorter is the sorting criteria that was previously set.
     * @param reverseSorting indicates if the order must be reversed (true) or un-reversed (false).
     *
     * This method returns nothing.
     */

    public void setCarSorter (Comparator carSorter, boolean reverseSorting) {
        if (reverseSorting) {
            this.carSorter = Collections.reverseOrder (carSorter);
        }
        else {
            this.carSorter = carSorter;
        }
        sortCars ();
    }


    /**
     * Name: sortCars
     * Sorts the cars according to the sorting criteria selected.
     *
     * This method returns nothing.
     */

    public void sortCars () {
        Collections.sort (getCarList (), getCarSorter ());
    }


    /**
     * Name: register
     * Registers the team in the championship celebrated by the organization
     *
     * This method returns nothing.
     */
    public void register () {
        Organization.getInstance ().registerTeam (this);
    }


    /**
     * Name: calculateSumPilotPoints
     * @return int is the sum of all the points from all the pilots.
     *
     * Calculates the total points of a team
     * This method returns an integer value that corresponds to the sum of all the points from all the pilots.
     */

    public int calculateSumPilotPoints () {
        int sum = 0;
        for (Pilot p: getPilotList ()) {
            if (!p.isDisqualified ()) {
                sum += p.getPoints ();
            }
        }
        return sum;
    }


    /**
     * Name: isDisqualified
     * @return boolean indicates whether a team is disqualified or not.
     *
     * The boolean result returned is such indicator.
     */

    public boolean isDisqualified () {
        boolean result = true;
        Pilot p = null;
        for (int index = 0; (index < getPilotList ().size ()) && (result); index++) {
            p = getPilotList ().get (index);
            if (!p.isDisqualified ()) {
                result = false;
            }
        }
        return result;
    }


    /**
     * Name: toString
     * @return String
     *
     * Represents the information from the class in a String variable.
     */

    @Override
    public String toString () {
        return "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
                "\n" +
                "%%% " + getName().toUpperCase() + " %%%" +
                "\n" +
                toStringPilotList () + toStringCarList () +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
    }


    /**
     * Name: toStringPilotList
     * @return String
     *
     * Represents the entire list of pilots in a String variable.
     */

    public String toStringPilotList () {
        StringBuilder builder = new StringBuilder ();
        if (getPilotList ().size () == 0) {
            builder.append ("No pilots in " + getName());
        }
        else {
            for (Pilot p: getPilotList ()) {
                builder.append (p.toString () + "\n");
            }
        }
        return builder.toString ();
    }


    /**
     * Name: toStringCarList
     * @return String
     *
     * Represents the entire list of cars in a String variable.
     */

    public String toStringCarList () {
        StringBuilder builder = new StringBuilder ();
        if (getCarList ().size () == 0) {
            builder.append ("No cars in " + getName());
        }
        else {
            for (Carable c: getCarList ()) {
                builder.append (c.toString () + "\n");
            }
        }
        return builder.toString ();
    }


    /**
     * Name: sendPilotsToRace
     * Sends the pilot with a car to a race if there is any car available.
     *
     * This method returns nothing.
     */

    public void sendPilotsToRace () {
        Pilot p;
        Carable c;
        boolean carSet = false;
        boolean filled = false;
        int counter = 0;
        sortPilots ();
        sortCars ();
        Iterator <Pilot> pilotIterator = getPilotList ().iterator ();
        Iterator <Carable> carIterator = getCarList ().iterator ();

        while (pilotIterator.hasNext () && (!filled)) {
            p = pilotIterator.next ();
            if (!p.isDisqualified ()) {
                while ((carIterator.hasNext ()) && (!carSet)) {
                    c = carIterator.next ();
                    if (c.getCurrentFuel () > 0) {
                        p.setCar (c);
                        carSet = true;
                    }
                }
                if (Organization.getInstance ().getPilotsLimit () > counter) {
                    if(p.getCar () != null){
                        Organization.getInstance ().getRacingPilots ().add (p);
                        carSet = false;
                        counter++;
                    }
                    else{
                        System.out.println ("¡¡¡ "+p.getName ()+" is not sent to the race because their team("+
                                getName ()+") has no more available cars with fuel !!!");
                    }
                }
                if (counter >= Organization.getInstance ().getPilotsLimit ()) {
                    filled = true;
                }
            }
        }
    }
}
