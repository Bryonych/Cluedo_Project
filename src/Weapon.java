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

    public String getName()
    {
        return name;
    }

    public Room getLocation()
    {
        return location;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)  return true;
        if (obj == null)  return false;
        if (obj.getClass() != this.getClass())  return false;
        Weapon other = (Weapon)obj;
        return this.name.equals(other.name);
    }

}


