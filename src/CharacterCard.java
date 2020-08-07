public class CharacterCard extends Card
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CharacterCard Attributes
    private String name;
    Character character;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CharacterCard(String name, Character character)
    {
        super(name);
        this.name = name;
        this.character = character;
    }

    //------------------------
    // INTERFACE
    //------------------------


    public String getName()
    {
        return name;
    }

    public Character getCharacter(){
        return character;
    }

    public String toString()
    {
        return " ------------------- \n" +
                " Card: " + name + "\n" +
                " ------------------- \n";
    }
}
