/**
 * Name: TrackDecorator
 * Helps wrap a regular Track with extra features.
 *
 * @version 1.0 (12/23/2020) 29/01/21
 * @author Raúl && Eduardo
 */

public abstract class ExtraComplications implements Trackable{
    protected Trackable decoratedTrack = null;

    /**
     * Name: TrackDecorator
     *
     * @param track: Trackable
     *
     * Initialises the attributes from the class given certain values.
     * The parameter "track" corresponds to the track that will be decorated.
     *
     * This method returns nothing since it is the class constructor.
     */

    public ExtraComplications (Trackable track) {
        decoratedTrack = track;
    }


    /**
     * Name: getTrackName
     * @return String
     *
     * Returns the name of the track.
     */

    @Override
    public String getTrackName () {
        return decoratedTrack.getTrackName();
    }


    /**
     * Name: getTrackComplexity
     * @return TrackComplexity
     *
     * Returns the complexity of the track.
     */

    @Override
    public TrackComplexity getTrackComplexity () {
        return decoratedTrack.getTrackComplexity ();
    }


    /**
     * Name: getTrackDistance
     * @return TrackDistance
     *
     * Returns the distance of the track.
     */

    @Override
    public TrackDistance getTrackDistance () {
        return decoratedTrack.getTrackDistance ();
    }


    /**
     * Name: calculateComplexity
     * @return double
     * Returns the complexity value.
     */

    @Override
    public double calculateComplexity () {
        return decoratedTrack.calculateComplexity ();
    }


    /**
     * Name: calculateDistance
     * @return double
     * Returns the distance value.
     */

    @Override
    public double calculateDistance () {
        return decoratedTrack.calculateDistance ();
    }


    /**
     * Name: conditionString
     * @return String
     * Returns a String indicating the applied conditions.
     */

    @Override
    public String conditionString () {
        return decoratedTrack.conditionString ();
    }


    /**
     * Name: toString
     * @return String
     *
     * Returns a String representation of the information stored in the track.
     */

    @Override
    public String toString () {
        return decoratedTrack.toString();
    }
}
