/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5074.a43557235 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 109 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private Board board;
  private int dice;
  private List players;
  private Tuple murderDetails;
  private Character currentTurn;
  private Tuple suggestion;
  private Card refute;
  private Tuple accusation;
  private boolean gameWon;

  //Game Associations
  private List<Board> boards;
  private List<Tuple> tuples;
  private List<Card> cards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(Board aBoard, int aDice, List aPlayers, Tuple aMurderDetails, Character aCurrentTurn, Tuple aSuggestion, Card aRefute, Tuple aAccusation, boolean aGameWon)
  {
    board = aBoard;
    dice = aDice;
    players = aPlayers;
    murderDetails = aMurderDetails;
    currentTurn = aCurrentTurn;
    suggestion = aSuggestion;
    refute = aRefute;
    accusation = aAccusation;
    gameWon = aGameWon;
    boards = new ArrayList<Board>();
    tuples = new ArrayList<Tuple>();
    cards = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    board = aBoard;
    wasSet = true;
    return wasSet;
  }

  public boolean setDice(int aDice)
  {
    boolean wasSet = false;
    dice = aDice;
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

  public boolean setMurderDetails(Tuple aMurderDetails)
  {
    boolean wasSet = false;
    murderDetails = aMurderDetails;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentTurn(Character aCurrentTurn)
  {
    boolean wasSet = false;
    currentTurn = aCurrentTurn;
    wasSet = true;
    return wasSet;
  }

  public boolean setSuggestion(Tuple aSuggestion)
  {
    boolean wasSet = false;
    suggestion = aSuggestion;
    wasSet = true;
    return wasSet;
  }

  public boolean setRefute(Card aRefute)
  {
    boolean wasSet = false;
    refute = aRefute;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccusation(Tuple aAccusation)
  {
    boolean wasSet = false;
    accusation = aAccusation;
    wasSet = true;
    return wasSet;
  }

  public boolean setGameWon(boolean aGameWon)
  {
    boolean wasSet = false;
    gameWon = aGameWon;
    wasSet = true;
    return wasSet;
  }

  public Board getBoard()
  {
    return board;
  }

  public int getDice()
  {
    return dice;
  }

  public List getPlayers()
  {
    return players;
  }

  public Tuple getMurderDetails()
  {
    return murderDetails;
  }

  public Character getCurrentTurn()
  {
    return currentTurn;
  }

  public Tuple getSuggestion()
  {
    return suggestion;
  }

  public Card getRefute()
  {
    return refute;
  }

  public Tuple getAccusation()
  {
    return accusation;
  }

  public boolean getGameWon()
  {
    return gameWon;
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
  /* Code from template association_GetMany */
  public Tuple getTuple(int index)
  {
    Tuple aTuple = tuples.get(index);
    return aTuple;
  }

  public List<Tuple> getTuples()
  {
    List<Tuple> newTuples = Collections.unmodifiableList(tuples);
    return newTuples;
  }

  public int numberOfTuples()
  {
    int number = tuples.size();
    return number;
  }

  public boolean hasTuples()
  {
    boolean has = tuples.size() > 0;
    return has;
  }

  public int indexOfTuple(Tuple aTuple)
  {
    int index = tuples.indexOf(aTuple);
    return index;
  }
  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoards()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Board addBoard(List aItems, List aPlayers, Room[] allRooms, Weapon[] allWeapons, Character[] allCharacters)
  {
    return new Board(aItems, aPlayers, this, allRooms, allWeapons, allCharacters);
  }

  public boolean addBoard(Board aBoard)
  {
    boolean wasAdded = false;
    if (boards.contains(aBoard)) { return false; }
    Game existingGame = aBoard.getGame();
    boolean isNewGame = existingGame != null && !this.equals(existingGame);
    if (isNewGame)
    {
      aBoard.setGame(this);
    }
    else
    {
      boards.add(aBoard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBoard(Board aBoard)
  {
    boolean wasRemoved = false;
    //Unable to remove aBoard, as it must always have a game
    if (!this.equals(aBoard.getGame()))
    {
      boards.remove(aBoard);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTuples()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTuple(Tuple aTuple)
  {
    boolean wasAdded = false;
    if (tuples.contains(aTuple)) { return false; }
    tuples.add(aTuple);
    if (aTuple.indexOfGame(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTuple.addGame(this);
      if (!wasAdded)
      {
        tuples.remove(aTuple);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTuple(Tuple aTuple)
  {
    boolean wasRemoved = false;
    if (!tuples.contains(aTuple))
    {
      return wasRemoved;
    }

    int oldIndex = tuples.indexOf(aTuple);
    tuples.remove(oldIndex);
    if (aTuple.indexOfGame(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTuple.removeGame(this);
      if (!wasRemoved)
      {
        tuples.add(oldIndex,aTuple);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTupleAt(Tuple aTuple, int index)
  {  
    boolean wasAdded = false;
    if(addTuple(aTuple))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTuples()) { index = numberOfTuples() - 1; }
      tuples.remove(aTuple);
      tuples.add(index, aTuple);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTupleAt(Tuple aTuple, int index)
  {
    boolean wasAdded = false;
    if(tuples.contains(aTuple))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTuples()) { index = numberOfTuples() - 1; }
      tuples.remove(aTuple);
      tuples.add(index, aTuple);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTupleAt(aTuple, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCardsValid()
  {
    boolean isValid = numberOfCards() >= minimumNumberOfCards() && numberOfCards() <= maximumNumberOfCards();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_AddMNToOnlyOne */
  public Card addCard()
  {
    if (numberOfCards() >= maximumNumberOfCards())
    {
      return null;
    }
    else
    {
      return new Card(this);
    }
  }

  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    if (numberOfCards() >= maximumNumberOfCards())
    {
      return wasAdded;
    }

    Game existingGame = aCard.getGame();
    boolean isNewGame = existingGame != null && !this.equals(existingGame);

    if (isNewGame && existingGame.numberOfCards() <= minimumNumberOfCards())
    {
      return wasAdded;
    }

    if (isNewGame)
    {
      aCard.setGame(this);
    }
    else
    {
      cards.add(aCard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    //Unable to remove aCard, as it must always have a game
    if (this.equals(aCard.getGame()))
    {
      return wasRemoved;
    }

    //game already at minimum (21)
    if (numberOfCards() <= minimumNumberOfCards())
    {
      return wasRemoved;
    }
    cards.remove(aCard);
    wasRemoved = true;
    return wasRemoved;
  }

  public void delete()
  {
    for(int i=boards.size(); i > 0; i--)
    {
      Board aBoard = boards.get(i - 1);
      aBoard.delete();
    }
    ArrayList<Tuple> copyOfTuples = new ArrayList<Tuple>(tuples);
    tuples.clear();
    for(Tuple aTuple : copyOfTuples)
    {
      aTuple.removeGame(this);
    }
    for(int i=cards.size(); i > 0; i--)
    {
      Card aCard = cards.get(i - 1);
      aCard.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "dice" + ":" + getDice()+ "," +
            "currentTurn" + ":" + getCurrentTurn()+ "," +
            "gameWon" + ":" + getGameWon()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "board" + "=" + (getBoard() != null ? !getBoard().equals(this)  ? getBoard().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "players" + "=" + (getPlayers() != null ? !getPlayers().equals(this)  ? getPlayers().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "murderDetails" + "=" + (getMurderDetails() != null ? !getMurderDetails().equals(this)  ? getMurderDetails().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "suggestion" + "=" + (getSuggestion() != null ? !getSuggestion().equals(this)  ? getSuggestion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "refute" + "=" + (getRefute() != null ? !getRefute().equals(this)  ? getRefute().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "accusation" + "=" + (getAccusation() != null ? !getAccusation().equals(this)  ? getAccusation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}