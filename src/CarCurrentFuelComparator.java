import java.util.*;

public class CarCurrentFuelComparator implements Comparator<Carable>{
    @Override
    public int compare(Carable c1, Carable c2){
        if(c1.getCurrentFuel() < c2.getCurrentFuel())
            return -1;
        else if(c1.getCurrentFuel() > c2.getCurrentFuel())
            return 1;
        else
            return 0;
    }
}
