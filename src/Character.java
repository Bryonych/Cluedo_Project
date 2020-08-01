/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 49 "model.ump"
// line 143 "model.ump"
public class Character
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Character Attributes
  private String name;
  private Hand hand;
  private Cell location;

  //Character Associations
  private Hand has;
  private List<Move> performs;
  private List<Board> boards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Character(String aName, Hand aHand, Cell aLocation, Hand aHas)
  {
    name = aName;
    hand = aHand;
    location = aLocation;
    if (!setHas(aHas))
    {
      throw new RuntimeException("Unable to create Character due to aHas. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    performs = new ArrayList<Move>();
    boards = new ArrayList<Board>();
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

  public boolean setHand(Hand aHand)
  {
    boolean wasSet = false;
    hand = aHand;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(Cell aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Hand getHand()
  {
    return hand;
  }

  public Cell getLocation()
  {
    return location;
  }
  /* Code from template association_GetOne */
  public Hand getHas()
  {
    return has;
  }
  /* Code from template association_GetMany */
  public Move getPerform(int index)
  {
    Move aPerform = performs.get(index);
    return aPerform;
  }

  public List<Move> getPerforms()
  {
    List<Move> newPerforms = Collections.unmodifiableList(performs);
    return newPerforms;
  }

  public int numberOfPerforms()
  {
    int number = performs.size();
    return number;
  }

  public boolean hasPerforms()
  {
    boolean has = performs.size() > 0;
    return has;
  }

  public int indexOfPerform(Move aPerform)
  {
    int index = performs.indexOf(aPerform);
    return index;
  }
  /* Code from template association_GetMany */
  public Board getBoard(int index)
  {
    Board aBoard = boards.get(index);
    return aBoard;
  }

  public List<Board> getBoards()
  {
    List<Board> newBoards = Collections.unmodifiableList(boards);
    return newBoards;
  }

  public int numberOfBoards()
  {
    int number = boards.size();
    return number;
  }

  public boolean hasBoards()
  {
    boolean has = boards.size() > 0;
    return has;
  }

  public int indexOfBoard(Board aBoard)
  {
    int index = boards.indexOf(aBoard);
    return index;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setHas(Hand aNewHas)
  {
    boolean wasSet = false;
    if (aNewHas != null)
    {
      has = aNewHas;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPerforms()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addPerform(Move aPerform)
  {
    boolean wasAdded = false;
    if (performs.contains(aPerform)) { return false; }
    performs.add(aPerform);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePerform(Move aPerform)
  {
    boolean wasRemoved = false;
    if (performs.contains(aPerform))
    {
      performs.remove(aPerform);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPerformAt(Move aPerform, int index)
  {  
    boolean wasAdded = false;
    if(addPerform(aPerform))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPerforms()) { index = numberOfPerforms() - 1; }
      performs.remove(aPerform);
      performs.add(index, aPerform);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePerformAt(Move aPerform, int index)
  {
    boolean wasAdded = false;
    if(performs.contains(aPerform))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPerforms()) { index = numberOfPerforms() - 1; }
      performs.remove(aPerform);
      performs.add(index, aPerform);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPerformAt(aPerform, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoards()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBoard(Board aBoard)
  {
    boolean wasAdded = false;
    if (boards.contains(aBoard)) { return false; }
    boards.add(aBoard);
    if (aBoard.indexOfCharacter(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBoard.addCharacter(this);
      if (!wasAdded)
      {
        boards.remove(aBoard);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBoard(Board aBoard)
  {
    boolean wasRemoved = false;
    if (!boards.contains(aBoard))
    {
      return wasRemoved;
    }

    int oldIndex = boards.indexOf(aBoard);
    boards.remove(oldIndex);
    if (aBoard.indexOfCharacter(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBoard.removeCharacter(this);
      if (!wasRemoved)
      {
        boards.add(oldIndex,aBoard);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBoardAt(Board aBoard, int index)
  {  
    boolean wasAdded = false;
    if(addBoard(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoardAt(Board aBoard, int index)
  {
    boolean wasAdded = false;
    if(boards.contains(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBoardAt(aBoard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    has = null;
    performs.clear();
    ArrayList<Board> copyOfBoards = new ArrayList<Board>(boards);
    boards.clear();
    for(Board aBoard : copyOfBoards)
    {
      if (aBoard.numberOfCharacters() <= Board.minimumNumberOfCharacters())
      {
        aBoard.delete();
      }
      else
      {
        aBoard.removeCharacter(this);
      }
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hand" + "=" + (getHand() != null ? !getHand().equals(this)  ? getHand().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "has = "+(getHas()!=null?Integer.toHexString(System.identityHashCode(getHas())):"null");
  }
}