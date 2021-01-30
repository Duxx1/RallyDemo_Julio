import java.util.Comparator;

public class TrackDistanceComparator implements Comparator <Trackable> {

    @Override
    public int compare (Trackable t1, Trackable t2) {
        if (t1.calculateDistance() < t2.calculateDistance()) {
            return -1;
        }
        else {
            if (t1.calculateDistance() > t2.calculateDistance()) {
                return 1;
            }
            else {
                return t1.getTrackName().compareTo(t2.getTrackName());
            }
        }
    }
}
