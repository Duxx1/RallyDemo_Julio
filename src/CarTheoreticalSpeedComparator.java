import java.util.*;
/**
 * Name: CarTheoreticalSpeedComparator
 * This class is used to compare two interfaces Carable according to their theorical speed.
 *
 * @version     1.0
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class CarTheoreticalSpeedComparator implements Comparator<Carable>{
    @Override
    public int compare(Carable c1, Carable c2){
        if(c1.getCarSpeed().getValue() < c2.getCarSpeed().getValue())
            return -1;
        else if(c1.getCarSpeed().getValue() > c2.getCarSpeed().getValue())
            return 1;
        else
            return 0;
    }
}
