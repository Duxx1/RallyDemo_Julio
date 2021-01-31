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
        private List<Results> results;
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

        public List<Results> getResults() {
            return results;
        }

        public void setResults(List<Results> results) {
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

        //a method for the pilot to drive a car in a concrete track
    //    public void drive(Trackable track){
    //        if(car.getCurrentFuel() < 0){
    //            Results result0=new Results(0.0,0.0,null);
    //            result0.setTrack(track);
    //            result0.setTime(-1.0);
    //            result0.setPoints(0.0);
    //            this.addResult(result0);
    //        }
    //        else{
    //            //aqui necesitamos el metodo para calcular el combustible restante del coche
    //            //aqui necesitamos el metodo para calcular la concentracion restante del piloto
    //            //aqui necesitamos el metodo para calcular el timepo en carrera del coche
    //            if(concentracionRestante < 0 || combustibleRestante < 0){//calculada en linea 130 || calculada en linea 129
    //                setLeavesNumber(this.leavesNumber+1);
    //                if(combustibleRestante <= concentracionRestante){//si se le acaba el combustible
    //                    Results result1=new Results(0.0,0.0,null);
    //                    result1.setTrack(track);
    //                    double time1=car.calcularTiempoNecesario(this, circuito);//necesitamos ese metodo
    //                    result1.setTime(time1);
    //                    result1.setTrack(track);
    //                    double finalFuel;//el que queda al conducir lo que se pueda
    //                    finalFuel=car.finalFuel(this,track);//necesitamos ese metodo
    //                    car.setCurrentFuel(finalFuel);
    //                    results.add(result1);
    //                }
    //                else{
    //                    Results result2=new Results(0.0,0.0,null);
    //                    double minutesNeeded=getConcentrationValue()-timepoEnCarrera;//el de linea 131
    //                    double timeRaced=timepoEnCarrera + minutesNeeded;
    //                    double restedFuel=car.getCurrentFuel()-timeRaced;   //el combustible restado ya
    //                    car.setCurrentFuel(restedFuel);
    //                    result2.setTrack(track);
    //                    result2.setTime(minutesNeeded);
    //                    this.addResult(result2);
    //                }
    //            }
    //            else{
    //                Results resultFinished=new Results();
    //                resultFinished.setTrack(track);
    //                resultFinished.setTime(car.tiempoNecesario(this,track));//necesitamos el metodo
    //                this.addResult(resultFinished);
    //                setFinishedRacesNumber(this.finishedRacesNumber+1);
    //            }
    //        }
    //    }

        //    public void drive(Trackable track){
    //        if(car.getCurrentFuel() < 0){
    //            Results result0=new Results(0.0,0.0,null);
    //            result0.setTrack(track);
    //            result0.setTime(-1.0);
    //            result0.setPoints(0.0);
    //            this.addResult(result0);
    //        }
    //        else{
    //            //aqui necesitamos el metodo para calcular el combustible restante del coche
    //            //aqui necesitamos el metodo para calcular la concentracion restante del piloto
    //            //aqui necesitamos el metodo para calcular el timepo en carrera del coche
    //            if(concentracionRestante < 0 || combustibleRestante < 0){//calculada en linea 130 || calculada en linea 129
    //                setLeavesNumber(this.leavesNumber+1);
    //                if(combustibleRestante <= concentracionRestante){//si se le acaba el combustible
    //                    Results result1=new Results(0.0,0.0,null);
    //                    result1.setTrack(track);
    //                    double time1=car.calcularTiempoNecesario(this, circuito);//necesitamos ese metodo
    //                    result1.setTime(time1);
    //                    result1.setTrack(track);
    //                    double finalFuel;//el que queda al conducir lo que se pueda
    //                    finalFuel=car.finalFuel(this,track);//necesitamos ese metodo
    //                    car.setCurrentFuel(finalFuel);
    //                    results.add(result1);
    //                }
    //                else{
    //                    Results result2=new Results(0.0,0.0,null);
    //                    double minutesNeeded=getConcentrationValue()-timepoEnCarrera;//el de linea 131
    //                    double timeRaced=timepoEnCarrera + minutesNeeded;
    //                    double restedFuel=car.getCurrentFuel()-timeRaced;   //el combustible restado ya
    //                    car.setCurrentFuel(restedFuel);
    //                    result2.setTrack(track);
    //                    result2.setTime(minutesNeeded);
    //                    this.addResult(result2);
    //                }
    //            }
    //            else{
    //                Results resultFinished=new Results();
    //                resultFinished.setTrack(track);
    //                resultFinished.setTime(car.tiempoNecesario(this,track));//necesitamos el metodo
    //                this.addResult(resultFinished);
    //                setFinishedRacesNumber(this.finishedRacesNumber+1);
    //            }
    //        }
    //    }

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
                            result0.setTime(concentration-time);
                            result0.setTrack(track);
                            getCar().setCurrentFuel(getCar().getCurrentFuel() - concentration);
                            this.addResult(result0);
                            System.out.println("¡¡¡ " + getName() + " has lost their concentration when they only needed " +
                                    Math.round ((time - concentration) * 100d) / 100d + " more minutes to finish !!!");
                            System.out.println("¡¡¡ They had been racing for " + concentration + " minutes !!!");
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
