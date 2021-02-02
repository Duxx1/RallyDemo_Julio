import java.util.*;
/**
 * Name: CarCurrentFuelComparator
 * This class is used to compare cars according to the current fuel.
 * If the current fuel of both cars is the same, it uses the name to order them.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class CarCurrentFuelComparator implements Comparator<Carable>{
    @Override
    public int compare(Carable c1, Carable c2){
        if(c1.getCurrentFuel() == c2.getCurrentFuel())
            return (c1.getCarName().compareTo(c2.getCarName()));
        else if(c1.getCurrentFuel() > c2.getCurrentFuel())
            return 1;
        else
            return -1;
    }
}
