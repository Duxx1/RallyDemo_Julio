/**
 * Name: Results
 * This class contains the attributes needed for the results obtained after a race.
 *
 * @version 1.0 (01/29/2021) 29/01/21
 * @author Raul Hormigo Ceron and Eduardo Cano García
 *
 */

public class Results {
    private Double time;
    private int points;
    private Trackable track;

    /**
     * Name: Results
     * @param time is the time that is obtained after a race.
     * @param track is the track where the pilot has raced.
     *
     * Initialises the attributes from the class to certain given ones, except the points; which are initialised with 0.
     *
     * This method returns nothing
     */

    public Results (Double time, Trackable track) {   //we can use this constructor for testing
        setTime (time);
        setPoints (0);
        setTrack (track);
    }


    /**
     * Name: getTime
     * @return double
     *
     * Returns the time of the result.
     */

    public double getTime () {
        return time;
    }


    /**
     * Name: setTime
     * @param time is the time that will be assigned.
     *
     * Sets the given time to the time attribute.
     *
     * This method returns nothing.
     */

    public void setTime (double time) {
        this.time = time;
    }


    /**
     * Name: getPoints
     * @return int
     *
     * Returns the points of the result.
     */

    public int getPoints () {
        return points;
    }


    /**
     * Name: setPoints
     * @param points are the points that will be assigned.
     *
     * Sets the given points to the result.
     *
     * This method returns nothing.
     */

    public void setPoints (int points) {
        this.points = points;
    }


    /**
     * Name: getTrack
     * @return int
     *
     * Returns the track of the result.
     */

    public Trackable getTrack () {
        return track;
    }


    /**
     * Name: setTrack
     * @param track is the track that will be assigned.
     *
     * Sets the given track to the result.
     *
     * This method returns nothing.
     */

    public void setTrack (Trackable track) {
        this.track = track;
    }
}
