import java.util.*;

/**
 * Name: PilotLastTimeComparator
 * This class is a comparator for the pilots based on their time obtained after a race.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class PilotLastTimeComparator implements Comparator<Pilot>{

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * Compares two pilots based on their time obtained after a race.
     *
     * The returned value is a integer (-1, 0 or 1) depending if the first pilot's number of finished races is greater, equal or lesser than the second's respectively.
     */

    @Override
    public int compare (Pilot p1, Pilot p2) {
        if ((p1.getResults ().get (p1.getResults ().size () - 1).getTime ()) > (p2.getResults ().get(p2.getResults ().size ()-1).getTime ()))
            return 1;
        else if ((p1.getResults ().get (p1.getResults ().size () - 1).getTime ()) < (p2.getResults ().get(p2.getResults ().size ()-1).getTime ()))
            return -1;
        else
            return 0;
    }
}
