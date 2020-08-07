public class WeaponCard extends Card
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //WeaponCard Attributes
    private String name;
    private Weapon weapon;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public WeaponCard(String name, Weapon weapon)
    {
        super(name);
        this.name = name;
        this.weapon = weapon;
    }

    //------------------------
    // INTERFACE
    //------------------------


    public String getName()
    {
        return name;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public String toString()
    {
        return " ------------------- \n" +
                " Card: " + name + "\n" +
                " ------------------- \n";
    }
}
