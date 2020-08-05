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
  private Cell.Type currentRoom;
  private Cell.Type characterType;


  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Character(String aName, Cell aLocation)
  {
    name = aName;
    location = aLocation;
    this.currentRoom = Cell.Type.START;
   // this.characterType = t;

  }

  public Cell.Type getCharacterType(){
    return characterType;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Cell.Type getCurrentRoom(){
    return currentRoom;
  }

  public void setCurrentRoom(Cell.Type newRoom){
    currentRoom = newRoom;
  }

  public Cell getLocation(){
    return location;
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


}