import java.util.*;

/**
 * Name: PilotRaceComparator
 * This class is a comparator for the pilots based on their points obtained after a race. If they draw, their number of finished races are compared afterwards.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class PilotRaceComparator implements Comparator <Pilot> {

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * Compares two pilots based on their points obtained after a race. If they draw, their number of finished races are compared afterwards.
     *
     * The returned value is a integer (-1, or 1) depending if the first pilot's number of finished races is greater or lesser than the second's respectively.
     * If they draw, their number of finished races are compared afterwards.
     */

    @Override
    public int compare (Pilot p1, Pilot p2) {
       if (p1.getPoints () == p2.getPoints ())
           return new PilotFinishedRacesComparator ().compare (p1, p2);
       else if (p1.getPoints () > p2.getPoints ())
           return 1;
       else
           return -1;
    }
}
