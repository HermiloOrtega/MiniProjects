package MiniProject_II;
import java.util.Scanner;
public class Driver {
    /**
     * Main menu
     * @param
     * @return
     */
    public static void main(String[] args) {
        // fields
        Driver         d     = new Driver();
        InputCollector input = new InputCollector();
        ContactList    list  = new ContactList();
        boolean        flag  = true;

        while(flag){
            d.showMenu();
            switch (input.getUserInput("Enter your option: ")){
                case "1": list.listContact  (); break;
                case "2": list.addContact   (); break;
                case "3": list.updateContact(); break;
                case "4": list.deleteContact(); break;
                case "5": System.out.println("God Bye! Have a good day!"); flag = false; break;
                default:
                    System.out.println("Invalid input. Enter number between 1 to 5\n"); break;
            }
        }
    }

    // local methods
    /**
     * Show the main menu
     * @param
     * @return
     */
    void showMenu(){
        System.out.println("\n" +
                "+===== Contact App ====+\n" +
                "] 1. List All Contacts [\n" +
                "] 2. Add New Contact   [\n" +
                "] 3. Update Contact    [\n" +
                "] 4. Remove Contact    [\n" +
                "] 5. Quit              [\n" +
                "========================");
    }
}
