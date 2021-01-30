public class Pruebas {
    public static void main(String[] args) {
//        Trackable circuito = new Track("Circuito de Pruebas",TrackComplexity.MEDIUM,TrackDistance.INTERMEDIATE);
//        circuito = new GravelTrack(circuito);
//        System.out.println(circuito.toString());
//        circuito = new NightTrack((circuito));
//        System.out.println(circuito.toString());

        System.out.println("#############################");
        System.out.println("PROBANDO LOS PILOTOS");
        System.out.println("#############################");
        Trackable chile = new Track("Chile",TrackComplexity.HIGH,TrackDistance.SHORT);
        chile = new GravelTrack(chile);
        Pilot pilot=new StarPilot("McRae",Concentration.FOCUSED);
        Carable car = new FastCar("Seat Ateca", CarSpeed.CHEETAH, CarFuel.GENEROUS);
        car.setCurrentFuel(car.getCurrentFuel()-76.03);
        pilot.setCar(car);
        pilot.drive(chile);
        System.out.println("PROBADO CON EXITO UN PILOTO CON UN COCHE RAPIDO");
    }
}
