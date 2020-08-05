/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/



// line 95 "model.ump"
// line 184 "model.ump"
public class Move
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Move Attributes
  private Cell start;
  private Cell end;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Move(Cell aStart, Cell aEnd)
  {
    start = aStart;
    end = aEnd;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStart(Cell aStart)
  {
    boolean wasSet = false;
    start = aStart;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnd(Cell aEnd)
  {
    boolean wasSet = false;
    end = aEnd;
    wasSet = true;
    return wasSet;
  }

  public Cell getStart()
  {
    return start;
  }

  public Cell getEnd()
  {
    return end;
  }

  public void delete()
  {}

  // line 101 "model.ump"
   public boolean isValidMove(){
	return false;
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "start" + "=" + (getStart() != null ? !getStart().equals(this)  ? getStart().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "end" + "=" + (getEnd() != null ? !getEnd().equals(this)  ? getEnd().toString().replaceAll("  ","    ") : "this" : "null");
  }
}