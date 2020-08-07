public class RoomCard extends Card
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //RoomCard Attributes
    private String name;
    private Room room;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public RoomCard(String name, Room room)
    {
        super(name);
        this.name = name;
        this.room = room;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public String getName()
    {
        return name;
    }

    public Room getRoom(){
        return room;
    }


    public String toString()
    {
        return " ------------------- \n" +
                " Card: " + name + "\n" +
                " ------------------- \n";
    }
}
