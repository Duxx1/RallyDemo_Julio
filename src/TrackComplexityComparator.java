import java.util.Comparator;

public class TrackComplexityComparator implements Comparator <Trackable> {

    @Override
    public int compare (Trackable t1, Trackable t2) {
        if (t1.getTrackComplexity ().getComplexityValue () < t2.getTrackComplexity ().getComplexityValue ()) {
            return -1;
        }
        else {
            if (t1.getTrackComplexity ().getComplexityValue () > t2.getTrackComplexity ().getComplexityValue ()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
