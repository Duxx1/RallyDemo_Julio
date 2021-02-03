import java.util.*;
    /**
     * Name: Pilot
     * This class represents all the info a Pilot must have
     *
     * @version 1.0 (12/24/2020) 29/01/21
     * @author Raul Hormigo Ceron and Eduardo Cano Garcia
     */
    public abstract class Pilot {
        private String name;
        private Carable car;
        protected PilotConcentration concentration; //the enum type
        private LinkedList<Results> results; //Preguntar en tutoría si el tipo estático puede ser LinkedList, ya que si no lo usamos (solo el dinámico es LinkedList)
                                             // no nos deja acceder al getLast de las LinkedList (usado en PilotLastTimeComparator, y en la asignación de puntos despúes de una carrera, reduciendo el orden de complejidad)
        private boolean disqualified;
        private int leavesNumber;   //es el numero de abandonos
        private int finishedRacesNumber;    //numero de carreras terminadas

        /**
         * Name: Pilot
         *
         * @param name: String
         * @param concentration: PilotConcentration
         *
         * Initialises the attributes from the class given certain values.
         * The parameter "name" corresponds to the name of the pilot.
         * The parameter "concentration" corresponds to the concentration of the pilot.
         *
         * This method returns nothing since it is the class constructor.
         */
        public Pilot(String name, PilotConcentration concentration){
            this.name=name;
            this.concentration=concentration;
            this.disqualified=false;
            setCar(null);
            this.results=new LinkedList<Results>();
            this.leavesNumber=0;
            this.finishedRacesNumber=0;
        }

        /**
         * Name: getName
         * @return String
         *
         * Returns the name of the pilot.
         */
        public String getName() {
            return name;
        }

        /**
         * Name: setName
         * @param name: String
         * Sets the given name to the pilot.
         * The parameter "name" corresponds to the name of the pilot.
         * This method returns nothing.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Name: getCar
         * @return Carable
         *
         * Returns the car of the pilot.
         */
        public Carable getCar() {
            return car;
        }

        /**
         * Name: setCar
         * @param car: Carable
         * Sets the given car to the pilot.
         * The parameter "car" corresponds to the car of the pilot.
         * This method returns nothing.
         */
        public void setCar (Carable car) {
            this.car = car;
        }

        /**
         * Name: getConcentration
         * @return PilotConcentration
         *
         * Returns the concentration of the pilot.
         */
        public PilotConcentration getConcentration() {
            return concentration;
        }

        /**
         * Name: getConcentrationName
         * @return String
         *
         * Returns the pilot concentration name.
         */
        public String getConcentrationName(){
            return concentration.getConcentrationName();
        }

        /**
         * Name: setConcentration
         * @param concentration: PilotConcentration
         * Sets the given concentration to the pilot.
         * The parameter "concentration" corresponds to the concentration of the pilot.
         * This method returns nothing.
         */
        public void setConcentration(PilotConcentration concentration) {
            this.concentration = concentration;
        }

        /**
         * Name: getResults
         * @return LinkedList
         *
         * Returns the list of the results of the pilot.
         */
        public LinkedList<Results> getResults() {
            return results;
        }

        /**
         * Name: setResults
         * @param results: LinkedList
         * Sets the given list of results to the track.
         * The parameter "results" corresponds to the list of results of the pilot.
         * This method returns nothing.
         */
        public void setResults(LinkedList<Results> results) {
            this.results = results;
        }

        /**
         * Name: isDisqualified
         * @return boolean
         *
         * Returns if the pilot is disqualified or not.
         */
        public boolean isDisqualified() {
            return disqualified;
        }

        /**
         * Name: setDisqualified
         * @param disqualified: boolean
         * Sets the status of disqualification to the pilot.
         * The parameter "disqualified" corresponds to the status of the disqualification of the pilot.
         * This method returns nothing.
         */
        public void setDisqualified(boolean disqualified) {
            this.disqualified = disqualified;
        }

        /**
         * Name: getLeavesNumber
         * @return int
         *
         * Returns the number of lefts of the pilot.
         */
        public int getLeavesNumber() {
            return leavesNumber;
        }

        /**
         * Name: setLeavesNumber
         * @param leavesNumber: int
         * Sets the given number of leaves to the pilot.
         * The parameter "leavesNumber" corresponds to the number of leaves of the pilot.
         * This method returns nothing.
         */
        public void setLeavesNumber(int leavesNumber) {
            this.leavesNumber = leavesNumber;
        }

        /**
         * Name: getFinishedRacesNumber
         * @return int
         *
         * Returns the number of finished races of the pilot.
         */
        public int getFinishedRacesNumber() {
            return finishedRacesNumber;
        }

        /**
         * Name: setFinishedRacesNumber
         * @param finishedRacesNumber: int
         * Sets the given number of finished races to the pilot.
         * The parameter "finishedRacesNumber" corresponds to the number of finished races of the pilot.
         * This method returns nothing.
         */
        public void setFinishedRacesNumber(int finishedRacesNumber) {
            this.finishedRacesNumber = finishedRacesNumber;
        }

        /**
         * Name: addResult
         * @param result: Results
         * Sets the given results to the pilot.
         * The parameter "result" corresponds to the result of the pilot.
         * This method returns nothing.
         */
        public void addResult(Results result){
            this.results.add(result);
        }

        /**
         * Name: getPoints
         * @return int
         *
         * Returns the the total points of the pilot.
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
        public abstract double calculateSkill();

        /**
         * Name: drive
         * @param track: Trackable
         * Makes a pilot drive a car in a circuit.
         * This method returns nothing.
         */
        public void drive(Trackable track){
            double concentration = getConcentration().getConcentrationValue ();
            double time = getCar ().calculateTime (track, this);
            double fuel = getCar ().calculateRemainingFuel (track, this, time);
            Results result0=new Results(-1.0,null);

            if ((concentration > time) && (getCar ().getCurrentFuel () > time)) {
                result0.setTime (time);
                result0.setTrack (track);
                result0.setPoints (-1);
                getCar().setCurrentFuel (fuel);
                setFinishedRacesNumber(finishedRacesNumber + 1);
                this.addResult(result0);
                System.out.println ("+++ " + getName() + " finishes the race in " + time + " minutes +++");
            }
            else {
                if ((concentration < time) || (getCar ().getCurrentFuel () < time)) {
                    if (concentration < getCar ().getCurrentFuel ()) {
                        result0.setTime(Math.round((concentration-time)*100d)/100d);
                        result0.setTrack(track);
                        getCar().setCurrentFuel(getCar().getCurrentFuel() - concentration);
                        this.addResult(result0);
                        System.out.println("¡¡¡ " + getName() + " has lost their concentration when they only needed " +
                                Math.round ((time - concentration) * 100d) / 100d + " more minutes to finish !!!");
                        System.out.println("¡¡¡ They had been racing for " + concentration + " minutes !!!");
                        setLeavesNumber(leavesNumber+1);
                    }
                    else {
                        result0.setTime (fuel);
                        getCar().setCurrentFuel (fuel);
                        setLeavesNumber (leavesNumber + 1);
                        result0.setTrack(track);
                        this.addResult(result0);
                        System.out.println ("¡¡¡ The " + getCar ().getCarName () + " has run out of fuel when there were only " + Math.round ((0 - fuel) * 100d) / 100d + " left to finish !!!");
                        System.out.println ("¡¡¡ It had been racing for " + getCar ().getCurrentFuel () + " minutes !!!");
                    }
                }
            }
            System.out.println ("+++ The remaining fuel in the " + getCar ().getCarName () + " after the race is " + Math.round ((getCar ().getCurrentFuel ()) * 100d) / 100d + " +++");
            System.out.println("@@@");
        }

        /**
         * Name: toString
         * @return String
         *
         * Returns a String representation of the information stored in the pilot.
         */
        @Override
        public String toString(){
            return "<pilot: " + getName() + ">";
        }

        //le pasas un circuito y te devuelve el resultado
        //returns the track result with the name
        /**
         * Name: getResult
         * @return Results
         * Returns the result of a pilot in a given track.
         */
        public Results getResult(String name){
            boolean enc=false;
            Results r = null;
            for(int i=0; i<results.size() && !enc; i++){
                r=results.get(i);
                if(name==r.getTrack().getTrackName())
                    enc=true;
            }
            return r;
        }
    }
