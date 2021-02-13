import java.util.*;
/**
 * Name: PilotConcentrationComparator
 * This class is used to compare pilots according to their concentration.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class PilotConcentrationComparator implements Comparator <Pilot> {

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * Compares two pilots based on their concentration.
     *
     * The returned value is a integer (-1, 0 or 1) depending if the first pilot's concentration is greater,
     *           equal or lesser than the second's respectively.
     */

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
