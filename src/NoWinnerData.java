/**
 * The class that initialises the program with all the necessary data in order to finish the championship without a winner.
 *
 * @author profesores DP
 * @version 20/21
 */

public class NoWinnerData {

    /**
     * Name: CompleteChampionship
     *
     * It shows on the console the title for this simulation and initialises the data.
     */

    public NoWinnerData () {
        System.out.println("*********************************************************************************************************");
        System.out.println("**********THIS SIMULATION FINISHES BEFORE THE CHAMPIONSHIP BECAUSE ALL PILOTS WERE DISQUALIFIED**********");
        System.out.println("*********************************************************************************************************\n");
        initData ();
    }


    /**
     * Name: initData
     *
     * Sets all the data needed to start the competition
     */

    private void initData () {
        Organization.getInstance ().setLeftLimit (1);
        Organization.getInstance ().setPilotsLimit(3);
        Organization.getInstance ().createSetForTracks(new TrackDistanceComparator(), true);

        Trackable Portugal = new Track ("Portugal", TrackComplexity.MEDIUM, TrackDistance.INTERMEDIATE);
        Portugal = new GravelTrack (Portugal);
        Portugal = new NightTrack (Portugal);
        Organization.getInstance ().getTracks ().add(Portugal);

        Trackable Cerdena = new Track ("Cerdeña", TrackComplexity.HIGH, TrackDistance.SHORT);
        Cerdena = new GravelTrack (Cerdena);
        Cerdena = new WetTrack (Cerdena);
        Organization.getInstance ().getTracks ().add (Cerdena);

        Trackable Australia = new Track ("Australia", TrackComplexity.LOW, TrackDistance.LONG);
        Australia = new GravelTrack (Australia);
        Organization.getInstance ().getTracks ().add (Australia);

        Trackable Corcega = new Track ("Córcega", TrackComplexity.MEDIUM, TrackDistance.INTERMEDIATE);
        Corcega = new NightTrack (Corcega);
        Corcega = new GravelTrack (Corcega);
        Organization.getInstance ().getTracks ().add (Corcega);

        Trackable Finlandia = new Track ("Finlandia", TrackComplexity.HIGH, TrackDistance.SHORT);
        Finlandia = new NightTrack (Finlandia);
        Finlandia = new ColdTrack (Finlandia);
        Finlandia = new WetTrack (Finlandia);
        Organization.getInstance ().getTracks ().add (Finlandia);

        Trackable Alemania = new Track ("Alemania", TrackComplexity.MEDIUM, TrackDistance.INTERMEDIATE);
        Alemania = new WetTrack (Alemania);
        Organization.getInstance ().getTracks ().add (Alemania);

        Trackable Chile = new Track ("Chile", TrackComplexity.HIGH, TrackDistance.SHORT);
        Chile = new GravelTrack (Chile);
        Organization.getInstance ().getTracks ().add (Chile);

        Team Peugeot = new Team ("Peugeot");
        Peugeot.getCarList ().add (new DurableCar ("Peugeot 5008", CarSpeed.SLOW, CarFuel.GENEROUS));
        Peugeot.getCarList ().add (new FastCar ("Peugeot 3008", CarSpeed.CHEETAH, CarFuel.NORMAL));
        Peugeot.getCarList ().add (new Car ("Peugeot 2008", CarSpeed.AVERAGE, CarFuel.LIMITED));
        Peugeot.getPilotList ().add (new ExperiencedPilot ("Kankunnen", PilotConcentration.FOCUSED));
        Peugeot.getPilotList ().add (new StarPilot ("Sainz", PilotConcentration.ZEN));
        Peugeot.getPilotList ().add (new RookiePilot ("Sordo", PilotConcentration.CLUELESS));
        Peugeot.setPilotSorter (new PilotPointsComparator(), true);
        Peugeot.setCarSorter (new CarCurrentFuelComparator(), false);
        Organization.getInstance ().getTeamList ().add (Peugeot);

        Team Citroen = new Team ("Citroen");
        Citroen.getCarList ().add (new DurableCar ("Citroen C5", CarSpeed.FAST, CarFuel.ELEPHANT));
        Citroen.getCarList ().add (new FastCar ("Citroen C4", CarSpeed.FAST, CarFuel.LIMITED));
        Citroen.getCarList ().add (new Car ("Citroen C3", CarSpeed.FAST, CarFuel.LIMITED));
        Citroen.getPilotList ().add (new ExperiencedPilot ("Loeb", PilotConcentration.STANDARD));
        Citroen.getPilotList ().add (new StarPilot ("Makinen", PilotConcentration.ZEN));
        Citroen.getPilotList ().add (new RookiePilot ("Auriol", PilotConcentration.STANDARD));
        Citroen.setPilotSorter (new PilotPointsComparator(), false);
        Citroen.setCarSorter (new CarCurrentFuelComparator(), false);
        Organization.getInstance ().getTeamList ().add (Citroen);

        Team Seat = new Team ("Seat");
        Seat.getCarList ().add (new DurableCar ("Seat Tarraco", CarSpeed.TURTLE, CarFuel.GENEROUS));
        Seat.getCarList ().add (new FastCar ("Seat Ateca", CarSpeed.CHEETAH, CarFuel.GENEROUS));
        Seat.getCarList ().add (new Car ("Seat Arona", CarSpeed.FAST, CarFuel.LIMITED));
        Seat.getPilotList ().add (new ExperiencedPilot("Ogier", PilotConcentration.STANDARD));
        Seat.getPilotList ().add (new StarPilot("McRae", PilotConcentration.FOCUSED));
        Seat.getPilotList ().add (new RookiePilot("Blomquist", PilotConcentration.CLUELESS));
        Seat.setPilotSorter (new PilotPointsComparator(), true);
        Seat.setCarSorter (new CarCurrentFuelComparator(), false);
        Organization.getInstance ().getTeamList ().add (Seat);
    }
}


