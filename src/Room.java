/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 37 "model.ump"
// line 133 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String name;
  private List<Cell> area;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName)
  {
    name = aName;
    area = new ArrayList<Cell>();
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
  /* Code from template attribute_SetMany */
  public boolean addArea(Cell aArea)
  {
    boolean wasAdded = false;
    wasAdded = area.add(aArea);
    return wasAdded;
  }

  public boolean removeArea(Cell aArea)
  {
    boolean wasRemoved = false;
    wasRemoved = area.remove(aArea);
    return wasRemoved;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetMany */
  public Cell getArea(int index)
  {
    Cell aArea = area.get(index);
    return aArea;
  }

  public Cell[] getArea()
  {
    Cell[] newArea = area.toArray(new Cell[area.size()]);
    return newArea;
  }

  public int numberOfArea()
  {
    int number = area.size();
    return number;
  }

  public boolean hasArea()
  {
    boolean has = area.size() > 0;
    return has;
  }

  public int indexOfArea(Cell aArea)
  {
    int index = area.indexOf(aArea);
    return index;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}