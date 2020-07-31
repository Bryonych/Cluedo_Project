/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 89 "model.ump"
// line 178 "model.ump"
public class Hand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hand Attributes
  private List cards;

  //Hand Associations
  private List<Card> contains;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hand(List aCards)
  {
    cards = aCards;
    contains = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCards(List aCards)
  {
    boolean wasSet = false;
    cards = aCards;
    wasSet = true;
    return wasSet;
  }

  public List getCards()
  {
    return cards;
  }
  /* Code from template association_GetMany */
  public Card getContain(int index)
  {
    Card aContain = contains.get(index);
    return aContain;
  }

  public List<Card> getContains()
  {
    List<Card> newContains = Collections.unmodifiableList(contains);
    return newContains;
  }

  public int numberOfContains()
  {
    int number = contains.size();
    return number;
  }

  public boolean hasContains()
  {
    boolean has = contains.size() > 0;
    return has;
  }

  public int indexOfContain(Card aContain)
  {
    int index = contains.indexOf(aContain);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfContains()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addContain(Card aContain)
  {
    boolean wasAdded = false;
    if (contains.contains(aContain)) { return false; }
    contains.add(aContain);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeContain(Card aContain)
  {
    boolean wasRemoved = false;
    if (contains.contains(aContain))
    {
      contains.remove(aContain);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addContainAt(Card aContain, int index)
  {  
    boolean wasAdded = false;
    if(addContain(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContains()) { index = numberOfContains() - 1; }
      contains.remove(aContain);
      contains.add(index, aContain);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveContainAt(Card aContain, int index)
  {
    boolean wasAdded = false;
    if(contains.contains(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContains()) { index = numberOfContains() - 1; }
      contains.remove(aContain);
      contains.add(index, aContain);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addContainAt(aContain, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    contains.clear();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cards" + "=" + (getCards() != null ? !getCards().equals(this)  ? getCards().toString().replaceAll("  ","    ") : "this" : "null");
  }
}