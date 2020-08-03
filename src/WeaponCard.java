/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/



// line 77 "model.ump"
// line 168 "model.ump"
public class WeaponCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WeaponCard Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WeaponCard(String name)
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