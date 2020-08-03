/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/



// line 71 "model.ump"
// line 163 "model.ump"
public class CharacterCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CharacterCard Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CharacterCard(String name)
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


  public String toString()
  {
    return " ------------------- \n" +
            " Card: " + name + "\n" +
            " ------------------- ";
  }
}