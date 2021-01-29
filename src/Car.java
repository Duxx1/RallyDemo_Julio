public class Car {
    // hola
    private String name;
    private CarSpeed speed;
    private CarFuel fuel;
    private double currentFuel;

    public Car (String name, CarSpeed speed, CarFuel fuel) {
        setCarName (name);
        setCarSpeed (speed);
        setCarFuel (fuel);
        setCurrentFuel (getCarFuel ().getValue ());
    }

    public String getCarName () {
        return name;
    }

    public void setCarName (String name) {
        this.name = name;
    }

    public CarSpeed getCarSpeed () {
        return speed;
    }

    public void setCarSpeed (CarSpeed speed) {
        this.speed = speed;
    }

    public CarFuel getCarFuel () {
        return fuel;
    }

    public void setCarFuel (CarFuel fuel) {
        this.fuel = fuel;
    }

    public double getCurrentFuel () {
        return currentFuel;
    }

    public void setCurrentFuel (double fuel) {
        this.currentFuel = fuel;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
    }
}

