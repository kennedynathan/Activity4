package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Demonstrates how to read and write Car objects from/to a JSON file.
 * @version 09/09/2023
 * @author Nathan Kennedy
 */
public class DemoJsonFiles {


     // Saves a Car object to a JSON file.
	
     // @param filename Name to save file.
     // @param car The Car object to save.
     // @param append the object to the existing file.
     
    private static void saveToFile(String filename, Car car, boolean append) {
        try (FileWriter fw = new FileWriter(filename, append);
             PrintWriter pw = new PrintWriter(fw)) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(car);
            pw.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
     // Reads Cars from a JSON file into ArrayList.
     
     // @param filename Name of the file from which the objects will be read.
     // @return An ArrayList containing the read Car objects.
   
    private static ArrayList<Car> readFromFile(String filename) {
        ArrayList<Car> cars = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try (Scanner s = new Scanner(new File(filename))) {
            while (s.hasNext()) {
                String json = s.nextLine();
                Car car = objectMapper.readValue(json, Car.class);
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

     // shows JSON read/write functions.

    public static void main(String[] args) {
        Car[] cars = {
            new Car(2018, "Ford", "Mustang", 0, 1.5d),
            new Car(2018, "Chevy", "Blazer", 1000, 1.5d),
            new Car(2019, "Toyota", "Camry", 2000, 1.5d),
            new Car(2018, "Toyota", "Avalon", 90000, 2.5d),
            new Car(2010, "GMC", "Silverado", 10000, 3.5d)
        };

        for (Car car : cars) {
            saveToFile("out.json", car, true);
        }

        ArrayList<Car> carsList = readFromFile("out.json");
        for (Car carFromJson : carsList) {
            String text = "Year: " + carFromJson.getYear() + ", Make: " + carFromJson.getMake() + ", Model: "
                + carFromJson.getModel() + ", Odometer: " + carFromJson.getOdometer() + ", Engine Liters: "
                + carFromJson.getEngineLiters();
            System.out.println(text);
        }
    }
}