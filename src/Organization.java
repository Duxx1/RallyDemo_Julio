//import java.util.*;
//
///**
// * Name: Organization
// * The class that organises the tournament.
// *
// * @version 1.0 (12/27/2020) 30/01/21
// * @author Raúl && Eduardo
// */
//public class Organization {
//    private static Organization organization=null;//this is for the Singleton design pattern
//    private int leftLimit;//limite de abandonos
//    private int pilotsLimit;//limite de pilotos
//    private Set<Trackable> tracks;//A set for the tracks where the races will be celebrated
//    private List<Pilot> racingPilots;//A list for the pilots which will race
//    private List<Team> teamList;//A list for the teams which will compete
//
//    /**
//     * Name: Organization
//     * This method returns nothing since it is the class constructor.
//     */
//    //default constructor invoked from Singleton
//    private Organization(){
//        this.tracks = new TreeSet<>();
//        this.racingPilots = new ArrayList<>();
//        this.teamList = new ArrayList<>();
//    }
//
//    /**
//     * Name: getInstance
//     * @return Organization
//     * Returns the instance of the Organization
//     */
//    public static Organization getInstance(){
//        if(organization == null){
//            organization = new Organization();
//        }
//        return organization;
//    }
//
//    /**
//     * Name: getLeftLimit
//     * @return int
//     *
//     * Returns the limit of left-pilots that the organization has.
//     */
//    public int getLeftLimit() {
//        return leftLimit;
//    }
//
//    /**
//     * Name: setLeftLimit
//     * @param leftLimit: int
//     * Sets the given left limit to the organization's.
//     * The parameter "leftLimit" corresponds to the left limit of the organization.
//     * This method returns nothing.
//     */
//    public void setLeftLimit(int leftLimit) {
//        this.leftLimit = leftLimit;
//    }
//
//    /**
//     * Name: getPilotsLimit
//     * @return int
//     *
//     * Returns the limit of pilots that the organization has.
//     */
//    public int getPilotsLimit() {
//        return pilotsLimit;
//    }
//
//    /**
//     * Name: setPilotLimit
//     * @param pilotsLimit: int
//     * Sets the given pilot limit to the organization's.
//     * The parameter "pilotLimit" corresponds to the pilot limit of the organization.
//     * This method returns nothing.
//     */
//    public void setPilotsLimit(int pilotsLimit) {
//        this.pilotsLimit = pilotsLimit;
//    }
//
//    /**
//     * Name: getTracks
//     * @return TreeSet <Trackable>
//     *
//     * Returns set of tracks.
//     */
//    public Set<Trackable> getTracks() {
//        return tracks;
//    }
//
//    /**
//     * Name: setTracks
//     * @return TreeSet <Trackable>
//     *
//     * Establishes the set of tracks.
//     */
//    public void setTracks(Set<Trackable> tracks) {
//        this.tracks = tracks;
//    }
//
//    /**
//     * Name: getRacingPilots
//     * @return ArrayList <Pilot>
//     *
//     * Returns the list of pilots.
//     */
//    public List<Pilot> getRacingPilots() {
//        return racingPilots;
//    }
//
//    /**
//     * Name: setRacingPilots
//     * @return ArrayList <Pilot>
//     *
//     * Establishes the list of pilots.
//     */
//    public void setRacingPilots(List<Pilot> racingPilots) {
//        this.racingPilots = racingPilots;
//    }
//
//    /**
//     * Name: getTeamList
//     * @return ArrayList <Team>
//     *
//     * Returns the list of teams.
//     */
//    public List<Team> getTeamList() {
//        return teamList;
//    }
//
//    /**
//     * Name: setTeamList
//     * @return ArrayList <Team>
//     *
//     * Establishes the list of teams for the Organization.
//     */
//    public void setTeamList(List<Team> teamList) {
//        this.teamList = teamList;
//    }
//}
