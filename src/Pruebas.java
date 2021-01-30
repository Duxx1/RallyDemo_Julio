public class Pruebas {
        public static void main(String[] args) {
            Trackable circuito = new Track("Circuito de Pruebas",TrackComplexity.MEDIUM,TrackDistance.INTERMEDIATE);
            circuito = new GravelTrack(circuito);
    //        System.out.println(circuito.toString());
            circuito = new NightTrack((circuito));
    //        System.out.println(circuito.toString());

    //        System.out.println("#############################");
    //        System.out.println("PROBANDO LOS PILOTOS");
    //        System.out.println("#############################");
            Trackable chile = new Track("Chile",TrackComplexity.HIGH,TrackDistance.SHORT);
            chile = new GravelTrack(chile);
    //        Pilot pilot=new StarPilot("McRae",Concentration.FOCUSED);
    //        Carable car = new FastCar("Seat Ateca", CarSpeed.CHEETAH, CarFuel.GENEROUS);
    //        car.setCurrentFuel(car.getCurrentFuel()-76.03);
    //        pilot.setCar(car);
    //        pilot.drive(chile);
    //        System.out.println("PROBADO CON EXITO UN PILOTO CON UN COCHE RAPIDO");

    //        Trackable circuito_cocheResistente = new Track("circuito_cocheResistente",TrackComplexity.LOW,TrackDistance.SHORT);
    //        Pilot piloto_coche_r=new StarPilot("Lleivi",Concentration.CLUELESS);
    //        Carable coche_resistente = new DurableCar("Lleivimovil", CarSpeed.TURTLE, CarFuel.LIMITED);
    //        coche_resistente.setCurrentFuel(0.0);
    //        piloto_coche_r.setCar(coche_resistente);
    //        piloto_coche_r.drive(circuito_cocheResistente);


            Organization.getInstance().createSetForTracks(new TrackComplexityComparator(), false);
            Organization.getInstance().setLeftLimit(1);
            Organization.getInstance().setPilotsLimit(2);
            Team peugeot = new Team("Peugeot");
            Pilot pilot=new StarPilot("McRae",Concentration.FOCUSED);
            peugeot.getPilotList().add(pilot);
            Pilot lleivi=new StarPilot("Lleivi",Concentration.CLUELESS);
            peugeot.getPilotList().add(lleivi);
            Carable car = new FastCar("Seat Ateca", CarSpeed.CHEETAH, CarFuel.GENEROUS);
            car.setCurrentFuel(0.0);
            peugeot.getCarList().add(car);
            Carable lleivimovil = new DurableCar("Lleivimovil", CarSpeed.TURTLE, CarFuel.LIMITED);
            lleivimovil.setCurrentFuel(0.0);
            peugeot.getCarList().add(lleivimovil);

            Team seat = new Team("Seat");
            Pilot p1=new StarPilot("Juan",Concentration.FOCUSED);
            seat.getPilotList().add(p1);
            Pilot p2=new StarPilot("Encarna",Concentration.CLUELESS);
            seat.getPilotList().add(p2);
            Carable car1 = new FastCar("Seat Cordoba", CarSpeed.CHEETAH, CarFuel.GENEROUS);
            car1.setCurrentFuel(0.0);
            seat.getCarList().add(car1);
            Carable car2 = new DurableCar("Seat Arona", CarSpeed.TURTLE, CarFuel.LIMITED);
            car2.setCurrentFuel(0.0);
            seat.getCarList().add(car2);

            peugeot.register();
            seat.register();

            Organization.getInstance().getTracks().add(circuito);
            Organization.getInstance().getTracks().add(chile);

//            for(Pilot p : Organization.getInstance().getRacingPilots()){
//                System.out.println(p.toString());
//            }
            Organization.getInstance().showTracks();
            Organization.getInstance().showTeams();

            System.out.println(seat.toString());
    }
}
