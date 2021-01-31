import java.util.*;

/**
 * Name: Organization
 * The class that organises the tournament.
 *
 * @version 1.0 (12/27/2020) 30/01/21
 * @author Raúl && Eduardo
 */
public class Organization {
    private static Organization organization = null;//this is for the Singleton design pattern
    private int leftLimit;//limite de abandonos
    private int pilotsLimit;//limite de pilotos
    private Set<Trackable> tracks;//A set for the tracks where the races will be celebrated
    private List<Pilot> racingPilots;//A list for the pilots which will race
    private List<Team> teamList;//A list for the teams which will compete

    /**
     * Name: Organization
     * This method returns nothing since it is the class constructor.
     */
    //default constructor invoked from Singleton
    private Organization () {
        this.racingPilots = new ArrayList <>();
        this.teamList = new ArrayList <>();
    }

    /**
     * Name: getInstance
     * @return Organization
     * Returns the instance of the Organization
     */
    public static Organization getInstance () {
        if (organization == null) {
            organization = new Organization();
        }
        return organization;
    }

    /**
     * Name: getLeftLimit
     * @return int
     *
     * Returns the limit of left-pilots that the organization has.
     */
    public int getLeftLimit() {
        return leftLimit;
    }

    /**
     * Name: setLeftLimit
     * @param leftLimit: int
     * Sets the given left limit to the organization's.
     * The parameter "leftLimit" corresponds to the left limit of the organization.
     * This method returns nothing.
     */
    public void setLeftLimit(int leftLimit) {
        this.leftLimit = leftLimit;
    }

    /**
     * Name: getPilotsLimit
     * @return int
     *
     * Returns the limit of pilots that the organization has.
     */
    public int getPilotsLimit() {
        return pilotsLimit;
    }

    /**
     * Name: setPilotLimit
     * @param pilotsLimit: int
     * Sets the given pilot limit to the organization's.
     * The parameter "pilotLimit" corresponds to the pilot limit of the organization.
     * This method returns nothing.
     */
    public void setPilotsLimit(int pilotsLimit) {
        this.pilotsLimit = pilotsLimit;
    }

    /**
     * Name: getTracks
     * @return TreeSet <Trackable>
     *
     * Returns set of tracks.
     */
    public Set<Trackable> getTracks() {
        return tracks;
    }

    /**
     * Name: setTracks
     * @return TreeSet <Trackable>
     *
     * Establishes the set of tracks.
     */
    public void setTracks(Set<Trackable> tracks) {
        this.tracks = tracks;
    }

    /**
     * Name: getRacingPilots
     * @return ArrayList <Pilot>
     *
     * Returns the list of pilots.
     */
    public List<Pilot> getRacingPilots() {
        return racingPilots;
    }

    /**
     * Name: setRacingPilots
     * @return ArrayList <Pilot>
     *
     * Establishes the list of pilots.
     */
    public void setRacingPilots(List<Pilot> racingPilots) {
        this.racingPilots = racingPilots;
    }

    /**
     * Name: getTeamList
     * @return ArrayList <Team>
     *
     * Returns the list of teams.
     */
    public List<Team> getTeamList() {
        return teamList;
    }

    /**
     * Name: setTeamList
     * @return ArrayList <Team>
     *
     * Establishes the list of teams for the Organization.
     */
    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    /**
     * Name: registerTeam
     * @return nothing
     *
     * Registers a team in organization
     */
    public void registerTeam (Team t) {
        getTeamList ().add (t);
    }

    //despues de crear la organizacion, llamar a este metodo pasandole los criterios de ordenacion por parametros y el booleano
    public void createSetForTracks(Comparator comp, boolean reverse){
        if(reverse){
            this.tracks=new TreeSet<>(Collections.reverseOrder(comp));
        }
        else{
            this.tracks=new TreeSet<>(comp);
        }
    }

    public void showTracks(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| TRACKS OF CHAMPIONSHIP |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Trackable track : tracks){
            System.out.println(track.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    }

    public void showTeams(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% TEAMS OF THE CHAMPIONSHIP %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for(Team t : teamList){
            System.out.println(t.toString());

        }
        System.out.println();
    }

    public void celebrateRace(){
        int counter=1;
        for(Trackable t : tracks){
            System.out.println("*********************************************************************************************************");
            System.out.println("*** RACE<" + counter + "> IN " + t.toString() + "***");
            System.out.println("*********************************************************************************************************");
            for(Team team : Organization.getInstance().getTeamList()){
                team.sendPilotsToRace();
            }
            Collections.sort(racingPilots, new PilotRaceComparator());//ordering pilots before the race
            System.out.println("*********************************************************************************************************");
            System.out.println("******************************** Pilots which will compete in " + t.getTrackName() + " ********************************");
            System.out.println("***********************************************************************************************************");
            for(Pilot p : racingPilots){
                System.out.println(p.toString());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ START THE RACE IN AUSTRALIA +++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            for(Pilot p : racingPilots){
                System.out.println("@@@ Pilot "+counter+" of "+racingPilots.size());
                System.out.println(p.toString());
                System.out.println(p.getCar().toString());
                p.drive(t);
            }

            counter++;
        }
    }

    public void manageChampionship(){
        showTracks();
        showTeams();
        celebrateRace();
    }
}
