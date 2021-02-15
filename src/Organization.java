import java.util.*;

/**
 * Name: Organization
 * The class that organises the tournament.
 *
 * @version 1.0 (12/27/2020) 30/01/21
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class Organization {
    private static Organization organization = null;//this is for the Singleton design pattern
    private int leftLimit;//limite de abandonos
    private int pilotsLimit;//limite de pilotos
    private Set<Trackable> tracks;//A set for the tracks where the races will be celebrated
    private List<Pilot> racingPilots;//A list for the pilots which will race
    private List<Team> teamList;//A list for the teams which will compete
    private Map <Pilot, Team> disqualifiedPilots;

    /**
     * Name: Organization
     * Initialises the values of the class to the given.
     * This method returns nothing since it is the class constructor.
     */
    //default constructor invoked from Singleton
    private Organization () {
        this.racingPilots = new ArrayList <>();
        this.teamList = new ArrayList <>();
        this.disqualifiedPilots = new TreeMap <Pilot, Team> (new DisqualifiedPilotsComparator ().reversed ());
    }

    /**
     * Name: getInstance
     * @return Organization
     * Returns the instance of the Organization.
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
     * Sets the given left limit to the organization.
     * The param "leftLimit" corresponds to the left limit of the organization.
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
     * Sets the given pilot limit to the organization.
     * The param "pilotsLimit" corresponds to the pilot limit of the organization.
     * This method returns nothing.
     */
    public void setPilotsLimit(int pilotsLimit) {
        this.pilotsLimit = pilotsLimit;
    }

    /**
     * Name: getTracks
     * @return Set <Trackable>
     *
     * Returns a set of tracks.
     */
    public Set<Trackable> getTracks() {
        return tracks;
    }

    /**
     * Name: setTracks
     * @param tracks: Set<Trackable>
     *
     * The param "tracks" is the set of tracks.
     * Establishes the set of tracks.
     */
    public void setTracks(Set<Trackable> tracks) {
        this.tracks = tracks;
    }

    /**
     * Name: getRacingPilots
     * @return List <Pilot>
     *
     * Returns the list of pilots.
     */
    public List<Pilot> getRacingPilots() {
        return racingPilots;
    }

    /**
     * Name: setRacingPilots
     * @param racingPilots: List<Pilot>
     * The param "racingPilots" is the list of the pilots that will race.
     *
     * Establishes the list of pilots.
     */
    public void setRacingPilots(List<Pilot> racingPilots) {
        this.racingPilots = racingPilots;
    }

    /**
     * Name: getTeamList
     * @return List <Team>
     *
     * Returns the list of teams.
     */
    public List<Team> getTeamList() {
        return teamList;
    }

    /**
     * Name: setTeamList
     * @param teamList: List<Team>
     * The param "teamList" is the list of teams that will compete.
     *
     * Establishes the list of teams for the Organization.
     */
    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    /**
     * Name: registerTeam
     * @param t: Team
     * The param "t" is the team that will be registered.
     *
     * Registers a team in the organization.
     */
    public void registerTeam (Team t) {
        getTeamList ().add (t);
    }

    /**
     * Name: createSetForTracks
     * @param comp: Comparator
     * @param reverse: boolean
     * The param "comp" is the comparator that will be used.
     * The param "reversed" is used to invert the order of the sorting.
     *
     * Creates a set for the tracks, which will be ordered at its creation.
     */
    //despues de crear la organizacion, llamar a este metodo pasandole los criterios de ordenacion por parametros y el booleano
    public void createSetForTracks(Comparator comp, boolean reverse){
        if(reverse){
            this.tracks=new TreeSet<>(Collections.reverseOrder(comp));
        }
        else{
            this.tracks=new TreeSet<>(comp);
        }
    }

    /**
     * Name: showTracks
     *
     * Shows all the tracks of the championship.
     */
    public void showTracks(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| TRACKS OF CHAMPIONSHIP |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Trackable track : tracks){
            System.out.println(track.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    }

    /**
     * Name: showTeams
     *
     * Shows all the teams of the championship.
     */
    public void showTeams(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% TEAMS OF THE CHAMPIONSHIP %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for(Team t : teamList){
            System.out.println(t.toString());

        }
        System.out.println();
    }

    /**
     * Name: celebrateRace
     *
     * This method celebrates the all the races of the championship.
     */
    public void celebrateRace(){
        int counter=1;
        boolean fin=false;
        Trackable t=null;
        Iterator<Trackable> it = getTracks().iterator();
        while(it.hasNext() && !fin){
            t=it.next();
            System.out.println("*********************************************************************************************************");
            System.out.println("*** RACE<" + counter + "> IN " + t.toString() + "***");
            System.out.println("*********************************************************************************************************");

            if(!canStartRace()){
                System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
                System.out.println("¡¡¡ This race and next one(s) are not celebrated because there are no more pilots to race !!!!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                fin=true;
            }
            else{
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
                System.out.println("+++++++++++++++++++++++++ Start the race in " + t.getTrackName()+ " +++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                int numPilot=1;
                for(Pilot p : racingPilots){
                    System.out.println("@@@ Pilot "+numPilot+" of "+racingPilots.size());
                    System.out.println(p.toString());
                    System.out.println(p.getCar().toString());
                    p.drive(t);
                    if(p.getLeavesNumber() >= getLeftLimit()){
                        p.setDisqualified(true);
                        System.out.println("@@@");
                        System.out.println("¡¡¡ "+p.getName()+" is DISQUALIFIED from the championship for reaching the leftLimit("+getLeftLimit()+") !!!");
                        System.out.println("@@@");
                        System.out.println();
                    }
                    numPilot++;
                }
                //ordenar de menor a mayor, sacar los de ptos negativos
                givePointsAfterRace(t);
                for (Pilot p: getRacingPilots ()) {
                    p.setCar (null);
                }
                racingPilots.clear();
                counter++;
            }
        }
    }

    /**
     * Name: givePointsAfterRace
     * @param t: Trackable
     * The param "t" is the track
     *
     * This method gives the points to each pilot that has raced in the track.
     */
    public void givePointsAfterRace(Trackable t){
        Collections.sort(racingPilots, new PilotLastTimeComparator());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++ Final result for the race in "+t.getTrackName()+" +++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Pilot aux;
        int counter=1;
        int points=10;
        int negativeNumber=0;
        int var = 0;
        for(Pilot pil : racingPilots){
            if(pil.getResults().getLast().getTime() < 0){
                negativeNumber++;
            }
        }
        while(var < negativeNumber){
            aux= getRacingPilots().get(0);
            if(aux.getResults().getLast().getTime() < 0){
                racingPilots.remove(aux);
                racingPilots.add(aux);
            }//at the end of the list the negative times
            var++;
        }
        Iterator <Pilot> it= getRacingPilots().iterator();
        while(it.hasNext()){
            aux=it.next();
            if(aux.getResults().getLast().getTime() < 0){
                aux.getResults().getLast().setPoints(0);
                if(aux.isDisqualified()){
                    System.out.println("¡¡¡ "+aux.getName()+" has abandoned - Time: "+
                            aux.getResults().getLast().getTime()+" minutes - Points: "+
                            aux.getResults().getLast().getPoints() + " - Besides it has been disqualified for the rest of the championship !!!");

                }
                else{
                    System.out.println("¡¡¡ "+aux.getName()+" has abandoned - Time: "+
                            aux.getResults().getLast().getTime()+" minutes - Points: "+
                            aux.getResults().getLast().getPoints() + " !!!");
                }
            }
            else{
                aux.getResults().getLast().setPoints(points);
                System.out.println("@@@ Position("+counter+"): "+aux.getName()+" - Time: " +
                        aux.getResults().getLast().getTime()+" minutes - Points: "+
                        aux.getResults().getLast().getPoints() + " @@@");
            }
            if(points == 2){
                points += 2;
            }
            points = points -2;
            counter++;
        }
        System.out.println();
    }

    public boolean allPilotsDisqualified(){
        boolean sol=true;
        Team t=null;
        Pilot p=null;
        for(int i=0; i < getTeamList().size() && sol; i++){
            t=getTeamList().get(i);
            for(int j=0; j < t.getPilotList().size() && sol; j++){
                p=t.getPilotList().get(j);
                if(!p.isDisqualified()){
                    sol=false;
                }
            }
        }
        return sol;
    }

    /**
     * Name: pilotsFinalClasification
     *
     * This method shows the final clasification of the pilots.
     */
    //this method shows the final clasification of the pilots

    public void pilotsFinalClassification(){
        System.out.println("**************************************************");
        System.out.println("**************** END OF THE CHAMPIONSHIP *********");
        System.out.println("**************************************************");
        System.out.println("************* PILOTS FINAL CLASSIFICATION ********");
        System.out.println("**************************************************");

        if(allPilotsDisqualified()){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Pilots championship declared with no winner because all pilots were disqualified !!!");
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
        }

        //cogemos los pilotos de las escuderias y los metemos en una lista

        for(Team t : teamList){
            for(Pilot p : t.getPilotList()){
                disqualifiedPilots.put (p, t);
            }
        }//ordenamos la lista

        List <Pilot> pilotListForPoints = new ArrayList<>();

        for (Pilot p: disqualifiedPilots.keySet ()) {
            if (!p.isDisqualified()) {
                pilotListForPoints.add (p);
            }
        }
        Collections.sort (pilotListForPoints, new PilotPointsComparator().reversed ());

        int counter = 1;
        int points = 0;
        for(Pilot pil : pilotListForPoints){
                points=pil.getPoints();
                System.out.println("@@@ Position("+counter+"): "+pil.getName()+" - Total Points: "+points+" @@@");
                for(Results r : pil.getResults()){
                    System.out.println("Race("+r.getTrack().getTrackName()+") - Points:"+r.getPoints()+" - Time:"+r.getTime()+" minutes");
                }
                System.out.println();
                counter++;
        }

        System.out.println("**************************************************");
        System.out.println("************* DISQUALIFIED PILOTS ****************");
        System.out.println("**************************************************");
        for (Pilot aux : disqualifiedPilots.keySet ()) {
            if (aux.isDisqualified()) {
                System.out.println("--- Disqualified Pilot: " + aux.getName() + " - Total Erased Points:" + aux.getPoints() + " ---");
                for (Results r : aux.getResults()) {
                    System.out.println("Race(" + r.getTrack().getTrackName() + ") - Points:" + r.getPoints() + " - Time:" + r.getTime() + " minutes");
                }
                System.out.println();
            }
        }
    }

    public void teamsFinalClassification () {
        System.out.println ("**************************************************");
        System.out.println ("********** TEAMS FINAL CLASSIFICATION ************");
        System.out.println ("**************************************************");

        if(allPilotsDisqualified()){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Teams championship declared with no winner because all pilots were disqualified !!!");
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
        }

        int teamCounter = 1;
        for (Team t : getTeamList ()) {
            if (!t.isDisqualified ()) {
                System.out.println("@@@ Position(" + teamCounter + ") " + t.getName() + " with " + t.calculateSumPilotPoints() +
                        " points @@@");

                t.setCarSorter (new CarCurrentFuelComparator (), true);

                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("%%% "+t.getName()+" %%%");

                for(Pilot p : t.getPilotList()){    //first we show not disqualified pilots
                    if(!p.isDisqualified())
                        System.out.println(p.toString());
                }

                for(Pilot p : t.getPilotList()){    //after that we show disqualified pilots
                    if(p.isDisqualified())
                        System.out.println(p.toString());
                }

                for(Carable c : t.getCarList()){
                    System.out.println(c.toString());
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
                System.out.println(t.toString());
            }
        }
    }

    public boolean canStartRace(){
        boolean sol=false;
        int cont=0;
        Team t=null;
        Pilot p=null;
        for(int i=0; i < getTeamList().size() && !sol; i++){
            t=getTeamList().get(i);
            for(int j=0; j < t.getPilotList().size() && !sol; j++){
                p=t.getPilotList().get(j);
                if(!p.isDisqualified()){
                    cont++;
                }
                if(cont >= 2){
                    sol=true;
                }
            }
        }//condition of number of pilots >= 2
        return sol;
    }

    /**
     * Name: manageChampionship
     *
     * This method manages the championship.
     */
    public void manageChampionship(){
        showTracks();
        showTeams();
        celebrateRace();
        pilotsFinalClassification();
        teamsFinalClassification ();
    }
}
