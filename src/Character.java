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

  public Character(String aName, Cell aLocation, Cell.Type character)
  {
    name = aName;
    location = aLocation;
    this.currentRoom = Cell.Type.START;
    characterType = character;

  }

  public Cell.Type getCharacterType(){
    return characterType;
  }

  public void setHand(Hand newHand){
    this.hand = newHand;
  }

  public Cell.Type getCurrentRoom(){
    return currentRoom;
  }

  public void setCurrentRoom(Cell.Type newRoom){
    currentRoom = newRoom;
  }

  public Cell getLocation(){
    return location;
  }


  public String getName()
  {
    return name;
  }

  public Hand getHand()
  {
    return hand;
  }

  @Override
  public boolean equals(Object obj){
    if (this == obj)  return true;
    if (obj == null)  return false;
    if (obj.getClass() != this.getClass())  return false;
    Character other = (Character)obj;
    return this.name.equals(other.name);
  }



}