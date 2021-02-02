import java.util.*;

/**
 * Name: PilotFinishedRacesComparator
 * This class is a comparator for the pilots based on their number of finished races. In case they draw, their names are compared afterwards.
 *
 * @version 1.0 ()
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 *
 */

public class PilotFinishedRacesComparator implements Comparator <Pilot> {

    /**
     * Name: compare
     * @return int
     * @param p1 is the first pilot to be compared.
     * @param p2 is the second pilot to be compared.
     *
     * Compares two pilots based on their number of finished races. In case they draw, their names are compared afterwards.
     *
     * The returned value is a integer (-1 or 1) depending if the first pilot's number of finished races is greater or lesser than the second's respectively.
     * In case they draw, their names are compared afterwards.
     */

    @Override
    public int compare (Pilot p1, Pilot p2) {
        if (p1.getFinishedRacesNumber () == p2.getFinishedRacesNumber ())
            return (p1.getName ().compareTo (p2.getName ()));
        else if (p1.getFinishedRacesNumber () > p2.getFinishedRacesNumber ())
            return 1;
        else
            return -1;
    }
}
