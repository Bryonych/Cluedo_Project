/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/



// line 83 "model.ump"
// line 173 "model.ump"
public class RoomCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoomCard Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoomCard(String name)
  {
    super(name);
    this.name = name;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  @Override
  public boolean equals(Object obj){
    if (this == obj)  return true;
    if (obj == null)  return false;
    if (obj.getClass() != this.getClass())  return false;
    RoomCard other = (RoomCard)obj;
    return this.name.equals(other.name);
  }

  @Override
  public String toString()
  {
    return " ------------------- \n" +
            " Card: " + name + "\n" +
            " -------------------\n";
  }
}