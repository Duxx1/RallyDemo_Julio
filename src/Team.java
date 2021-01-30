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

    public void setCarList (List<Carable> carList) {
        this.carList = carList;
    }

    public Map <String, Pilot> getDisqualifiedPilots() {
        return disqualifiedPilots;
    }

    public void setDisqualifiedPilots (Map <String, Pilot> disqualifiedPilots) {
        this.disqualifiedPilots = disqualifiedPilots;
    }

    public Comparator getPilotSorter () {
        return pilotSorter;
    }

    public void setPilotSorter (Comparator pilotSorter, boolean reverseSorting) {
        if (reverseSorting) {
            this.pilotSorter = Collections.reverseOrder (pilotSorter);
        }
        else {
            this.pilotSorter = pilotSorter;
        }
        sortPilots ();
    }

    public void sortPilots () {
        Collections.sort (getPilotList (), getPilotSorter ());
    }

    public Comparator getCarSorter () {
        return carSorter;
    }

    public void setCarSorter (Comparator carSorter, boolean reverseSorting) {
        if (reverseSorting) {
            this.carSorter = Collections.reverseOrder (carSorter);
        }
        else {
            this.carSorter = carSorter;
        }
        sortCars ();
    }

    public void sortCars () {
        Collections.sort (getCarList (), getCarSorter ());
    }

    public void register () {
        Organization.getInstance ().registerTeam (this);
    }

    public int calculateSumPilotPoints () {
        int sum = 0;
        for (Pilot p: getPilotList ()) {
            sum += p.getPoints ();
        }
        return sum;
    }
}
