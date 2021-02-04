import java.util.Comparator;

/**
 * Name: TrackDistanceComparator
 * This class is a comparator for the tracks based on their distance values.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class TrackDistanceComparator implements Comparator <Trackable> {

    /**
     * Name: compare
     * @return int
     * @param t1 is the first track to be compared.
     * @param t2 is the second track to be compared.
     *
     * Compares two tracks based on their distance values.
     *
     * The returned value is a integer (-1 or 1) depending if the first track's distance value is greater or
     *           lesser than the second's respectively.
     *
     */

    @Override
    public int compare (Trackable t1, Trackable t2) {
        if (t1.calculateDistance () < t2.calculateDistance ()) {
            return -1;
        }
        else {
            if (t1.calculateDistance () > t2.calculateDistance ()) {
                return 1;
            }
            else {
                return t1.getTrackName ().compareTo(t2.getTrackName ());
            }
        }
    }
}
