package MiniProject_II;

public class Contact {
    // fields
    private String name, mobile, work, home, city;

    // constructors
    public Contact(){}
    public Contact(String name, String mobile, String city){
        setName(name);
        setMobile(mobile);
        setCity(city);
    }
    public Contact(String name, String mobile, String work, String home, String city){
        this(name, mobile, city);
        setWork(work);
        setHome(home);
    }

    // setters
    public void setName  (String Name)   { name   = (Name.equals(""))  ?"":Name;   }
    public void setMobile(String Mobile) { mobile = (Mobile.equals(""))?"":Mobile; }
    public void setWork  (String Work)   { work   = (Work.equals(""))  ?"":Work;   }
    public void setHome  (String Home)   { home   = (Home.equals(""))  ?"":Home;   }
    public void setCity  (String City)   { city   = (City.equals(""))  ?"":City;   }

    // getters
    public String getName()   { return name;   }
    public String getMobile() { return mobile; }
    public String getWork()   { return work;   }
    public String getHome()   { return home;   }
    public String getCity()   { return city;   }
}
