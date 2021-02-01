import java.util.*;

/**
 * Name: Team
 * It keeps all its cars and pilots.
 *
 * @version 1.0 (12/23/2020) 30/01/21
 * @author Raúl && Eduardo
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
     * @param name: String
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "name" corresponds to the name of the team.
     *
     * This method returns nothing since it is the class constructor.
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
    public String getName() {
        return name;
    }

    /**
     * Name: setTeamName
     * @param name: String
     * Sets the given name to the team.
     * The parameter "teamName" corresponds to the name of the team.
     * This method returns nothing.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name: getPilotList
     * @return ArrayList <Pilot>
     *
     * Returns the ArrayList of pilots.
     */
    public List <Pilot> getPilotList () {
        return pilotList;
    }

    /**
     * Name: setPilotList
     * @param pilotList: List<Pilot>
     * Sets the list of pilots of the team.
     * This method returns nothing.
     */
    public void setPilotList (List <Pilot> pilotList) {
        this.pilotList = pilotList;
    }

    /**
     * Name: getCarList
     * @return LinkedList <Car>
     *
     * Returns the LinkedList of cars.
     */
    public List<Carable> getCarList () {
        return carList;
    }

    /**
     * Name: setCarList
     * @param carList: List<Carable>
     * Sets the given list of cars to the team.
     * The parameter "carList" corresponds to the list of cars of the team.
     * This method returns nothing.
     */
    public void setCarList (List<Carable> carList) {
        this.carList = carList;
    }

    /**
     * Name: getDisqualifiedPilots
     * @return Map<String, Pilot>
     *
     * Returns a map which contains a list of the disqualified pilots.
     */
    public Map <String, Pilot> getDisqualifiedPilots() {
        return disqualifiedPilots;
    }

    /**
     * Name: setDisqualifiedPilots
     * @param disqualifiedPilots: Map<String, Pilot>
     * Sets the map of the disqualified pilots.
     * The parameter "disqualifiedPilots" corresponds to the name of the map with the disqualified pilots.
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

    //false ascendente, true descendente
    /**
     * Name: setPilotSorter
     * @param pilotSorter: Comparator
     * @param reverseSorting: boolean
     * The parameter "pilotSorter" corresponds to the way of sorting the pilots.
     * The parameter "reverseSorting" is to sort ASC when it is false or DESC when it is true.
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
     * Sorts the pilots acording to the strategy selected.
     * This method returns nothing.
     */
    public void sortPilots () {
        Collections.sort (getPilotList (), getPilotSorter ());
    }

    /**
     * Name: getCarSorter
     * @return Comparator
     *
     * Returns the comparator for the pilots.
     */
    public Comparator getCarSorter () {
        return carSorter;
    }

    /**
     * Name: setCarSorter
     * @param carSorter: Comparator
     * @param reverseSorting: boolean
     * The parameter "carSorter" corresponds to the way of sorting the cars.
     * The parameter "reverseSorting" is to sort ASC when it is false or DESC when it is true.
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
     * Sorts the cars according to the strategy selected.
     * The parameter "trackName" corresponds to the name of the track.
     * This method returns nothing.
     */
    public void sortCars () {
        Collections.sort (getCarList (), getCarSorter ());
    }

    //inscribe la escuderia en el campeonato gestionado por la organizacion
    /**
     * Name: register
     * Registers the team in the championship celebrated by the organization
     * This method returns nothing.
     */
    public void register () {
        Organization.getInstance ().registerTeam (this);
    }

    /**
     * Name: calculateSumPilotPoints
     * @return int
     * Calculates the total points of a team
     * This method returns nothing.
     */
    public int calculateSumPilotPoints () {
        int sum = 0;
        for (Pilot p: getPilotList ()) {
            sum += p.getPoints ();
        }
        return sum;
    }

    /**
     * Name: toString
     * @return String
     * Represents the information from the class in a String.
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
     * Sends the pilot with a car to a race if there is a car available.
     * This method returns nothing.
     */
    public void sendPilotsToRace () {
        Pilot p;
        Carable c;
        boolean carSet = false;
        boolean filled = false;
        int counter = 0;
        sortPilots();//ordering pilots
        sortCars();//ordering cars
        Iterator <Pilot> pilotIterator = getPilotList ().iterator ();
        Iterator <Carable> carIterator = getCarList ().iterator ();

        while (pilotIterator.hasNext () && (!filled)) {
            p = pilotIterator.next ();
            if (!p.isDisqualified()) {
                while ((carIterator.hasNext ()) && (!carSet)) {
                    c = carIterator.next ();
                    if (c.getCurrentFuel () > 0) {
                        p.setCar (c);
                        carSet = true;
                    }
                }
                if (Organization.getInstance ().getPilotsLimit() > counter) {
                    if(p.getCar()!=null){
                        Organization.getInstance().getRacingPilots().add(p);
                        carSet = false;
                        counter++;
                    }
                    else{
                        System.out.println("¡¡¡ "+p.getName()+" is not sent to the race because his team("+
                                getName()+") does not have more cars with available fuel !!!");
                    }
                }
                if (counter >= Organization.getInstance().getPilotsLimit()) {
                    filled = true;
                }
            }
        }
    }
}
