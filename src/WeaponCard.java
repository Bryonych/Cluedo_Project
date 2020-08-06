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

  @Override
  public boolean equals(Object obj){
      if (this == obj)  return true;
      if (obj == null)  return false;
      if (obj.getClass() != this.getClass())  return false;
      WeaponCard other = (WeaponCard)obj;
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