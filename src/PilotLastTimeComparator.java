import java.beans.XMLDecoder;
import java.util.*;
public class PilotLastTimeComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if((p1.getResults().get(p1.getResults().size()-1).getTime()) > (p2.getResults().get(p2.getResults().size()-1).getTime()))
            return 1;
        else if((p1.getResults().get(p1.getResults().size()-1).getTime()) < (p2.getResults().get(p2.getResults().size()-1).getTime()))
            return -1;
        else
            return 0;
    }
}
