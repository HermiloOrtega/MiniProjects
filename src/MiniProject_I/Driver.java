package MiniProject_I;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        City cities = new City("cities.txt");
        cities.startGame(10);
        //City citiesUSA = new City("citiesUSA.txt");
        //citiesUSA.startGame(8);
    }
}