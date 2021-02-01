import java.util.Objects;

/**
 * Name: Results
 * This class contains the atributes needed for the reults
 *
 * @version 1.0 (12/24/2020) 29/01/21
 * @author Raúl && Eduardo
 */
public class Results {
    private Double time;
    private int points;
    private Trackable track;

    public Results(Double time, Trackable track) {   //we can use this constructor for testing
        this.time = time;
        this.points = 0;
        this.track = track;
    }

    /**
     * Name: getTime
     * @return double
     *
     * Returns the time of the result.
     */
    public Double getTime() {
        return time;
    }

    /**
     * Name: setTime
     * @param time: Double
     * Sets the given time to the result.
     * The parameter "time" corresponds to the time of the result.
     * This method returns nothing.
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * Name: getPoints
     * @return int
     *
     * Returns the points of the result.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Name: setPoints
     * @param points: int
     * Sets the given points to the result.
     * The parameter "points" corresponds to the points of the result.
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
    public Trackable getTrack() {
        return track;
    }

    /**
     * Name: setTrack
     * @param track: Trackable
     * Sets the given track to the result.
     * The parameter "track" corresponds to the track of the result.
     * This method returns nothing.
     */
    public void setTrack(Trackable track) {
        this.track = track;
    }

    //mirar si esto nos hace falta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return Objects.equals(time, results.time) && Objects.equals(points, results.points) && Objects.equals(track, results.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, points, track);
    }
}
