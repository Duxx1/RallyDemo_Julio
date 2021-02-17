/**
 * Name: TrackDecorator
 * It helps to complete the Decorator Design Pattern.
 *
 * @version     1.0 (01/29/2021)
 * @author      Raul Hormigo Ceron and Eduardo Cano Garcia
 */

public abstract class ExtraComplications implements Trackable {
    protected Trackable decoratedTrack = null;


    /**
     * Name: TrackDecorator
     * @param track is the track that will be decorated.
     *
     * Initialises the attributes from the class given certain values.
     *
     * This method returns nothing.
     */

    public ExtraComplications (Trackable track) {
        decoratedTrack = track;
    }


    /**
     * Name: getTrackName
     * @return String
     *
     * It returns the name of the track.
     */

    @Override
    public String getTrackName () {
        return decoratedTrack.getTrackName ();
    }


    /**
     * Name: getTrackComplexity
     * @return TrackComplexity
     *
     * It returns the complexity of the track.
     */

    @Override
    public TrackComplexity getTrackComplexity () {
        return decoratedTrack.getTrackComplexity ();
    }


    /**
     * Name: getTrackDistance
     * @return TrackDistance
     *
     * It returns the distance of the track.
     */

    @Override
    public TrackDistance getTrackDistance () {
        return decoratedTrack.getTrackDistance ();
    }


    /**
     * Name: calculateComplexity
     * @return double
     *
     * It returns the complexity value.
     */

    @Override
    public double calculateComplexity () {
        return decoratedTrack.calculateComplexity ();
    }


    /**
     * Name: calculateDistance
     * @return double
     *
     * It returns the distance value.
     */

    @Override
    public double calculateDistance () {
        return decoratedTrack.calculateDistance ();
    }


    /**
     * Name: conditionString
     * @return String
     *
     * It returns a String indicating the applied conditions.
     */

    @Override
    public String conditionString () {
        return decoratedTrack.conditionString ();
    }


    /**
     * Name: toString
     * @return String
     *
     * It represents the information of the class on a String.
     *
     * The returned value is the String representation of the class.
     */

    @Override
    public String toString () {
        return decoratedTrack.toString ();
    }
}
