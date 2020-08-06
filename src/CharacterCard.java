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

  @Override
  public boolean equals(Object obj){
    if (this == obj)  return true;
    if (obj == null)  return false;
    if (obj.getClass() != this.getClass())  return false;
    CharacterCard other = (CharacterCard)obj;
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