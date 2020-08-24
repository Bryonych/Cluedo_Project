import java.awt.*;
import java.util.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI extends JFrame implements Observer{

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static Image hallway = new ImageIcon("Images/yellowsquare.png").getImage();
    private static Image wall = new ImageIcon("Images/wallimage.png").getImage();
    private static Image Ballroom = new ImageIcon("Images/Ballroom.png").getImage();
    private static Image billard = new ImageIcon("Images/billard.png").getImage();
    private static Image conservatory = new ImageIcon("Images/Conservatory.png").getImage();
    private static Image Kitchen = new ImageIcon("Images/kitchenImage.png").getImage();
    private static Image study = new ImageIcon("Images/Study.png").getImage();
    private static Image Hall = new ImageIcon("Images/Hall.png").getImage();
    private static Image dinningRoom = new ImageIcon("Images/Dinningroom.png").getImage();
    private static Image door = new ImageIcon("Images/doorway.png").getImage();
    private static Image Library = new ImageIcon("Images/Library.png").getImage();
    private static Image start = new ImageIcon("Images/Start.png").getImage();
    private Game game = null;
    
    Boolean characterSelected = false;
    Character tempChar;
    long now = System.currentTimeMillis();
    long timeCheck;

    public GUI(Game game){
        this.game = game;

    }
   
    	
    	
    

    public void display(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("Cluedo");
        setSize(WIDTH, HEIGHT);
        createMenu();
        
        
       // createBoardArea();
        setLocationRelativeTo(null);
        setVisible(true);
        
        addMouseListener(new MouseAdapter() {
        	public void mouseReleased(MouseEvent e) {
        		timeCheck = System.currentTimeMillis();
        		//only consider mouse events after 500 ms to reduce accidental multiple clicks
        		if((timeCheck - now) > 500) {
        			onClick(e);
        		}
        		now = System.currentTimeMillis();
        	}
        });
        
        this.addKeyListener(new KeyAdapter() {
        	boolean pressed = false;
        	
        	public void keyReleased(KeyEvent k) {
        		timeCheck = System.currentTimeMillis();
        		//only consider mouse events after 200 ms to reduce accidental multiple key presses
        			if((timeCheck - now) > 200) {
        				onKeyPress(k);
        			}
        			now = System.currentTimeMillis();
        	}
        });
        
        
    }

    public void update(Observable obs, Object obj){
        if (obs instanceof Game){
            display();
        }
        else {
            System.out.println("Error ");
        }
    }

    private JOptionPane textPane = new JOptionPane();
    private JButton quit = new JButton();
    private JMenuBar menu = new JMenuBar();
    private Container c = getContentPane();

    public void createMenu(){
        final JMenu mainMenu = new JMenu("Menu");

        final JMenuItem reset = new JMenuItem("Reset");

        menu.add(mainMenu);
        mainMenu.add(reset);

        setJMenuBar(menu);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                resetGame();
            }
        });
        c.add(menu, BorderLayout.NORTH);
    }

    public void resetGame(){
        this.game = new Game();
    }

    public void createBoardArea(){
        GridBagConstraints board = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        JLabel square = new JLabel("s");
        square.setBorder(new LineBorder(Color.BLUE));
        int[] columns = new int[29];
        Arrays.fill(columns, 10);
        gbl.columnWidths = columns;
        int[] rows = new int[29];
        Arrays.fill(rows, 10);
        gbl.rowHeights = rows;

        Cell[][] currentBoard = game.getBoard().getCells();
        board.fill = GridBagConstraints.BOTH;
        add(square, board);
    }

    public void addLabel(String text, GridBagConstraints board){
        JLabel label = new JLabel(text);
        label.setBorder(new LineBorder(Color.BLUE));
        add(label, board);
    }
    public void paint(Graphics g) {
    	super.paintComponents(g);
    	int count = 0;
    	//System.out.println(game.getBoard().toString());
    	Cell[][] c = game.getBoard().getCells();
    	Board board = new Board(c);
    	Cell[][] cc = board.getCells();
    	for(int i =0; i< 30; i++) {
    		for(int j = 0;j< 30; j++) {
    			if(cc[i][j].getType().equals(Cell.Type.HALLWAY)) {
    				g.drawImage(hallway, 50+(i*30), 50+(j*30), 25, 25, null);
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(new Color(254, 100, 25));
    				g.fillRect(x,y,25,25);
    			} 
    			if(cc[i][j].getType().equals(Cell.Type.WALL)) {
    				g.drawImage(wall, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.BALLROOM)) {
    				g.drawImage(Ballroom, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.KITCHEN)) {
    				g.drawImage(Kitchen, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.STUDY)) {
    				g.drawImage(study, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.CONSERVATORY)) {
    				g.drawImage(conservatory, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.BILLIARD)) {
    				g.drawImage(billard, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.DOOR)) {
    				g.drawImage(door, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.DINING)) {
    				g.drawImage(dinningRoom, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.HALL)) {
    				g.drawImage(Hall, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.LIBRARY)) {
    				g.drawImage(Library, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.START)) {
    				g.drawImage(start, 50+(i*30), 50+(j*30), 25, 25, null);
    			}
    			
    			if(cc[i][j].getType().equals(Cell.Type.WHITE)) {
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.WHITE);
    				g.fillOval(x,y,25,25);
    				g.setColor(Color.BLACK);
    				g.drawOval(x,y,25,25);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.GREEN)) {
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.GREEN);
    				g.fillOval(x,y,25,25);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.PEACOCK)) {
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.BLUE);
    				g.fillOval(x,y,25,25);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.PLUM)) {
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.MAGENTA);
    				g.fillOval(x,y,25,25);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.SCARLETT)) {
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.RED);
    				g.fillOval(x,y,25,25);
    			}
    			if(cc[i][j].getType().equals(Cell.Type.MUSTARD)) {
    				count++;
    				int x = 50 + (i * 30);
    				int y = 50 + (j * 30);
    				g.setColor(Color.YELLOW);
    				g.fillOval(x,y,25,25);
    				g.setColor(Color.BLACK);
    				g.drawOval(x,y,25,25);
    			}
    			//g.drawImage(sqaure, 50*i, 50*i, 25, 25, null);
    		}
    	}
    	System.out.println("Count = " + count);
    }
    

    public static void main(String[] args){
        Game game = new Game();
        GUI gui = new GUI(game);
        game.addObserver(gui);
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                gui.display();
            }
        });

    }
    
    protected void  onClick(MouseEvent e) {
    	Cell source = null;
    	Cell destination = null;
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	int indX = (mouseX - 50)/30;
    	int indY = (mouseY - 50)/30;
    	if(mouseX > 50 && mouseY > 50 && mouseX < 945 && mouseY < 945) {
    		Cell[][] cc = game.getBoard().getCells();
    		destination = cc[indX][indY];
    		game.moveCharacter(game.getCurrentChar(), destination);
    	}
    	
    }
    
    protected void onKeyPress(KeyEvent k) {
    	Cell currentCell = game.getCurrentChar().getLocation();
    	if(k.getKeyCode() == KeyEvent.VK_W) {
    		System.out.println("move up");
    		game.moveCharacter(game.getCurrentChar(), game.getBoard().getCells()[currentCell.getYPos() ][currentCell.getXPos() - 1]);
    	}
    	else if(k.getKeyCode() == KeyEvent.VK_A) {
    		System.out.println("move left");
    		game.moveCharacter(game.getCurrentChar(), game.getBoard().getCells()[currentCell.getYPos() - 1][currentCell.getXPos()]);
    	}
    	else if(k.getKeyCode() == KeyEvent.VK_S) {
    		game.moveCharacter(game.getCurrentChar(), game.getBoard().getCells()[currentCell.getYPos() ][currentCell.getXPos() + 1]);
    	}
    	else if(k.getKeyCode() == KeyEvent.VK_D) {
    		System.out.println("move right");
    		game.moveCharacter(game.getCurrentChar(), game.getBoard().getCells()[currentCell.getYPos() + 1][currentCell.getXPos()]);
    	}
    }
}


