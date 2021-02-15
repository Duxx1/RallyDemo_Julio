import java.util.Comparator;

/**
 * Name: PilotDisqualifiedComparator
 * This class is used to compare pilots according to their disqualified status.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class PilotDisqualifiedComparator implements Comparator <Pilot> {

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * Compares two pilots based on their disqualified status.
     *
     */

    @Override
    public int compare (Pilot p1, Pilot p2) {
        boolean firstValue = p1.isDisqualified ();
        boolean secondValue = p2.isDisqualified ();
        if (firstValue != secondValue) {
            return -1;
        }
        else {
            return p1.getName ().compareTo (p2.getName ());
        }
    }
}
