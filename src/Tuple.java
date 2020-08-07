import java.util.*;

// line 58 "model.ump"
// line 150 "model.ump"
public class Tuple
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Tuple Attributes
    private CharacterCard murderer;
    private WeaponCard weapon;
    private RoomCard crimeScene;



    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Tuple(CharacterCard aMurderer, WeaponCard aWeapon, RoomCard aCrimeScene)
    {
        murderer = aMurderer;
        weapon = aWeapon;
        crimeScene = aCrimeScene;

    }

    //------------------------
    // INTERFACE
    //------------------------


    public CharacterCard getMurderer()
    {
        return murderer;
    }

    public WeaponCard getWeapon()
    {
        return weapon;
    }

    public RoomCard getCrimeScene()
    {
        return crimeScene;
    }



    public String toString()
    {
        return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "murderer" + "=" + (getMurderer() != null ? !getMurderer().equals(this)  ? getMurderer().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "weapon" + "=" + (getWeapon() != null ? !getWeapon().equals(this)  ? getWeapon().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "crimeScene" + "=" + (getCrimeScene() != null ? !getCrimeScene().equals(this)  ? getCrimeScene().toString().replaceAll("  ","    ") : "this" : "null");
    }
}

