import java.util.*;

public class PilotFinishedRacesComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if(p1.getFinishedRacesNumber() == p2.getFinishedRacesNumber())
            return (p1.getName().compareTo(p2.getName()));
        else if(p1.getFinishedRacesNumber() > p2.getFinishedRacesNumber())
            return 1;
        else
            return -1;
    }
}
