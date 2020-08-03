import java.util.*;

// line 43 "model.ump"
// line 138 "model.ump"
public class Weapon
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Weapon Attributes
    private String name;
    private Room location;
    private Cell.Type weaponType;


    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Weapon(String aName, Room aLocation, Cell.Type weaponType)
    {
        name = aName;
        location = aLocation;
        this.weaponType = weaponType;

    }

    //------------------------
    // INTERFACE
    //------------------------

    public Cell.Type getType(){
        return weaponType;
    }

    public boolean setName(String aName)
    {
        boolean wasSet = false;
        name = aName;
        wasSet = true;
        return wasSet;
    }

    public boolean setLocation(Room aLocation)
    {
        boolean wasSet = false;
        location = aLocation;
        wasSet = true;
        return wasSet;
    }

    public String getName()
    {
        return name;
    }

    public Room getLocation()
    {
        return location;
    }
    /* Code from template association_GetMany */

    public String toString()
    {
        return super.toString() + "["+
                "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null");
    }
}


