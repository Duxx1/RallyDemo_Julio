import java.util.*;
/**
 * Name: PilotConcentrationComparator
 * This class is used to compare pilots according to their concentration.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class PilotConcentrationComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if(p1.getConcentration().getConcentrationValue() < p2.getConcentration().getConcentrationValue())
            return -1;
        else if(p1.getConcentration().getConcentrationValue() > p2.getConcentration().getConcentrationValue())
            return 1;
        else
            return 0;
    }
}
