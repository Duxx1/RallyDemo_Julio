import java.util.Comparator;

/**
 * Name: DisqualifiedPilotsComparator
 * This class is used to compare pilots according to their points. In case they draw, it compares them based on their names.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class DisqualifiedPilotsComparator implements Comparator <Pilot> {

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * It compares two pilots based on their points. In case they draw, it compares them according to their name.
     *
     * The returned value are 1, -1 or sorted by their names according to their points.
     */

    @Override
    public int compare (Pilot p1, Pilot p2) {
        if (p1.getPoints () == p2.getPoints ()) {
            return (p1.getName ().compareTo (p2.getName ()));
        }
        else {
            if (p1.getPoints () < p2.getPoints ()) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
