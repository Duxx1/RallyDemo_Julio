import java.util.*;

public class PilotPointsComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if(p1.getPoints() == p2.getPoints())
            return new PilotFinishedRacesComparator().compare(p1,p2);
        else if(p1.getPoints() > p2.getPoints())
            return 1;
        else
            return -1;
    }
}
