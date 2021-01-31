import java.util.*;
//orders by points ASC, finished races ASC, name ASC
public class PilotRaceComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
       if(p1.getPoints() == p2.getPoints())
           return new PilotFinishedRacesComparator().compare(p1, p2);
       else if(p1.getPoints() > p2.getPoints())
           return 1;
       else
           return -1;
    }
}
