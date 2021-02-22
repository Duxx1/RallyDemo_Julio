import java.util.LinkedList;

    /**
     * Name: Pilot
     * This class represents all the information a Pilot must store
     *
     * @version 1.0 (01/29/2021)
     * @author Raul Hormigo Ceron and Eduardo Cano Garcia
     */


    public abstract class Pilot {
        private String name;
        private Carable car;
        protected PilotConcentration concentration;
        private LinkedList <Results> results;
        private boolean disqualified;
        private int leavesNumber;
        private int finishedRacesNumber;


        /**
         * Name: Pilot
         *
         * @param pilotName is the pilot's name.
         * @param pilotConcentration is the pilot's concentration vale.
         * It initialises the attributes from the class given certain values.
         *
         * This method returns nothing.
         */

        public Pilot (String pilotName, PilotConcentration pilotConcentration) {
            name = pilotName;
            concentration = pilotConcentration;
            disqualified = false;
            setCar (null);
            results = new LinkedList <Results> ();
            leavesNumber = 0;
            finishedRacesNumber = 0;
        }


        /**
         * Name: getName
         * @return String
         *
         * It returns the pilot's name.
         */

        public String getName () {
            return name;
        }


        /**
         * Name: setName
         * @param pilotName is the pilot's new name.
         * It sets the given name as the pilot's one.
         *
         * This method returns nothing.
         */

        public void setName (String pilotName) {
            name = pilotName;
        }


        /**
         * Name: getCar
         * @return Carable
         *
         * It returns the pilot's car.
         */

        public Carable getCar () {
            return car;
        }


        /**
         * Name: setCar
         * @param pilotCar is the pilot's new car.
         * It sets the given car to the pilot.
         *
         * This method returns nothing.
         */

        public void setCar (Carable pilotCar) {
            car = pilotCar;
        }


        /**
         * Name: getConcentration
         * @return PilotConcentration
         *
         * it returns the pilot's concentration.
         */

        public PilotConcentration getConcentration () {
            return concentration;
        }


        /**
         * Name: setConcentration
         * @param pilotConcentration is the pilot's new concentration.
         * It sets the given concentration to the pilot.
         *
         * This method returns nothing.
         */

        public void setConcentration (PilotConcentration pilotConcentration) {
            concentration = pilotConcentration;
        }


        /**
         * Name: getResults
         * @return LinkedList
         *
         * It returns the list of the results of the pilot.
         */

        public LinkedList <Results> getResults () {
            return results;
        }


        /**
         * Name: setResults
         * @param pilotResults is the new list of results.
         * It sets the given list of results to the track.
         *
         * This method returns nothing.
         */

        public void setResults (LinkedList <Results> pilotResults) {
            results = pilotResults;
        }


        /**
         * Name: isDisqualified
         * @return boolean
         *
         * It returns whether the pilot is disqualified or not.
         */

        public boolean isDisqualified () {
            return disqualified;
        }


        /**
         * Name: setDisqualified
         * @param pilotDisqualified is the disqualified status.
         * It sets the status of disqualification to the pilot.
         *
         * This method returns nothing.
         */

        public void setDisqualified (boolean pilotDisqualified) {
            disqualified = pilotDisqualified;
        }


        /**
         * Name: getLeavesNumber
         * @return int
         *
         * It returns the number of leaves of the pilot.
         */

        public int getLeavesNumber () {
            return leavesNumber;
        }


        /**
         * Name: setLeavesNumber
         * @param newLeavesNumber is the new number of leaves.
         * It sets the given number of leaves to the pilot.
         *
         * This method returns nothing.
         */

        public void setLeavesNumber (int newLeavesNumber) {
            leavesNumber = newLeavesNumber;
        }


        /**
         * Name: getFinishedRacesNumber
         * @return int
         *
         * It returns the number of finished races of the pilot.
         */

        public int getFinishedRacesNumber () {
            return finishedRacesNumber;
        }


        /**
         * Name: setFinishedRacesNumber
         * @param newFinishedRacesNumber is the new value of finished races.
         * It sets the given number of finished races to the pilot.
         *
         * This method returns nothing.
         */

        public void setFinishedRacesNumber (int newFinishedRacesNumber) {
            finishedRacesNumber = newFinishedRacesNumber;
        }


        /**
         * Name: addResult
         * @param result is the new results
         * It adds a new results object to the pilot's list of results.
         *
         * This method returns nothing.
         */

        public void addResult (Results result) {
            results.add (result);
        }


        /**
         * Name: getPoints
         * @return int
         *
         * It returns the the total points of the pilot.
         */

        public int getPoints () {
            int points = 0;
            for(Results result : results){
                points += result.getPoints ();
            }
            return points;
        }


        /**
         * Name: calculateSkill
         * @return Double
         *
         * This is a method that will be overriden in the subclasses, used to calculate the skill of a pilot.
         */

        public abstract double calculateSkill ();


        /**
         * Name: drive
         * @param track is the track where the pilot drives.
         * It makes a pilot drive a car in a track.
         *
         * This method returns nothing.
         */

        public void drive (Trackable track) {
            double concentration = getConcentration ().getConcentrationValue ();
            double time = getCar ().calculateTime (track, this);
            double fuel = getCar ().calculateRemainingFuel (track, this, time);
            Results result0 = new Results (-1.0,null);

            if ((concentration > time) && (getCar ().getCurrentFuel () > time)) {
                result0.setTime (time);
                result0.setTrack (track);
                result0.setPoints (-1);
                getCar ().setCurrentFuel (fuel);
                setFinishedRacesNumber (finishedRacesNumber + 1);
                addResult (result0);
                System.out.println ("+++ " + getName () + " finishes the race in " + time + " minutes +++");
            }
            else {
                if ((concentration < time) || (getCar ().getCurrentFuel () < time)) {
                    if (concentration < getCar ().getCurrentFuel ()) {
                        result0.setTime (Math.round ((concentration - time) * 100d) / 100d);
                        result0.setTrack (track);
                        getCar ().setCurrentFuel (getCar ().getCurrentFuel () - concentration);
                        addResult (result0);
                        System.out.println ("¡¡¡ " + getName () + " has lost their concentration when they only needed " +
                                Math.round ((time - concentration) * 100d) / 100d + " more minutes to finish !!!");
                        System.out.println ("¡¡¡ They had been racing for " + concentration + " minutes when they lost their concentration !!!");
                        setLeavesNumber (leavesNumber + 1);
                    }
                    else {
                        result0.setTime (fuel);
                        setLeavesNumber (leavesNumber + 1);
                        result0.setTrack (track);
                        this.addResult (result0);
                        System.out.println ("¡¡¡ The " + getCar ().getCarName () + " has run out of fuel when there were only " + Math.round ((0 - fuel) * 100d) / 100d + " left to finish !!!");
                        System.out.println ("¡¡¡ When it ran out of fuel, it had been racing for " + getCar ().getCurrentFuel () + " minutes !!!");
                        getCar().setCurrentFuel (fuel);
                    }
                }
            }
            System.out.println ("+++ The remaining fuel in the " + getCar ().getCarName () + " after the race is " + Math.round ((getCar ().getCurrentFuel ()) * 100d) / 100d + " +++");
            System.out.println ("@@@");
        }


        /**
         * Name: toString
         * @return String
         *
         * It returns a String representation of the information stored in the pilot.
         */

        @Override
        public String toString (){
            return "<pilot: " + getName () + ">";
        }


        /**
         * Name: getResult
         * @return Results
         *
         * It returns the result of a pilot in a given track.
         */

        public Results getResult (String name) {
            boolean enc = false;
            Results r = null;
            for(int i = 0; i < (results.size ()) && (!enc); i++){
                r = results.get (i);
                if (name == r.getTrack ().getTrackName ())
                    enc = true;
            }
            return r;
        }
    }
