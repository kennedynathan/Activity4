package app;

/**
 * Creates a car specified properties of year, make, model, odometer, and engine liters.
 * * @version 10/29/2023
 * @author Nathan Kennedy
 */
public class Car {
    private int year;
    private String make;
    private String model;
    private int odometer;
    private double engineLiters;

    //default constructor
    public Car() {
        this.year = 0;
        this.make = "";
        this.model = "";
        this.odometer = 0;
        this.engineLiters = 0.0;
    }

    //argument constructor with make year model odometer and engine liters
    public Car(int year, String make, String model, int odometer, double engineLiters) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        this.engineLiters = engineLiters;
    }

    //gets car year
    public int getYear() {
        return year;
    }

    //sets year of car
    public void setYear(int year) {
        this.year = year;
    }

    //Returns make of the car
    public String getMake() {
        return make;
    }

    //Sets make of the car
    public void setMake(String make) {
        this.make = make;
    }

    //gets model of the car
    public String getModel() {
        return model;
    }

    //sets model
    public void setModel(String model) {
        this.model = model;
    }

    //gets odometer reading
    public int getOdometer() {
        return odometer;
    }

    //sets odometer reading
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    //gets liters
    public double getEngineLiters() {
        return engineLiters;
    }

    //sets liters
    public void setEngineLiters(double engineLiters) {
        this.engineLiters = engineLiters;
    }
}