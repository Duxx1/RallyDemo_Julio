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
    private Car car;
    protected Concentration concentration; //the enum type
    private List<Results> results;
    private boolean disqualified;
    private double currentConcentration;
    private int leavesNumber;   //es el numero de abandonos
    private int finishedRacesNumber;    //numero de carreras terminadas

    public Pilot(String name, Car car, Concentration concentration, boolean disqualified){
        this.name=name;
        this.car=car;
        this.concentration=concentration;
        this.disqualified=false;
        this.results=new ArrayList<Results>();
        this.currentConcentration=this.getConcentrationValue();
        this.leavesNumber=0;
        this.finishedRacesNumber=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Concentration getConcentration() {
        return concentration;
    }

    //probando github

    public String getConcentrationName(){
        return concentration.getConcentrationName();
    }

    public double getConcentrationValue(){
        return concentration.getConcentrationValue();
    }

    public void setConcentration(Concentration concentration) {
        this.concentration = concentration;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    //this method checks wheter the pilot is disqualified or not
    public boolean getDisqualifiedStatus(int maxLeaves){
        if(leavesNumber >= maxLeaves){
            setDisqualified(true);
            return true;
        }
        return false;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public double getCurrentConcentration() {
        return currentConcentration;
    }

    public void setCurrentConcentration(double currentConcentration) {
        this.currentConcentration = currentConcentration;
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
    public double getPoints(){
        double points=0;
        for(Results result : results){
            points += result.getPoints();
        }
        return points;
    }

    //abstract method that will be overriden
    public abstract Double calculateSkill();

    //a method for the pilot to drive a car in a concrete track
    public void drive(Track track){
        if(car.getCurrentFuel() < 0){
            Results result0=new Results(0.0,0.0,null);
            result0.setTrack(track);
            result0.setTime(-1.0);
            result0.setPoints(0.0);
            this.addResult(result0);
        }
        else{
            //aqui necesitamos el metodo para calcular el combustible restante del coche
            //aqui necesitamos el metodo para calcular la concentracion restante del piloto
            //aqui necesitamos el metodo para calcular el timepo en carrera del coche
            if(concentracionRestante < 0 || combustibleRestante < 0){//calculada en linea 130 || calculada en linea 129
                setLeavesNumber(this.leavesNumber+1);
                if(combustibleRestante <= concentracionRestante){//si se le acaba el combustible
                    Results result1=new Results(0.0,0.0,null);
                    result1.setTrack(track);
                    double time1=car.calcularTiempoNecesario(this, circuito);//necesitamos ese metodo
                    result1.setTime(time1);
                    result1.setTrack(track);
                    double finalFuel;//el que queda al conducir lo que se pueda
                    finalFuel=car.finalFuel(this,track);//necesitamos ese metodo
                    car.setCurrentFuel(finalFuel);
                    results.add(result1);
                }
                else{
                    Results result2=new Results(0.0,0.0,null);
                    double minutesNeeded=getConcentrationValue()-timepoEnCarrera;//el de linea 131
                    double timeRaced=timepoEnCarrera + minutesNeeded;
                    double restedFuel=car.getCurrentFuel()-timeRaced;   //el combustible restado ya
                    car.setCurrentFuel(restedFuel);
                    result2.setTrack(track);
                    result2.setTime(minutesNeeded);
                    this.addResult(result2);
                }
            }
            else{
                Results resultFinished=new Results();
                resultFinished.setTrack(track);
                resultFinished.setTime(car.tiempoNecesario(this,track));//necesitamos el metodo
                this.addResult(resultFinished);
                setFinishedRacesNumber(this.finishedRacesNumber+1);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return disqualified == pilot.disqualified && Double.compare(pilot.currentConcentration, currentConcentration) == 0 && leavesNumber == pilot.leavesNumber && finishedRacesNumber == pilot.finishedRacesNumber && name.equals(pilot.name) && car.equals(pilot.car) && concentration == pilot.concentration && results.equals(pilot.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, car, concentration, results, disqualified, currentConcentration, leavesNumber, finishedRacesNumber);
    }

    @Override
    public String toString(){
        return "<pilot: " + getName() + ">";
    }

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
