package MiniProject_II;
import java.util.ArrayList;
public class ContactList {
    // fields
    private ArrayList<Contact> list;
    private InputCollector     input;

    // constructors
    /**
     * Constructor
     * @param
     * @return
     */
    public ContactList(){
        list = new ArrayList<>();
        input = new InputCollector();
    }

    // local methods
    /**
     * Structure and show the contact info
     * @param contact, index
     * @return
     */
    void showContactInfo(Contact contact, int index){
        String format;
        format = index + ". <" + contact.getName() + "> (Mobile: " + contact.getMobile();
        format = (contact.getWork().equals(""))?format:format+", Work: " + contact.getWork();
        format = (contact.getHome().equals(""))?format:format+", Home: " + contact.getHome();
        format = (contact.getCity().equals(""))?format:format+", City: " + contact.getCity();
        format = format + ")";
        System.out.println(format);
    }
    /**
     * Show a message as println
     * @param
     * @return
     */
    void message(String message){
        System.out.println(message);
    }
    /**
     * Show the contact list and then check if the id is correct
     * @param
     * @return the id of the contact
     */
    int searchIdContact(){
        listContact();
        input.inputCollector("id");
        int id=input.getId();
        if (id>=list.size() || id < 0) {
            message("Invalid input. Enter number between 0 to " + (list.size() - 1));
            System.out.println();
            searchIdContact();
        }
        return id;
    }
    /**
     * Validate duplicate rows in the arraylist
     * @param
     * @return duplicate (boolean)
     */
    boolean validateDuplicate(){
        input.inputCollector("");
        boolean duplicate = false;
        for (Contact contact: list) {
            if (input.equal(contact.getName(), contact.getMobile())){
                System.out.println("The contact is duplicate, please fill the information with another contact\n");
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    // public methods
    /**
     * Add Contacts to the ArrayList
     * @param
     * @return
     */
    public void addContact(){
        if (validateDuplicate()) addContact();
        list.add(new Contact(input.getName(), input.getMobile(), input.getWork(), input.getHome(), input.getCity()));
        message("Successfully added\n");
    }
    /**
     * Update Contacts in the ArrayList
     * @param
     * @return
     */
    public void updateContact(){
        int id = searchIdContact();
        if (validateDuplicate()) updateContact();
        list.get(id).setName(input.getName());
        list.get(id).setMobile(input.getMobile());
        list.get(id).setWork(input.getWork());
        list.get(id).setHome(input.getHome());
        list.get(id).setCity(input.getCity());
        message("Successfully updated " + list.get(id).getName() + " \n");
    }
    /**
     * Delete Contacts of the ArrayList
     * @param
     * @return
     */
    public void deleteContact(){
        int id = searchIdContact();
        list.remove(id);
        message("Successfully removed " + list.get(id).getName() + " \n");
    }
    /**
     * Show the Contact List
     * @param
     * @return
     */
    public void listContact(){
        if (list.size()>0){
            int index = 0;
            for (Contact contact : list) {
                showContactInfo(contact, index);
                index++;
            }
            System.out.println();
        }else message("The Contact list is empty");
    }
}
