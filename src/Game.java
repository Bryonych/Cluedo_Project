import java.awt.Point;
import java.io.IOException;
import java.util.*;

// line 2 "model.ump"
// line 109 "model.ump"
public class Game
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Game Attributes
    private static Board board;
    private int dice;
    private static List<Character> players = new ArrayList<Character>();
    private static List<Character> characters = new ArrayList<Character>();
    private List<Card> allCards = new ArrayList<Card>();
    private static List<CharacterCard> charCards = new ArrayList<CharacterCard>();
    private static List<RoomCard> roomCards = new ArrayList<RoomCard>();
    private static List<WeaponCard> weaponCards = new ArrayList<WeaponCard>();
    private static List<Room> rooms = new ArrayList<Room>();
    private static List<Weapon> weapons = new ArrayList<Weapon>();
    private Tuple murderDetails;
    private Character currentTurn;
    private static Tuple suggestion;
    private Card refute;
    private Tuple accusation;
    private boolean gameWon;
    private static int numPlayers;
    private static boolean suggestionMade = false;
    

    //Game Associations
    private List<Board> boards;
    private List<Tuple> tuples;

    //------------------------
    // CONSTRUCTOR
    //------------------------
    public Game(int numPlayers){
        board = createBoard();
        this.numPlayers = numPlayers;
        createRooms();
        createWeapons();
        setPlayers();
        createCards();
        murderDetails = setMurderDetails();
        dealCards();
    }

    /**
     * Creates the cells that make up the initial board
     * @return
     */
    public static Board createBoard(){
        int x = 30;
        int y = 30;
        Cell[][] squares = new Cell[x][y];
        for (int col = 0; col < x; col++){
            for (int row = 0; row < y; row++){
                if (row == 0 || row == 29 || col == 0 || col == 29){
                    squares[row][col] = new Cell(Cell.Type.WALL, col, row);
                }
                else if ((row < 8 && col == 7) || (row < 9 && col == 11) || (row < 9 && col == 18) || (row < 7 && col == 21)
                        || (row > 9 && row < 19 && col == 9) || (row > 8 && row < 16 && col == 21) || (row > 16 && row < 24 && col == 21)
                        || (row > 21 && col == 8) || (row > 20 && col == 11) || (row > 25 && col == 21)
                        || (row > 20 && col == 18)){

                    squares[row][col] = new Cell(Cell.Type.WALL, col, row);
                }
                else if ((row == 7 &&  col < 8) || (row == 8 && col > 10 && col < 19)|| (row == 6 && col > 21)
                        || (row == 10 && col < 10) || (row == 18 && col < 10) || (row == 9 && col > 21)
                        || (row == 15 && col > 21) || (row == 17 && col > 20) || (row == 23 && col > 20)
                        || (row == 22 && col < 9) || (row == 20 && col > 10 && col < 19) || (row == 26 && col > 20)){

                    squares[row][col] = new Cell(Cell.Type.WALL, col, row);
                }
                else if (row > 10 && row < 18 && col > 11 && col < 19){
                    squares[row][col] = new Cell(Cell.Type.WALL, col, row);
                }
                else if (row < 7 && col < 7){
                    squares[row][col] = new Cell(Cell.Type.KITCHEN, col, row);
                }
                else if (row < 8 && col > 12 && col < 17){
                    squares[row][col] = new Cell(Cell.Type.BALLROOM, col, row);
                }
                else if (row < 6 && col > 22){
                    squares[row][col] = new Cell(Cell.Type.CONSERVATORY, col, row);
                }
                else if (row > 10 && row < 18 && col < 9){
                    squares[row][col] = new Cell(Cell.Type.DINING, col, row);
                }
                else if (row > 9 && row < 15 && col > 22){
                    squares[row][col] = new Cell(Cell.Type.BILLIARD, col, row);
                }
                else if (row > 18 && row < 22 && col > 20){
                    squares[row][col] = new Cell(Cell.Type.LIBRARY, col, row);
                }
                else if (row > 22 && col < 8){
                    squares[row][col] = new Cell(Cell.Type.LOUNGE, col, row);
                }
                else if (row > 20 && col > 11 && col < 18){
                    squares[row][col] = new Cell(Cell.Type.HALL, col, row);
                }
                else if (row > 25 && col > 20){
                    squares[row][col] = new Cell(Cell.Type.STUDY, col, row);
                }
                else {
                    squares[row][col] = new Cell(Cell.Type.HALLWAY, col, row);
                }
            }
        }
        squares = setDoorsAndStart(squares);
        squares = setWeapons(squares);
        return new Board(squares);
    }

    /**
     * Sets doors and start cells in the walls
     * @param squares
     * @return
     */
    public static Cell[][] setDoorsAndStart(Cell[][] squares){

        squares[0][10].changeType(Cell.Type.WHITE);
        squares[0][19].changeType(Cell.Type.GREEN);
        squares[7][29].changeType(Cell.Type.PEACOCK);
        squares[20][0].changeType(Cell.Type.PLUM);
        squares[29][9].changeType(Cell.Type.SCARLETT);
        squares[24][29].changeType(Cell.Type.MUSTARD);
        squares[7][5].changeType(Cell.Type.DOOR);
        squares[5][11].changeType(Cell.Type.DOOR);
        squares[8][16].changeType(Cell.Type.DOOR);
        squares[5][18].changeType(Cell.Type.DOOR);
        squares[5][21].changeType(Cell.Type.DOOR);
        squares[13][9].changeType(Cell.Type.DOOR);
        squares[18][7].changeType(Cell.Type.DOOR);
        squares[11][21].changeType(Cell.Type.DOOR);
        squares[15][27].changeType(Cell.Type.DOOR);
        squares[17][25].changeType(Cell.Type.DOOR);
        squares[20][21].changeType(Cell.Type.DOOR);
        squares[22][7].changeType(Cell.Type.DOOR);
        squares[20][14].changeType(Cell.Type.DOOR);
        squares[20][15].changeType(Cell.Type.DOOR);
        squares[23][18].changeType(Cell.Type.DOOR);
        squares[26][22].changeType(Cell.Type.DOOR);
        return squares;

    }

    /**
     * Creates the Characters and players
     */
    public static void setPlayers(){
        int count = 1;
        Character white = new Character("Mrs White",  board.getCells()[0][10]);
        Character green = new Character("Mr Green", board.getCells()[0][19]);
        Character peacock = new Character("Mrs Peacock", board.getCells()[7][29]);
        Character plum = new Character("Prof Plum",board.getCells()[24][29]);
        Character scarlett = new Character("Miss Scarlet", board.getCells()[29][9]);
        Character mustard = new Character("Col Mustard", board.getCells()[20][0]);
        characters.add(white);
        characters.add(green);
        characters.add(peacock);
        characters.add(plum);
        characters.add(scarlett);
        characters.add(mustard);
        Stack<Character> CharacterSelection = new Stack<Character>();
        CharacterSelection.addAll(characters);
        int counter = numPlayers;
        while (counter != 0) {
            ArrayList<Character> temp = new ArrayList<Character>();
            temp.addAll(CharacterSelection);
            System.out.println("Player "+ count+ " Please Select Your Character");
            System.out.println("Please press Y for Yes, Any Other letter button to scroll next");
            Scanner scan;
            for(int i = 0; i < temp.size();) {
                System.out.println(temp.get(i).getName());
                scan = new Scanner(System.in);
                String read = scan.nextLine();
                if(read.contains("Y")) {
                    CharacterSelection.remove(temp.get(i));
                    players.add(temp.get(i));
                    counter--;
                    count++;
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * Creates all the rooms and sets the cell where the weapon sits in the room
     */
    public void createRooms(){
        rooms.add(new Room("Kitchen", board.getCells()[2][2], Cell.Type.KITCHEN));
        rooms.add(new Room("Ball Room", board.getCells()[2][14], Cell.Type.BALLROOM));
        rooms.add(new Room("Conservatory", board.getCells()[2][27], Cell.Type.CONSERVATORY));
        rooms.add(new Room("Dining Room", board.getCells()[13][2], Cell.Type.DINING));
        rooms.add(new Room("Billiard Room", board.getCells()[13][27], Cell.Type.BILLIARD));
        rooms.add(new Room("Library", board.getCells()[20][27], Cell.Type.LIBRARY));
        rooms.add(new Room("Lounge", board.getCells()[27][2], Cell.Type.LOUNGE));
        rooms.add(new Room("Hall", board.getCells()[27][14], Cell.Type.HALL));
        rooms.add(new Room("Study", board.getCells()[27][27], Cell.Type.STUDY));
    }

    public void createWeapons(){
        weapons.add(new Weapon("Candlestick", rooms.get(0), Cell.Type.CANDLESTICK));
        weapons.add(new Weapon("Dagger", rooms.get(1), Cell.Type.DAGGER));
        weapons.add(new Weapon("Lead Pipe", rooms.get(2), Cell.Type.LEADPIPE));
        weapons.add(new Weapon("Revolver", rooms.get(3), Cell.Type.REVOLVER));
        weapons.add(new Weapon("Rope", rooms.get(4), Cell.Type.ROPE));
        weapons.add(new Weapon("Spanner", rooms.get(5), Cell.Type.SPANNER));
    }
    /**
     * Creates the cards and adds them to the lists
     */
    public void createCards(){
        for (Character c : characters){
            CharacterCard newCard = new CharacterCard(c.getName());
            allCards.add(newCard);
            charCards.add(newCard);
        }
        RoomCard kitchen = new RoomCard("Kitchen");
        allCards.add(kitchen);
        roomCards.add(kitchen);
        RoomCard ballRoom = new RoomCard("Ball Room");
        allCards.add(ballRoom);
        roomCards.add(ballRoom);
        RoomCard conservatory = new RoomCard("Conservatory");
        allCards.add(conservatory);
        roomCards.add(conservatory);
        RoomCard dining = new RoomCard("Dining Room");
        allCards.add(dining);
        roomCards.add(dining);
        RoomCard billiard = new RoomCard("Billiard Room");
        allCards.add(billiard);
        roomCards.add(billiard);
        RoomCard library = new RoomCard("Library");
        allCards.add(library);
        roomCards.add(library);
        RoomCard lounge = new RoomCard("Lounge");
        allCards.add(lounge);
        roomCards.add(lounge);
        RoomCard hall = new RoomCard("Hall");
        allCards.add(hall);
        roomCards.add(hall);
        RoomCard study = new RoomCard("Study");
        allCards.add(study);
        roomCards.add(study);
        WeaponCard candlestick = new WeaponCard("Candlestick");
        allCards.add(candlestick);
        weaponCards.add(candlestick);
        WeaponCard dagger = new WeaponCard("Dagger");
        allCards.add(dagger);
        weaponCards.add(dagger);
        WeaponCard leadPipe = new WeaponCard("Lead Pipe");
        allCards.add(leadPipe);
        weaponCards.add(leadPipe);
        WeaponCard revolver = new WeaponCard("Revolver");
        allCards.add(revolver);
        weaponCards.add(revolver);
        WeaponCard rope = new WeaponCard("Rope");
        allCards.add(rope);
        weaponCards.add(rope);
        WeaponCard spanner = new WeaponCard("Spanner");
        allCards.add(spanner);
        weaponCards.add(spanner);
    }

    /**
     * Picks a random card from each list to be the murder details
     * @return
     */
    public Tuple setMurderDetails(){
        Random rand = new Random();
        CharacterCard murderer = charCards.get(rand.nextInt(charCards.size()));
        RoomCard scene = roomCards.get(rand.nextInt(roomCards.size()));
        WeaponCard weapon = weaponCards.get(rand.nextInt(weaponCards.size()));
        allCards.remove(murderer);
        allCards.remove(scene);
        allCards.remove(weapon);
        return new Tuple(murderer, weapon, scene);
    }

    /**
     * Suffles the remaining cards and deals them amongst the players
     */
    public void dealCards(){
        Collections.shuffle(allCards);
        for (int i = 0; i < numPlayers; i++){
            List newHand = new ArrayList<Card>();
            for (int j = i; j < allCards.size(); j+=numPlayers){
                newHand.add(allCards.get(j));
            }
            players.get(i).setHand(new Hand(newHand, players.get(i)));
        }
    }

    /**
     * Puts the weapon cells to have the weapons in them
     * @param squares
     * @return
     */
    public static Cell[][] setWeapons(Cell[][] squares){

        squares[2][2].changeType(Cell.Type.CANDLESTICK);
        squares[2][14].changeType(Cell.Type.DAGGER);
        squares[2][27].changeType(Cell.Type.LEADPIPE);
        squares[13][2].changeType(Cell.Type.REVOLVER);
        squares[13][27].changeType(Cell.Type.ROPE);
        squares[20][27].changeType(Cell.Type.SPANNER);
        return squares;
    }

    /**
     * Moves weapon from one room to another
     * @param moving
     * @param destination
     */
    public void moveWeapon(Weapon moving, Room destination){
        Room current = moving.getLocation();
        Cell moveFrom = current.getWeaponSpot();
        Cell moveTo = destination.getWeaponSpot();
        moveFrom.changeType(current.getType());
        moveTo.changeType(moving.getType());
        //redraw();
    }
    /**
     * Moves Chracter
     * @param moving
     * @param destination
     */
    public static void moveCharacter(Character moving, Cell destination){
        Cell current = moving.getLocation();
        Cell.Type oldRoom = moving.getCurrentRoom();
        Cell.Type character = moving.getCharacterType();
       System.out.println(moving.getCharacterType() + " " + oldRoom + " " + " " + destination.getType());
        moving.setCurrentRoom(destination.getType());
        current.changeType(oldRoom);
        destination.changeType(character);
        //redraw();
    }

    //Handled in GUI
//  public void printBoard(){
//    Cell[][] squares = board.getCells();
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < 30; i++){
//      if (i == 13){
//        sb.append("Dining ");
//      }
//      else if (i == 14){
//        sb.append("Room   ");
//      }
//      else {
//        sb.append("       ");
//      }
//      for (int j = 0; j < 30; j++){
//         sb.append(squares[i][j]);
//      }
//      if (i == 11){
//        sb.append(" Billiard");
//      }
//      else if (i == 12){
//        sb.append( " Room");
//      }
//      else if (i == 20){
//        sb.append(" Library");
//      }
//      if (i != 29) {
//        sb.append("\n");
//      }
//    }
//    System.out.println("         Kitchen               Ball Room           Conservatory");
//    System.out.println(sb);
//    System.out.println("         Lounge                Hall                Study");
//  }
    

    public static void main(String[] args) throws NumberFormatException, IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players?");
        numPlayers = scan.nextInt();
        Game game = new Game(numPlayers);
        System.out.flush();
        Cell[][] cell = board.getCells();
        int count = 0;
       // printBoard(cell); //Just printing the board
        for(Character play : players) {
            count++;
            System.out.println("Player " + count + " " + play.getName() + " Your Turn");
            //check if a suggestion has been made
            if(suggestionMade) {
            	System.out.println(suggestion.toString());
            	for(Card c : ((Suggestion) suggestion).getCards()) {
            		if(play.getHand().getCards().contains(c)) {
            			System.out.println("Would you like to refute with:\n" + c.toString());
            			Scanner refuteCheck = new Scanner(System.in);
            			System.out.println("y for yes, n for no.");
            			String response = refuteCheck.nextLine();
            			if(response.equalsIgnoreCase("y")) {
            				System.out.println("Suggestion refuted!");
            				suggestion = null;
            				suggestionMade = false;
            				break;
            			}
            		}
            	}
            }
           keyRead(1,play); //Just a temp move method
           printBoard(cell); //Just printing the board temp
        }
        
        
    }
    public static void printBoard(Cell[][] cell) {
        for(int i = 0; i < 30; i++) {
        	System.out.print(i + " \t");
            for(int j = 0; j < 30; j++) {
              //  System.out.print(cell[i][j].getType().toString() + " ");
            	System.out.print(cell[i][j] +" ");
            }
            System.out.println("");
        }
    }
    public static void keyRead(int n,Character play) {
    	System.out.println(n);
    	while(n != 0) {
    	Scanner scan = new Scanner(System.in);
    	String character = scan.nextLine();
    	List<Card> playerCards = play.getHand().getCards();
    	if(character.contains("w")) {
    		System.out.println(play.getLocation().getXPos() + " " + (play.getLocation().getYPos()+1));
    		 moveCharacter(play,new Cell(play.getCharacterType(),play.getLocation().getXPos(),play.getLocation().getYPos()+1));
    		 n--;	
    	}
    	//Temp condition to test out createSuggestion method
    	//final version to be triggered by room location
    	else if(character.contains("s")) {
    		createSuggestion(playerCards, play);
    		
    		n--;
    	}
    	}
    	
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

    public boolean removeTuple(Tuple tuple) {
		return gameWon;
        // TODO Auto-generated method stub

    }

	public int indexOfTuple(Tuple tuple) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean addTuple(Tuple tuple) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void createSuggestion(List<Card> playerCards, Character play) {
		CharacterCard sCharacter = null;
		WeaponCard sWeapon = null;
		RoomCard sRoom = null;
		List<CharacterCard> characterChoice = new ArrayList<CharacterCard>();
		List<WeaponCard> weaponChoice = new ArrayList<WeaponCard>();
		List<RoomCard> roomChoice = new ArrayList<RoomCard>();
		for(CharacterCard c: charCards) {
			if(c.hashCode() != play.hashCode() && !playerCards.contains(c)) {
				characterChoice.add(c);
			}
		}
		for(WeaponCard w: weaponCards) {
			if(!playerCards.contains(w)) {
				weaponChoice.add(w);
			}
		}
		
		for(RoomCard r: roomCards) {
			if(!playerCards.contains(r)) {
				roomChoice.add(r);
			}
		}
		
		System.out.println("Choose a character (enter number of character to choose):");
		int index = 1;
		for(CharacterCard c : characterChoice) {
			System.out.println(index + ". " + c.getName());
			index++;
		}
		Scanner scan2 = new Scanner(System.in);
		if(scan2.hasNextInt()) {
			sCharacter = characterChoice.get(scan2.nextInt() - 1);
			System.out.println(sCharacter.getName() + " was chosen.");
		}
		else {
			System.out.println("Use numbers to choose character.");
		}
		index = 1;
		System.out.println("Choose a character (enter number of weapon to choose):");
		for(WeaponCard w : weaponChoice) {
			System.out.println(index + ". " + w.getName());
			index++;
		}
		if(scan2.hasNextInt()) {
			sWeapon = weaponChoice.get(scan2.nextInt() - 1);
			System.out.println(sWeapon.getName() + " was chosen.");
		}
		else {
			System.out.println("Use numbers to choose weapon.");
		}
		
		index = 1;
		//temp code, room to be set by location of player
		System.out.println("Choose a character (enter number of room to choose):");
		for(RoomCard r : roomChoice) {
			System.out.println(index + ". " + r.getName());
			index++;
		}
		if(scan2.hasNextInt()) {
			sRoom = roomChoice.get(scan2.nextInt() - 1);
			System.out.println(sRoom.getName() + " is chosen.");
		}
		else {
			System.out.println("Use numbers to choose weapon.");
		}
		
		if(sCharacter != null && sWeapon != null && sRoom != null) {
			suggestion = new Suggestion((players.indexOf(play) + 1), sCharacter, sWeapon, sRoom);
			suggestionMade = true;
			System.out.println(suggestion.toString());
		}
		else {
			System.out.println("Error with suggestion!");
		}
	}
	
	public static void createSuggestion2(List<Card> playerCards, Character play) {
		
	}
}
