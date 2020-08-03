/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 18 "model.ump"
// line 117 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Attributes
  private Cell[][] squares;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(Cell[][] squares)
  {
    this.squares = squares;
  }

  public Cell[][] getCells(){
    return squares;
  }





}