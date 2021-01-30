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
    private Double points;
    private Trackable track;

    public Results(Double time, Double points, Trackable track) {   //we can use this constructor for testing
        this.time = time;
        this.points = points;
        this.track = track;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Trackable getTrack() {
        return track;
    }

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
