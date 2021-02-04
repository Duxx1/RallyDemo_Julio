import java.util.Comparator;

/**
 * Name: TrackComplexityComparator
 * This class is a comparator for the tracks based on their complexity values.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class TrackComplexityComparator implements Comparator <Trackable> {

    /**
     * Name: compare
     * @return int
     * @param t1 is the first track to be compared.
     * @param t2 is the second track to be compared.
     *
     * Compares two tracks based on their complexity values.
     *
     * The returned value is a integer (-1 or 1) depending if the first track's complexity value is greater or
     *           lesser than the second's respectively.
     *
     */

    @Override
    public int compare (Trackable t1, Trackable t2) {
        if (t1.calculateComplexity () < t2.calculateComplexity ()) {
            return -1;
        }
        else {
            if (t1.calculateComplexity () > t2.calculateComplexity ()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
