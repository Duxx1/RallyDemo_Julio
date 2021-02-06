import java.util.*;
public class DisqualifiedPilotsComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if(p1.getPoints() == p2.getPoints())
            return (p1.getName().compareTo(p2.getName()));
        else if(p1.getPoints() < p2.getPoints())
            return -1;
        else
            return 1;
    }
}
