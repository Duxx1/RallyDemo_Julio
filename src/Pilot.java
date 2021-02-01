    /**
     * Name: Pilot
     * This class represents all the info a Pilot must have
     *
     * @version 1.0 (12/24/2020) 29/01/21
     * @author Raúl && Eduardo
     */
    import java.util.*;

    public abstract class Pilot {
        private String name;
        private Carable car;
        protected PilotConcentration concentration; //the enum type
        private LinkedList<Results> results; //Preguntar en tutoría si el tipo estático puede ser LinkedList, ya que si no lo usamos (solo el dinámico es LinkedList)
                                             // no nos deja acceder al getLast de las LinkedList (usado en PilotLastTimeComparator, y en la asignación de puntos despúes de una carrera, reduciendo el orden de complejidad)
        private boolean disqualified;
        private int leavesNumber;   //es el numero de abandonos
        private int finishedRacesNumber;    //numero de carreras terminadas

        public Pilot(String name, PilotConcentration concentration){
            this.name=name;
            this.concentration=concentration;
            this.disqualified=false;
            setCar(null);
            this.results=new LinkedList<Results>();
            this.leavesNumber=0;
            this.finishedRacesNumber=0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Carable getCar() {
            return car;
        }

        public void setCar (Carable car) {
            this.car = car;
        }

        public PilotConcentration getConcentration() {
            return concentration;
        }

        //probando github

        public String getConcentrationName(){
            return concentration.getConcentrationName();
        }

        public void setConcentration(PilotConcentration concentration) {
            this.concentration = concentration;
        }

        public LinkedList<Results> getResults() {
            return results;
        }

        public void setResults(LinkedList<Results> results) {
            this.results = results;
        }

        public boolean isDisqualified() {
            return disqualified;
        }

        public void setDisqualified(boolean disqualified) {
            this.disqualified = disqualified;
        }

        public int getLeavesNumber() {
            return leavesNumber;
        }

        public void setLeavesNumber(int leavesNumber) {
            this.leavesNumber = leavesNumber;
        }

        public int getFinishedRacesNumber() {
            return finishedRacesNumber;
        }

        public void setFinishedRacesNumber(int finishedRacesNumber) {
            this.finishedRacesNumber = finishedRacesNumber;
        }

        public void addResult(Results result){
            this.results.add(result);
        }

        //this method returns the total points of the pilot
        public int getPoints () {
            int points = 0;
            for(Results result : results){
                points += result.getPoints ();
            }
            return points;
        }

        //abstract method that will be overriden
        public abstract Double calculateSkill();


            public void drive(Trackable track){
                double concentration = getConcentration().getConcentrationValue ();
                double time = getCar ().calculateTime(track, this);
                double fuel = getCar ().calculateRemainingFuel(track, this, time);
                Results result0=new Results(-1.0,null);
                if ((concentration > time) && (fuel > 0)) {
                    result0.setTime(time);
                    result0.setTrack(track);
                    result0.setPoints(-1);
                    getCar().setCurrentFuel (fuel);
                    setFinishedRacesNumber(finishedRacesNumber+1);
                    this.addResult(result0);
                    System.out.println ("+++ " + getName() + " finishes the race in " + time + " minutes +++");
                }
                else {
                    if (fuel < 0) {
                        result0.setTime(fuel);//combustible negativo que hubiese necesitado
                        getCar().setCurrentFuel(fuel);
                        setLeavesNumber(leavesNumber+1);
                        result0.setTrack(track);
                        this.addResult(result0);
                        System.out.println ("¡¡¡ The " + getCar ().getCarName () + " has run out of fuel when there were only " + Math.round ((0 - fuel) * 100d) / 100d + " left to finish !!!");
                        System.out.println ("¡¡¡ It had been racing for " + getCar ().getCurrentFuel () + " minutes !!!");
                    }
                    else {
                        if (concentration < time) {
                            result0.setTime(Math.round((concentration-time)*100d)/100d);
                            result0.setTrack(track);
                            getCar().setCurrentFuel(getCar().getCurrentFuel() - concentration);
                            this.addResult(result0);
                            System.out.println("¡¡¡ " + getName() + " has lost their concentration when they only needed " +
                                    Math.round ((time - concentration) * 100d) / 100d + " more minutes to finish !!!");
                            System.out.println("¡¡¡ They had been racing for " + concentration + " minutes !!!");
                            setLeavesNumber(leavesNumber+1);
                        }
                    }
                }
                System.out.println ("+++ The remaining fuel in the " + getCar ().getCarName () + " after the race is " + Math.round ((getCar ().getCurrentFuel ()) * 100d) / 100d + " +++");
            }

        @Override
        public String toString(){
            return "<pilot: " + getName() + ">";
        }

        //le pasas un circuito y te devuelve el resultado
        //returns the track result with the name
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
