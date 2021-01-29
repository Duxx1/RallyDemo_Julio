public class Pruebas {
    public static void main(String[] args) {
        Trackable circuito = new Track("Circuito de Pruebas",TrackComplexity.MEDIUM,TrackDistance.INTERMEDIATE);
        circuito = new GravelTrack(circuito);
        System.out.println(circuito.toString());
        circuito = new NightTrack((circuito));
        System.out.println(circuito.toString());
    }
}
