import java.util.Comparator;

public class TrackDistanceComparator implements Comparator <Trackable> {

    @Override
    public int compare (Trackable t1, Trackable t2) {
        if (t1.getTrackDistance ().getDistanceValue() < t2.getTrackDistance ().getDistanceValue ()) {
            return -1;
        }
        else {
            if (t1.getTrackDistance ().getDistanceValue () > t2.getTrackDistance ().getDistanceValue ()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
