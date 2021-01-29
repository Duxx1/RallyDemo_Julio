import java.util.*;

public class PilotSkillComparator implements Comparator<Pilot>{
    @Override
    public int compare(Pilot p1, Pilot p2){
        if(p1.calculateSkill() == p2.calculateSkill())
            return (p1.getName().compareTo(p2.getName()));
        else if(p1.calculateSkill() > p2.calculateSkill())
            return 1;
        else
            return -1;
    }
}
