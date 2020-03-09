package MiniProject_II;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCollector {
    // fields
    private int id;
    private String name, mobile, work, home, city, inputUser;
    private Scanner input;

    // constructor
    public void inputCollector(String getId){
        if (getId == "id") setId();
        else{
            setName();
            setMobile();
            setWork();
            setHome();
            setCity();
        }
    }

    // setters
    public void setId(){
        println("Enter the index of the contact to update: "); inputUser = inputStr();
        if (isEmpty(inputUser)) setId();
        if (isNumeric(inputUser)) id = Integer.parseInt(inputUser);
        else setId();
    }
    public void setName(){
        println("Enter name: "); inputUser = inputStr();
        if (isEmpty(inputUser)) setName();
        if (specialCharacters(inputUser)) setName();
        name  = inputUser;
    }
    public void setMobile(){
        println("Enter mobile: "); inputUser = inputStr();
        if (isEmpty(inputUser)) setMobile();
        if (specialCharacters(inputUser)) setName();
        if (isPhone(inputUser)) mobile = inputUser;
        else setMobile();
    }
    public void setHome(){
        println("Enter home: "); inputUser = inputStr();
        if (specialCharacters(inputUser)) setName();
        if (inputUser.equals("")) home = "";
        else if (isPhone(inputUser)) home = inputUser;
        else setHome();
    }
    public void setWork(){
        println("Enter work: "); inputUser = inputStr();
        if (specialCharacters(inputUser)) setName();
        if (inputUser.equals("")) work = "";
        else if (isPhone(inputUser)) work = inputUser;
        else setWork();
    }
    public void setCity(){
        println("Enter city: "); inputUser = inputStr();
        if (isEmpty(inputUser)) setCity();
        if (specialCharacters(inputUser)) setName();
        city    = inputUser;
    }

    // getters
    public int    getId()     { return id;     }
    public String getName()   { return name;   }
    public String getMobile() { return mobile; }
    public String getWork()   { return work;   }
    public String getHome()   { return home;   }
    public String getCity()   { return city;   }

    // local methods
    void println(String message){ System.out.println(message); }
    String getUserInput(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return prompt = input.nextLine();
    }
    boolean specialCharacters(String str){
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(str);
        if (match.find()){
            println("The input has invalid characters.\n");
            return true;
        }
        else              return false;
    }
    boolean isNumeric(String str) {
        try {
            boolean flag = true;
            if (str == null) flag = false;
            assert str != null;
            Integer.parseInt(str);
            if (flag) return true;
            else {
                println("You must enter a valid numeric number.\n");
                return false;
            }
        } catch(NumberFormatException e){
            println("You must enter a valid numeric number.\n");
            return false;
        }
    }
    boolean isPhone(String str){
        try{
            boolean flag = false;
            if (str == null) flag = false;
            flag = str.length() == 10;

            if (flag) return true;
            else{
                println("You must enter a valid phone number.\n");
                return false;
            }
        }catch(NumberFormatException e){
            println("You must enter a valid phone number.\n");
            return false;
        }
    }
    boolean isEmpty(String str){
        if (str.equals("")){
            println("You must enter this field.\n");
            return true;
        }
        return false;
    }
    String inputStr(){
        input = new Scanner(System.in);
        return input.nextLine();
    }

    // public methods
    public boolean equal(String name, String mobile){
        if (this.name.equals(name) && this.mobile.equals(mobile))
            return true;
        else
            return false;
    }
}
