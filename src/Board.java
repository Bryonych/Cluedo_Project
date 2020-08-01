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
  private List<Cell> squares;
  private List items;
  private List players;

  //Board Associations
  private List<Cell> contains;
  private List<Room> rooms;
  private List<Weapon> weapons;
  private List<Character> characters;
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(List aItems, List aPlayers, Game aGame, Room[] allRooms, Weapon[] allWeapons, Character[] allCharacters)
  {
    squares = new ArrayList<Cell>();
    items = aItems;
    players = aPlayers;
    contains = new ArrayList<Cell>();
    rooms = new ArrayList<Room>();
    boolean didAddRooms = setRooms(allRooms);
    if (!didAddRooms)
    {
      throw new RuntimeException("Unable to create Board, must have 9 rooms. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    weapons = new ArrayList<Weapon>();
    boolean didAddWeapons = setWeapons(allWeapons);
    if (!didAddWeapons)
    {
      throw new RuntimeException("Unable to create Board, must have 6 weapons. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    characters = new ArrayList<Character>();
    boolean didAddCharacters = setCharacters(allCharacters);
    if (!didAddCharacters)
    {
      throw new RuntimeException("Unable to create Board, must have 6 characters. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create board due to game. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
  public boolean addSquare(Cell aSquare)
  {
    boolean wasAdded = false;
    wasAdded = squares.add(aSquare);
    return wasAdded;
  }

  public boolean removeSquare(Cell aSquare)
  {
    boolean wasRemoved = false;
    wasRemoved = squares.remove(aSquare);
    return wasRemoved;
  }

  public boolean setItems(List aItems)
  {
    boolean wasSet = false;
    items = aItems;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayers(List aPlayers)
  {
    boolean wasSet = false;
    players = aPlayers;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_GetMany */
  public Cell getSquare(int index)
  {
    Cell aSquare = squares.get(index);
    return aSquare;
  }

  public Cell[] getSquares()
  {
    Cell[] newSquares = squares.toArray(new Cell[squares.size()]);
    return newSquares;
  }

  public int numberOfSquares()
  {
    int number = squares.size();
    return number;
  }

  public boolean hasSquares()
  {
    boolean has = squares.size() > 0;
    return has;
  }

  public int indexOfSquare(Cell aSquare)
  {
    int index = squares.indexOf(aSquare);
    return index;
  }

  public List getItems()
  {
    return items;
  }

  public List getPlayers()
  {
    return players;
  }
  /* Code from template association_GetMany */
  public Cell getContain(int index)
  {
    Cell aContain = contains.get(index);
    return aContain;
  }

  public List<Cell> getContains()
  {
    List<Cell> newContains = Collections.unmodifiableList(contains);
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

  public int indexOfContain(Cell aContain)
  {
    int index = contains.indexOf(aContain);
    return index;
  }
  /* Code from template association_GetMany */
  public Room getRoom(int index)
  {
    Room aRoom = rooms.get(index);
    return aRoom;
  }

  public List<Room> getRooms()
  {
    List<Room> newRooms = Collections.unmodifiableList(rooms);
    return newRooms;
  }

  public int numberOfRooms()
  {
    int number = rooms.size();
    return number;
  }

  public boolean hasRooms()
  {
    boolean has = rooms.size() > 0;
    return has;
  }

  public int indexOfRoom(Room aRoom)
  {
    int index = rooms.indexOf(aRoom);
    return index;
  }
  /* Code from template association_GetMany */
  public Weapon getWeapon(int index)
  {
    Weapon aWeapon = weapons.get(index);
    return aWeapon;
  }

  public List<Weapon> getWeapons()
  {
    List<Weapon> newWeapons = Collections.unmodifiableList(weapons);
    return newWeapons;
  }

  public int numberOfWeapons()
  {
    int number = weapons.size();
    return number;
  }

  public boolean hasWeapons()
  {
    boolean has = weapons.size() > 0;
    return has;
  }

  public int indexOfWeapon(Weapon aWeapon)
  {
    int index = weapons.indexOf(aWeapon);
    return index;
  }
  /* Code from template association_GetMany */
  public Character getCharacter(int index)
  {
    Character aCharacter = characters.get(index);
    return aCharacter;
  }

  public List<Character> getCharacters()
  {
    List<Character> newCharacters = Collections.unmodifiableList(characters);
    return newCharacters;
  }

  public int numberOfCharacters()
  {
    int number = characters.size();
    return number;
  }

  public boolean hasCharacters()
  {
    boolean has = characters.size() > 0;
    return has;
  }

  public int indexOfCharacter(Character aCharacter)
  {
    int index = characters.indexOf(aCharacter);
    return index;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfContains()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addContain(Cell aContain)
  {
    boolean wasAdded = false;
    if (contains.contains(aContain)) { return false; }
    contains.add(aContain);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeContain(Cell aContain)
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
  public boolean addContainAt(Cell aContain, int index)
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

  public boolean addOrMoveContainAt(Cell aContain, int index)
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
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfRooms()
  {
    return 9;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRooms()
  {
    return 9;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfRooms()
  {
    return 9;
  }
  /* Code from template association_SetUnidirectionalN */
  public boolean setRooms(Room... newRooms)
  {
    boolean wasSet = false;
    ArrayList<Room> verifiedRooms = new ArrayList<Room>();
    for (Room aRoom : newRooms)
    {
      if (verifiedRooms.contains(aRoom))
      {
        continue;
      }
      verifiedRooms.add(aRoom);
    }

    if (verifiedRooms.size() != newRooms.length || verifiedRooms.size() != requiredNumberOfRooms())
    {
      return wasSet;
    }

    rooms.clear();
    rooms.addAll(verifiedRooms);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfWeaponsValid()
  {
    boolean isValid = numberOfWeapons() >= minimumNumberOfWeapons() && numberOfWeapons() <= maximumNumberOfWeapons();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfWeapons()
  {
    return 6;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWeapons()
  {
    return 6;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfWeapons()
  {
    return 6;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addWeapon(Weapon aWeapon)
  {
    boolean wasAdded = false;
    if (weapons.contains(aWeapon)) { return false; }
    if (numberOfWeapons() >= maximumNumberOfWeapons())
    {
      return wasAdded;
    }

    weapons.add(aWeapon);
    if (aWeapon.indexOfBoard(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aWeapon.addBoard(this);
      if (!wasAdded)
      {
        weapons.remove(aWeapon);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeWeapon(Weapon aWeapon)
  {
    boolean wasRemoved = false;
    if (!weapons.contains(aWeapon))
    {
      return wasRemoved;
    }

    if (numberOfWeapons() <= minimumNumberOfWeapons())
    {
      return wasRemoved;
    }

    int oldIndex = weapons.indexOf(aWeapon);
    weapons.remove(oldIndex);
    if (aWeapon.indexOfBoard(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aWeapon.removeBoard(this);
      if (!wasRemoved)
      {
        weapons.add(oldIndex,aWeapon);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setWeapons(Weapon... newWeapons)
  {
    boolean wasSet = false;
    ArrayList<Weapon> verifiedWeapons = new ArrayList<Weapon>();
    for (Weapon aWeapon : newWeapons)
    {
      if (verifiedWeapons.contains(aWeapon))
      {
        continue;
      }
      verifiedWeapons.add(aWeapon);
    }

    if (verifiedWeapons.size() != newWeapons.length || verifiedWeapons.size() < minimumNumberOfWeapons() || verifiedWeapons.size() > maximumNumberOfWeapons())
    {
      return wasSet;
    }

    ArrayList<Weapon> oldWeapons = new ArrayList<Weapon>(weapons);
    weapons.clear();
    for (Weapon aNewWeapon : verifiedWeapons)
    {
      weapons.add(aNewWeapon);
      if (oldWeapons.contains(aNewWeapon))
      {
        oldWeapons.remove(aNewWeapon);
      }
      else
      {
        aNewWeapon.addBoard(this);
      }
    }

    for (Weapon anOldWeapon : oldWeapons)
    {
      anOldWeapon.removeBoard(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCharactersValid()
  {
    boolean isValid = numberOfCharacters() >= minimumNumberOfCharacters() && numberOfCharacters() <= maximumNumberOfCharacters();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCharacters()
  {
    return 6;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCharacters()
  {
    return 6;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCharacters()
  {
    return 6;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCharacter(Character aCharacter)
  {
    boolean wasAdded = false;
    if (characters.contains(aCharacter)) { return false; }
    if (numberOfCharacters() >= maximumNumberOfCharacters())
    {
      return wasAdded;
    }

    characters.add(aCharacter);
    if (aCharacter.indexOfBoard(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCharacter.addBoard(this);
      if (!wasAdded)
      {
        characters.remove(aCharacter);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeCharacter(Character aCharacter)
  {
    boolean wasRemoved = false;
    if (!characters.contains(aCharacter))
    {
      return wasRemoved;
    }

    if (numberOfCharacters() <= minimumNumberOfCharacters())
    {
      return wasRemoved;
    }

    int oldIndex = characters.indexOf(aCharacter);
    characters.remove(oldIndex);
    if (aCharacter.indexOfBoard(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCharacter.removeBoard(this);
      if (!wasRemoved)
      {
        characters.add(oldIndex,aCharacter);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setCharacters(Character... newCharacters)
  {
    boolean wasSet = false;
    ArrayList<Character> verifiedCharacters = new ArrayList<Character>();
    for (Character aCharacter : newCharacters)
    {
      if (verifiedCharacters.contains(aCharacter))
      {
        continue;
      }
      verifiedCharacters.add(aCharacter);
    }

    if (verifiedCharacters.size() != newCharacters.length || verifiedCharacters.size() < minimumNumberOfCharacters() || verifiedCharacters.size() > maximumNumberOfCharacters())
    {
      return wasSet;
    }

    ArrayList<Character> oldCharacters = new ArrayList<Character>(characters);
    characters.clear();
    for (Character aNewCharacter : verifiedCharacters)
    {
      characters.add(aNewCharacter);
      if (oldCharacters.contains(aNewCharacter))
      {
        oldCharacters.remove(aNewCharacter);
      }
      else
      {
        aNewCharacter.addBoard(this);
      }
    }

    for (Character anOldCharacter : oldCharacters)
    {
      anOldCharacter.removeBoard(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    if (aGame == null)
    {
      return wasSet;
    }

    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      existingGame.removeBoard(this);
    }
    game.addBoard(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    contains.clear();
    rooms.clear();
    ArrayList<Weapon> copyOfWeapons = new ArrayList<Weapon>(weapons);
    weapons.clear();
    for(Weapon aWeapon : copyOfWeapons)
    {
      aWeapon.removeBoard(this);
    }
    ArrayList<Character> copyOfCharacters = new ArrayList<Character>(characters);
    characters.clear();
    for(Character aCharacter : copyOfCharacters)
    {
      aCharacter.removeBoard(this);
    }
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removeBoard(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "items" + "=" + (getItems() != null ? !getItems().equals(this)  ? getItems().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "players" + "=" + (getPlayers() != null ? !getPlayers().equals(this)  ? getPlayers().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}