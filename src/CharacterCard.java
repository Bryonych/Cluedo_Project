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

  public CharacterCard(Game aGame, String aName)
  {
    super(aGame);
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}