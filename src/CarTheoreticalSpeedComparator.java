import java.util.*;

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
