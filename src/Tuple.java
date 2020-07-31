/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 58 "model.ump"
// line 150 "model.ump"
public class Tuple
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tuple Attributes
  private CharacterCard murderer;
  private WeaponCard weapon;
  private RoomCard crimeScene;

  //Tuple Associations
  private List<Game> games;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tuple(CharacterCard aMurderer, WeaponCard aWeapon, RoomCard aCrimeScene)
  {
    murderer = aMurderer;
    weapon = aWeapon;
    crimeScene = aCrimeScene;
    games = new ArrayList<Game>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMurderer(CharacterCard aMurderer)
  {
    boolean wasSet = false;
    murderer = aMurderer;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeapon(WeaponCard aWeapon)
  {
    boolean wasSet = false;
    weapon = aWeapon;
    wasSet = true;
    return wasSet;
  }

  public boolean setCrimeScene(RoomCard aCrimeScene)
  {
    boolean wasSet = false;
    crimeScene = aCrimeScene;
    wasSet = true;
    return wasSet;
  }

  public CharacterCard getMurderer()
  {
    return murderer;
  }

  public WeaponCard getWeapon()
  {
    return weapon;
  }

  public RoomCard getCrimeScene()
  {
    return crimeScene;
  }
  /* Code from template association_GetMany */
  public Game getGame(int index)
  {
    Game aGame = games.get(index);
    return aGame;
  }

  public List<Game> getGames()
  {
    List<Game> newGames = Collections.unmodifiableList(games);
    return newGames;
  }

  public int numberOfGames()
  {
    int number = games.size();
    return number;
  }

  public boolean hasGames()
  {
    boolean has = games.size() > 0;
    return has;
  }

  public int indexOfGame(Game aGame)
  {
    int index = games.indexOf(aGame);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGames()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addGame(Game aGame)
  {
    boolean wasAdded = false;
    if (games.contains(aGame)) { return false; }
    games.add(aGame);
    if (aGame.indexOfTuple(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aGame.addTuple(this);
      if (!wasAdded)
      {
        games.remove(aGame);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeGame(Game aGame)
  {
    boolean wasRemoved = false;
    if (!games.contains(aGame))
    {
      return wasRemoved;
    }

    int oldIndex = games.indexOf(aGame);
    games.remove(oldIndex);
    if (aGame.indexOfTuple(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aGame.removeTuple(this);
      if (!wasRemoved)
      {
        games.add(oldIndex,aGame);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGameAt(Game aGame, int index)
  {  
    boolean wasAdded = false;
    if(addGame(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGames()) { index = numberOfGames() - 1; }
      games.remove(aGame);
      games.add(index, aGame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameAt(Game aGame, int index)
  {
    boolean wasAdded = false;
    if(games.contains(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGames()) { index = numberOfGames() - 1; }
      games.remove(aGame);
      games.add(index, aGame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameAt(aGame, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Game> copyOfGames = new ArrayList<Game>(games);
    games.clear();
    for(Game aGame : copyOfGames)
    {
      aGame.removeTuple(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "murderer" + "=" + (getMurderer() != null ? !getMurderer().equals(this)  ? getMurderer().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "weapon" + "=" + (getWeapon() != null ? !getWeapon().equals(this)  ? getWeapon().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "crimeScene" + "=" + (getCrimeScene() != null ? !getCrimeScene().equals(this)  ? getCrimeScene().toString().replaceAll("  ","    ") : "this" : "null");
  }
}