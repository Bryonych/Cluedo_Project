/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/



// line 29 "model.ump"
// line 128 "model.ump"
public class Cell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cell Attributes
  private boolean isWall;
  private boolean isEmpty;
  private int xPos;
  private int yPos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(boolean aIsWall, boolean aIsEmpty, int aXPos, int aYPos)
  {
    isWall = aIsWall;
    isEmpty = aIsEmpty;
    xPos = aXPos;
    yPos = aYPos;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsWall(boolean aIsWall)
  {
    boolean wasSet = false;
    isWall = aIsWall;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsEmpty(boolean aIsEmpty)
  {
    boolean wasSet = false;
    isEmpty = aIsEmpty;
    wasSet = true;
    return wasSet;
  }

  public boolean setXPos(int aXPos)
  {
    boolean wasSet = false;
    xPos = aXPos;
    wasSet = true;
    return wasSet;
  }

  public boolean setYPos(int aYPos)
  {
    boolean wasSet = false;
    yPos = aYPos;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsWall()
  {
    return isWall;
  }

  public boolean getIsEmpty()
  {
    return isEmpty;
  }

  public int getXPos()
  {
    return xPos;
  }

  public int getYPos()
  {
    return yPos;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "isWall" + ":" + getIsWall()+ "," +
            "isEmpty" + ":" + getIsEmpty()+ "," +
            "xPos" + ":" + getXPos()+ "," +
            "yPos" + ":" + getYPos()+ "]";
  }
}