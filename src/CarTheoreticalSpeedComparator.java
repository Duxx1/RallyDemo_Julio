import java.util.Comparator;

/**
 * Name: CarTheoreticalSpeedComparator
 * This class is used to compare cars according to their theoretical speed.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class CarTheoreticalSpeedComparator implements Comparator <Carable> {

    /**
     * Name: compare
     * @return int
     * @param c1 is the first car to be compared.
     * @param c2 is the second car to be compared.
     *
     * It compares two cars based on their speed values.
     *
     * The returned value are 1, -1 or 0 according to their theoretical speed values.
     */

    @Override
    public int compare (Carable c1, Carable c2) {
        if(c1.getCarSpeed().getValue () < c2.getCarSpeed().getValue ()) {
            return -1;
        }
        else {
            if (c1.getCarSpeed ().getValue () > c2.getCarSpeed ().getValue ()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
