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
  private List<Character> players = new ArrayList<Character>();
  private List<Character> characters = new ArrayList<Character>();
  private Tuple murderDetails;
  private Character currentTurn;
  private Tuple suggestion;
  private Card refute;
  private Tuple accusation;
  private boolean gameWon;
  private int numPlayers;

  //Game Associations
  private List<Board> boards;
  private List<Tuple> tuples;
  private List<Card> cards;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  public Game(){
      this.board = createBoard();
      this.numPlayers = getNumPlayers();
      setPlayers();
  }

  public Board createBoard(){
    int x = 30;
    int y = 30;
    Cell[][] squares = new Cell[x][y];
    for (int col = 0; col < x; col++){
      for (int row = 0; row < y; row++){
        if (row == 0 || row == 29 || col == 0 || col == 29){
          squares[row][col] = new Cell(Cell.Room.WALL, col, row);
        }
        else if ((row < 8 && col == 7) || (row < 9 && col == 11) || (row < 9 && col == 18) || (row < 7 && col == 21)
          || (row > 9 && row < 19 && col == 9) || (row > 8 && row < 16 && col == 21) || (row > 16 && row < 24 && col == 21)
          || (row > 21 && col == 8) || (row > 20 && col == 11) || (row > 25 && col == 21)
          || (row > 20 && col == 18)){

          squares[row][col] = new Cell(Cell.Room.WALL, col, row);
        }
        else if ((row == 7 &&  col < 8) || (row == 8 && col > 10 && col < 19)|| (row == 6 && col > 21)
          || (row == 10 && col < 10) || (row == 18 && col < 10) || (row == 9 && col > 21)
          || (row == 15 && col > 21) || (row == 17 && col > 20) || (row == 23 && col > 20)
          || (row == 22 && col < 9) || (row == 20 && col > 10 && col < 19) || (row == 26 && col > 20)){

          squares[row][col] = new Cell(Cell.Room.WALL, col, row);
        }
        else if (row > 10 && row < 18 && col > 11 && col < 19){
          squares[row][col] = new Cell(Cell.Room.WALL, col, row);
        }
        else if (row < 7 && col < 7){
          squares[row][col] = new Cell(Cell.Room.KITCHEN, col, row);
        }
        else if (row < 8 && col > 12 && col < 17){
          squares[row][col] = new Cell(Cell.Room.BALLROOM, col, row);
        }
        else if (row < 6 && col > 22){
          squares[row][col] = new Cell(Cell.Room.CONSERVATORY, col, row);
        }
        else if (row > 10 && row < 18 && col < 9){
          squares[row][col] = new Cell(Cell.Room.DINING, col, row);
        }
        else if (row > 9 && row < 15 && col > 22){
          squares[row][col] = new Cell(Cell.Room.BILLIARD, col, row);
        }
        else if (row > 18 && row < 22 && col > 20){
          squares[row][col] = new Cell(Cell.Room.LIBRARY, col, row);
        }
        else if (row > 22 && col < 8){
          squares[row][col] = new Cell(Cell.Room.LOUNGE, col, row);
        }
        else if (row > 20 && col > 11 && col < 18){
          squares[row][col] = new Cell(Cell.Room.HALL, col, row);
        }
        else if (row > 25 && col > 20){
          squares[row][col] = new Cell(Cell.Room.STUDY, col, row);
        }
        else {
          squares[row][col] = new Cell(Cell.Room.HALLWAY, col, row);
        }
      }
    }
    squares = setDoorsAndStart(squares);
    return new Board(squares);
  }

  public Cell[][] setDoorsAndStart(Cell[][] squares){

    squares[0][10].changeType(Cell.Room.WHITE);
    squares[0][19].changeType(Cell.Room.GREEN);
    squares[7][29].changeType(Cell.Room.PEACOCK);
    squares[20][0].changeType(Cell.Room.PLUM);
    squares[29][9].changeType(Cell.Room.SCARLETT);
    squares[24][29].changeType(Cell.Room.MUSTARD);
    squares[7][5].changeType(Cell.Room.DOOR);
    squares[5][11].changeType(Cell.Room.DOOR);
    squares[8][16].changeType(Cell.Room.DOOR);
    squares[5][18].changeType(Cell.Room.DOOR);
    squares[5][21].changeType(Cell.Room.DOOR);
    squares[13][9].changeType(Cell.Room.DOOR);
    squares[18][7].changeType(Cell.Room.DOOR);
    squares[11][21].changeType(Cell.Room.DOOR);
    squares[15][27].changeType(Cell.Room.DOOR);
    squares[17][25].changeType(Cell.Room.DOOR);
    squares[20][21].changeType(Cell.Room.DOOR);
    squares[22][7].changeType(Cell.Room.DOOR);
    squares[20][14].changeType(Cell.Room.DOOR);
    squares[20][15].changeType(Cell.Room.DOOR);
    squares[23][18].changeType(Cell.Room.DOOR);
    squares[26][22].changeType(Cell.Room.DOOR);
    return squares;

  }

  public int getNumPlayers(){

    Scanner sc = new Scanner(System.in);
    System.out.println("How many players?");
    int answer = 0;
    try {
      answer = sc.nextInt();
    } catch(InputMismatchException e) { System.out.println("Invalid number"); }
    if (answer < 2){
      System.out.println("Number of players needs to be 2-6");
      getNumPlayers();
    }
    return answer;
  }

  public void setPlayers(){
    Character white = new Character("Mrs White", board.getCells()[0][10]);
    Character green = new Character("Mr Green", board.getCells()[0][19]);
    Character peacock = new Character("Mrs Peacock", board.getCells()[7][29]);
    Character plum = new Character("Prof Plum", board.getCells()[24][29]);
    Character scarlett = new Character("Miss Scarlet", board.getCells()[29][9]);
    Character mustard = new Character("Col Mustard", board.getCells()[20][0]);
    characters.add(white);
    characters.add(green);
    characters.add(peacock);
    characters.add(plum);
    characters.add(scarlett);
    characters.add(mustard);
    for (int i = 0; i < numPlayers; i++){
      players.add(characters.get(i));
    }

  }

  public void printBoard(){
    Cell[][] squares = board.getCells();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 30; i++){
      if (i == 13){
        sb.append("Dining ");
      }
      else if (i == 14){
        sb.append("Room   ");
      }
      else {
        sb.append("       ");
      }
      for (int j = 0; j < 30; j++){
         sb.append(squares[i][j]);
      }
      if (i == 11){
        sb.append(" Billiard");
      }
      else if (i == 12){
        sb.append( " Room");
      }
      else if (i == 20){
        sb.append(" Library");
      }
      if (i != 29) {
        sb.append("\n");
      }
    }
    System.out.println("         Kitchen               Ball Room           Conservatory");
    System.out.println(sb);
    System.out.println("         Lounge                Hall                Study");
  }

  public static void main(String[] args){
    Game game = new Game();
    game.printBoard();
  }

  //------------------------
  // INTERFACE
  //------------------------



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