import java.util.Comparator;

/**
 * Name: CarCurrentFuelComparator
 * This class is used to compare cars according to their current fuel.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public class CarCurrentFuelComparator implements Comparator <Carable> {

    /**
     * Name: compare
     * @return int
     * @param c1 is the first car to be compared.
     * @param c2 is the second car to be compared.
     *
     * Compares two cars based on their current fuel values.
     *
     */

    @Override
    public int compare (Carable c1, Carable c2) {
        if(c1.getCurrentFuel() == c2.getCurrentFuel())
            return (c1.getCarName().compareTo(c2.getCarName()));
        else if(c1.getCurrentFuel() > c2.getCurrentFuel())
            return 1;
        else
            return -1;
    }
}
