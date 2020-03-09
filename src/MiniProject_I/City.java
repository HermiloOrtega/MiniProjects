package MiniProject_I;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class City {
    private static String[] cities, cityUnderLine;
    private static String   city, lettersWrong = "", letter, completeCity, fileName;
    private static int      numRows, fails, limitChances;
    private static Random   randomCity = new Random();
    private static Scanner  citiesTxt;
    private static Boolean  fileLoaded = false;

    /**
     * Constructor
     * @param fileName with the name of the file to charge , limitChances set the limit of chances to lost
     * @return --
     */
    public City(String fileName) throws FileNotFoundException {
        setFileName(fileName);
        loadCitiesFile();
    }

    /**
     * Set fileName
     * @param fileName
     * @return --
     */
    public static void setFileName(String fileName) { City.fileName = fileName; }
    /**
     * Load the city list from the file
     * @param --
     * @return --
     */
    public void loadCitiesFile() throws FileNotFoundException {
        citiesTxt = new Scanner(new File(getFileName()));
        while(citiesTxt.hasNextLine()){
            numRows++;
            citiesTxt.nextLine();
        }
        if (numRows<=0){
            System.out.println("Error at the moment to load the file!!");
            fileLoaded = false;
        }
        else {
            fileLoaded = true;
            cities = new String[numRows];
            citiesTxt.close();
            citiesTxt = new Scanner(new File(getFileName()));
            for (int i = 0; i < numRows; i++) {
                cities[i] = citiesTxt.nextLine();
            }
            citiesTxt.close();
        }
    }

    // SET
    /**
     * Set limitChances
     * @param limitChances
     * @return --
     */
    public static void setLimitChances(int limitChances) { City.limitChances = limitChances; }
    /**
     * Set lettersWrong
     * @param lettersWrong
     * @return --
     */
    public static void setLettersWrong(String lettersWrong) { City.lettersWrong = lettersWrong; }
    /**
     * Set fails
     * @param fails
     * @return --
     */
    public static void setFails(int fails) { City.fails = fails; }
    // GET
    /**
     * Get getFileName
     * @param --
     * @return getFileName
     */
    public static String getFileName() { return fileName; }
    /**
     * Get getLimitChances
     * @param --
     * @return getLimitChances
     */
    public static int getLimitChances() { return limitChances; }
    /**
     * Get getLettersWrong
     * @param --
     * @return getLettersWrong
     */
    public static String getLettersWrong() { return lettersWrong; }
    /**
     * Get getFails
     * @param --
     * @return getFails
     */
    public static int getFails() { return fails; }


    /**
     * Guess city logic
     * @param --
     * @return --
     */
    public void guessCity(){
        while(true){
            Scanner  input = new Scanner(System.in);
            System.out.println("\nGuess a letter" );
            letter = input.nextLine();
            if (letter.length()>1){
                System.out.println("You have written more than one character");
            }
            else if (letter.length()==0){
                System.out.println("You must writte minimum one letter");
            }
            else{
                int numIndex = city.indexOf(letter);
                if (numIndex>=0){
                    while(numIndex>=0){
                        cityUnderLine[numIndex] = letter;
                        numIndex = city.indexOf(letter, numIndex+1);
                    }
                    completeCity = "";
                    for (int i = 0; i < city.length(); i++) {
                        completeCity = completeCity + cityUnderLine[i];
                    }
                    if (completeCity.equals(city)){
                        System.out.printf("YOU WIN!!\nYou have guessed '%s' correctly", city);
                        break;
                    }
                }
                else {
                    if (lettersWrong.indexOf(letter)<0){
                        lettersWrong = lettersWrong + letter + " ";
                        fails++;
                    }
                }
                System.out.print("You are guessing: " );
                for (int i = 0; i < city.length(); i++) {
                    System.out.print(cityUnderLine[i]);
                }
                System.out.printf("\nYou have guessed (%d) wrong letters: %s\n", fails, lettersWrong);
                if (fails == getLimitChances()){
                    System.out.printf("YOU LOSE!!\nThe Correct word was %s\n\n", city);
                    break;
                }
            }
        }
    }
    public void changeCityByUnderLine(){
        for (int i = 0; i < city.length(); i++) {
            cityUnderLine[i] = "_";
        }
    }
    public void startGame(int limitChances) throws FileNotFoundException {
        if (fileLoaded == false){
            System.out.println("File error;");
            return;
        }
        setLimitChances(limitChances);
        setLettersWrong("");
        setFails(0);
        city = cities[randomCity.nextInt(numRows)];
        cityUnderLine = new String[city.length()];
        changeCityByUnderLine();
        System.out.printf("\n**********************************************\n" +
                            "*************** THE GAME START ***************\n" +
                            "**********************************************\n" +
                            "The city to guess has %d letters \n", city.length());
        for (int i = 0; i < city.length(); i++) {
            System.out.print(cityUnderLine[i]);
        }
        guessCity();
        System.out.printf("\n**********************************************\n" +
                            "*************** END OF THE GAME **************\n" +
                            "**********************************************\n");
    }
}
