import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

/**
 * Name: Organization
 * This class organises the championship. It is based on the Singleton Design Pattern.
 *
 * @version 1.0 (01/30/2021)
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class Organization {
    private static Organization organization = null;
    private int leftLimit;
    private int pilotsLimit;
    private Set <Trackable> tracks;
    private List <Pilot> racingPilots;
    private List <Team> teamList;
    private Map <Pilot, Team> disqualifiedPilots;


    /**
     * Name: Organization
     *
     * Initialises the attributes of the class.
     * This method returns nothing.
     */

    private Organization () {
        racingPilots = new ArrayList <Pilot> ();
        teamList = new ArrayList <Team> ();
        disqualifiedPilots = new TreeMap <Pilot, Team> (new DisqualifiedPilotsComparator ().reversed ());
    }


    /**
     * Name: getInstance
     * @return Organization
     *
     * It returns the instance of the Organization.
     *
     * The returned value is always the same instance of the Organization class.
     */

    public static Organization getInstance () {
        if (organization == null) {
            organization = new Organization ();
        }
        return organization;
    }


    /**
     * Name: getLeftLimit
     * @return int
     *
     * It returns the maximum limit of leaves that a pilot can have.
     */

    public int getLeftLimit () {
        return leftLimit;
    }


    /**
     * Name: setLeftLimit
     * @param limit is the maximum times of leaves a pilot can have.
     *
     * It sets the given left limit to the Organization.
     *
     * This method returns nothing.
     */

    public void setLeftLimit (int limit) {
        leftLimit = limit;
    }


    /**
     * Name: getPilotsLimit
     * @return int
     *
     * It returns the limit of pilots that the organization has.
     */

    public int getPilotsLimit () {
        return pilotsLimit;
    }


    /**
     * Name: setPilotLimit
     * @param limit is the maximum number of pilots that can compete in a race.
     *
     * It sets the given pilot limit to the Organization.
     *
     * This method returns nothing.
     */

    public void setPilotsLimit (int limit) {
        pilotsLimit = limit;
    }


    /**
     * Name: getTracks
     * @return Set <Trackable>
     *
     * It returns the set of tracks.
     */

    public Set <Trackable> getTracks () {
        return tracks;
    }


    /**
     * Name: setTracks
     * @param trackSet is the set of tracks that will be assigned.
     *
     * It establishes the set of tracks.
     *
     * This method returns nothing.
     */

    public void setTracks (Set <Trackable> trackSet) {
        tracks = trackSet;
    }


    /**
     * Name: getRacingPilots
     * @return List <Pilot>
     *
     * It returns the list of pilots that will compete.
     */

    public List <Pilot> getRacingPilots () {
        return racingPilots;
    }


    /**
     * Name: setRacingPilots
     * @param pilots is the list of pilots that will be assgined.
     *
     * It establishes the list of pilots.
     */

    public void setRacingPilots (List <Pilot> pilots) {
        racingPilots = pilots;
    }


    /**
     * Name: getTeamList
     * @return List <Team>
     *
     * It returns the list of teams.
     */

    public List <Team> getTeamList () {
        return teamList;
    }


    /**
     * Name: setTeamList
     * @param list is the list of teams that will be assigned.
     *
     * It establishes the list of teams for the Organization.
     */

    public void setTeamList (List <Team> list) {
        teamList = list;
    }


    /**
     * Name: getDisqualifiedPilots
     * @return Map <Pilot, Team>
     *
     * It returns the map of teams depending on the pilot.
     */

    public Map <Pilot, Team> getDisqualifiedPilots () {
        return disqualifiedPilots;
    }


    /**
     * Name: setDisqualifiedPilots
     * @param map is the map of teams depending on the pilot that will be assigned.
     *
     * It establishes the map of teams depending on the pilot for the Organization.
     */

    public void setDisqualifiedPilots (Map <Pilot, Team> map) {
        disqualifiedPilots = map;
    }


    /**
     * Name: registerTeam
     * @param t is the team that will be registered.
     *
     * It registers a team in the Organization.
     */

    public void registerTeam (Team t) {
        getTeamList ().add (t);
    }


    /**
     * Name: createSetForTracks
     * @param comp is the comparator.
     * @param reverse is a boolean value indicating if the sorting must be done ascending or descending.
     *
     * It creates a set of tracks, which will be ordered at its creation.
     */

    public void createSetForTracks (Comparator comp, boolean reverse){
        if (reverse) {
            tracks = new TreeSet <Trackable> (Collections.reverseOrder (comp));
        }
        else {
            tracks = new TreeSet <Trackable> (comp);
        }
    }


    /**
     * Name: showTracks
     *
     * It shows all the tracks of the championship.
     *
     * This method returns nothing.
     */

    public void showTracks () {
        System.out.println ("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println ("||||||||||||||||||| TRACKS OF CHAMPIONSHIP |||||||||||||||||||");
        System.out.println ("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Trackable track : tracks) {
            System.out.println (track.toString ());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    }


    /**
     * Name: showTeams
     *
     * It shows all the teams of the championship.
     */

    public void showTeams () {
        System.out.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println ("%%%%%%%% TEAMS OF THE CHAMPIONSHIP %%%%%%%%");
        System.out.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for (Team t : teamList) {
            System.out.println (t.toString ());
        }
        System.out.println ();
    }


    /**
     * Name: celebrateRace
     *
     * It celebrates all the races of the championship.
     */

    public void celebrateRace () {
        int counter = 1;
        boolean end = false;
        Trackable t = null;
        Iterator <Trackable> it = getTracks().iterator();
        while (it.hasNext () && !end) {
            t = it.next ();
            System.out.println ("*********************************************************************************************************");
            System.out.println ("*** RACE<" + counter + "> IN " + t.toString () + "***");
            System.out.println ("*********************************************************************************************************");
            if (!canStartRace ()) {
                System.out.println ("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
                System.out.println ("¡¡¡ This race and next one(s) are not celebrated because there are no more pilots to race !!!!");
                System.out.println ("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                end = true;
            }
            else {
                for(Team team : Organization.getInstance ().getTeamList ()) {
                    team.sendPilotsToRace ();
                }
                Collections.sort (racingPilots, new PilotRaceComparator ());
                System.out.println ("*********************************************************************************************************");
                System.out.println ("******************************** Pilots which will compete in " + t.getTrackName () + " ********************************");
                System.out.println ("***********************************************************************************************************");
                for (Pilot p : racingPilots) {
                    System.out.println (p.toString ());
                }
                System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println ("+++++++++++++++++++ The race at " + t.getTrackName()+ " begins! ++++++++++++++++++++");
                System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                int numPilot = 1;
                for (Pilot p : racingPilots) {
                    System.out.println ("@@@ Pilot "+ numPilot +" of " + racingPilots.size ());
                    System.out.println (p.toString ());
                    System.out.println (p.getCar ().toString ());
                    p.drive (t);
                    if (p.getLeavesNumber () >= getLeftLimit ()){
                        p.setDisqualified (true);
                        System.out.println ("@@@");
                        System.out.println ("¡¡¡ " + p.getName ()+" is DISQUALIFIED from the championship for reaching the leftLimit (" + getLeftLimit () + ") !!!");
                        System.out.println ("@@@");
                        System.out.println ();
                    }
                    numPilot++;
                }
                givePointsAfterRace (t);
                for (Pilot p: getRacingPilots ()) {
                    p.setCar (null);
                }
                racingPilots.clear ();
                counter++;
            }
        }
    }


    /**
     * Name: givePointsAfterRace
     * @param t is the track where the pilots raced.
     *
     * This method gives the points to each pilot that has raced in the track.
     *
     * This method returns nothing.
     */

    public void givePointsAfterRace (Trackable t) {
        Collections.sort (racingPilots, new PilotLastTimeComparator ());
        System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println ("+++++++++++++++++ Final result in the race at "+t.getTrackName () + " +++++++++++++++++");
        System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Pilot aux = null;
        int counter = 1;
        int points = 10;
        int negativeNumber = 0;
        int var = 0;
        for (Pilot pil : racingPilots) {
            if (pil.getResults ().getLast ().getTime () < 0) {
                negativeNumber++;
            }
        }
        while (var < negativeNumber) {
            aux = getRacingPilots().get (0);
            if (aux.getResults ().getLast ().getTime () < 0) {
                racingPilots.remove (aux);
                racingPilots.add (aux);
            }
            var++;
        }
        Iterator <Pilot> it = getRacingPilots ().iterator ();
        while (it.hasNext ()) {
            aux = it.next ();
            if(aux.getResults ().getLast ().getTime () < 0) {
                aux.getResults ().getLast ().setPoints (0);
                if(aux.isDisqualified ()) {
                    System.out.println("¡¡¡ " + aux.getName () + " has abandoned - Time: " +
                            aux.getResults ().getLast ().getTime () + " minutes - Points: " +
                            aux.getResults ().getLast ().getPoints () + " - Besides it has been disqualified for the rest of the championship !!!");

                }
                else {
                    System.out.println ("¡¡¡ " + aux.getName () + " has abandoned - Time: " +
                            aux.getResults ().getLast ().getTime ()+" minutes - Points: " +
                            aux.getResults ().getLast ().getPoints () + " !!!");
                }
            }
            else {
                aux.getResults ().getLast ().setPoints (points);
                System.out.println ("@@@ Position (" + counter + "): " + aux.getName () + " - Time: " +
                        aux.getResults ().getLast ().getTime () + " minutes - Points: " +
                        aux.getResults ().getLast ().getPoints () + " @@@");
            }
            if (points == 2) {
                points += 2;
            }
            points = points - 2;
            counter++;
        }
        System.out.println ();
    }


    /**
     * Name: allPilotsDisqualified
     * @return boolean
     *
     * It indicates if all pilots are disqualified in all teams.
     *
     * This method returns a boolean: if it is true, all pilots are disqualified.
     */

    public boolean allPilotsDisqualified () {
        boolean sol = true;
        Team t = null;
        Pilot p = null;
        for (int i = 0; (i < getTeamList ().size ()) && (sol); i++) {
            t = getTeamList ().get (i);
            for (int j = 0; (j < t.getPilotList ().size ()) && (sol); j++) {
                p =t .getPilotList ().get (j);
                if (!p.isDisqualified ()) {
                    sol = false;
                }
            }
        }
        return sol;
    }


    /**
     * Name: pilotsFinalClassification
     *
     * It shows the final classification of the pilots after the championship.
     *
     * This method returns nothing.
     */

    public void pilotsFinalClassification () {
        System.out.println ("**************************************************");
        System.out.println ("**************** END OF THE CHAMPIONSHIP *********");
        System.out.println ("**************************************************");
        System.out.println ("************* PILOTS FINAL CLASSIFICATION ********");
        System.out.println ("**************************************************");

        if (allPilotsDisqualified ()) {
            System.out.println ("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println ("¡¡¡ The championship is declared with no winner because all pilots were disqualified !!!");
            System.out.println ("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
        }

        for (Team t : getTeamList ()) {
            for (Pilot p : t.getPilotList ()) {
                getDisqualifiedPilots ().put (p, t);
            }
        }

        List <Pilot> pilotListForPoints = new ArrayList <Pilot> ();
        for (Pilot p: getDisqualifiedPilots ().keySet ()) {
            if (!p.isDisqualified ()) {
                pilotListForPoints.add (p);
            }
        }
        Collections.sort (pilotListForPoints, new PilotPointsComparator ().reversed ());

        int counter = 1;
        int points = 0;
        for (Pilot pil : pilotListForPoints) {
                points = pil.getPoints ();
                System.out.println ("@@@ Position (" + counter + "): " + pil.getName () + " - Total Points: " + points + " @@@");
                for (Results r : pil.getResults ()) {
                    System.out.println ("Race (" + r.getTrack ().getTrackName () + ") - Points:" + r.getPoints () + " - Time:" + r.getTime () + " minutes");
                }
                System.out.println ();
                counter++;
        }

        System.out.println ("**************************************************");
        System.out.println ("************* DISQUALIFIED PILOTS ****************");
        System.out.println ("**************************************************");
        for (Pilot aux : getDisqualifiedPilots ().keySet ()) {
            if (aux.isDisqualified ()) {
                System.out.println ("--- Disqualified Pilot: " + aux.getName () + " - Total Erased Points:" + aux.getPoints () + " ---");
                for (Results r : aux.getResults ()) {
                    System.out.println ("Race (" + r.getTrack ().getTrackName () + ") - Points:" + r.getPoints () + " - Time:" + r.getTime () + " minutes");
                }
                System.out.println ();
            }
        }
    }


    /**
     * Name: teamsFinalClassification
     *
     * It shows the final classification for the teams.
     *
     * This method returns nothing.
     */

    public void teamsFinalClassification () {
        System.out.println ("**************************************************");
        System.out.println ("********** TEAMS FINAL CLASSIFICATION ************");
        System.out.println ("**************************************************");

        if (allPilotsDisqualified ()) {
            System.out.println ("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println ("¡¡¡ Teams championship is declared with no winner because all pilots were disqualified !!!");
            System.out.println ("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
        }

        int teamCounter = 1;
        for (Team t : getTeamList ()) {
            if (!t.isDisqualified ()) {
                System.out.println ("@@@ Position (" + teamCounter + ") " + t.getName () + " with " + t.calculateSumPilotPoints () +
                        " points @@@");
                t.setCarSorter (new CarCurrentFuelComparator (), true);

                System.out.println ("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println ("%%% "+t.getName ()+" %%%");

                for (Pilot p : t.getPilotList ()) {
                    if(!p.isDisqualified ())
                        System.out.println(p.toString ());
                }

                for(Pilot p : t.getPilotList ()){
                    if(p.isDisqualified ())
                        System.out.println(p.toString ());
                }

                for(Carable c : t.getCarList ()){
                    System.out.println(c.toString ());
                }

                teamCounter++;
            }
        }

        System.out.println ("**************************************************");
        System.out.println ("************** DISQUALIFIED TEAMS ****************");
        System.out.println ("**************************************************");
        for (Team t : getTeamList ()) {
            if (t.isDisqualified ()) {
                System.out.println ("¡¡¡ Disqualified team: " + t.getName () +
                        " with " + t.calculateSumPilotPoints () + " points !!!");
                t.setCarSorter (new CarCurrentFuelComparator (), true);
                System.out.println (t.toString ());
            }
        }
    }

    /**
     * Name: canStartRace
     * @return boolean
     *
     * It indicates if a race can start
     *
     * The returned boolean value is true when the race can start.
     */

    public boolean canStartRace () {
        boolean sol = false;
        int count = 0;
        Team t = null;
        Pilot p = null;
        for (int i = 0; (i < getTeamList ().size ()) && (!sol); i++) {
            t = getTeamList ().get (i);
            for (int j = 0; (j < t.getPilotList ().size ()) && (!sol); j++) {
                p = t.getPilotList ().get (j);
                if (!p.isDisqualified ()) {
                    count++;
                }
                if (count >= 2) {
                    sol = true;
                }
            }
        }
        return sol;
    }


    /**
     * Name: manageChampionship
     *
     * It manages the championship.
     *
     * This method returns nothing.
     */

    public void manageChampionship () {
        showTracks ();
        showTeams ();
        celebrateRace ();
        pilotsFinalClassification ();
        teamsFinalClassification ();
    }
}
