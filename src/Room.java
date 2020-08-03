import java.util.*;

// line 37 "model.ump"
// line 133 "model.ump"
public class Room
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Room Attributes
    private String name;
    private Cell weaponSpot;
    private Weapon currentWeapon;
    private Cell.Type roomType;


    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Room(String aName, Cell weapon, Cell.Type roomType)
    {
        name = aName;
        weaponSpot = weapon;
        this.roomType = roomType;

    }

    //------------------------
    // INTERFACE
    //------------------------

   public Cell.Type getType(){
        return roomType;
   }

   public Cell getWeaponSpot(){
        return weaponSpot;
   }

   public void changeWeapon(Weapon newWeapon){
        this.currentWeapon = newWeapon;
   }

    public String getName()
    {
        return name;
    }



    public String toString()
    {
        return super.toString() + "["+
                "name" + ":" + getName()+ "]";
    }
}


