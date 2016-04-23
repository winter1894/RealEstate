import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Home.*;

/**
 * The RealEstate class is the core class of the entire program. 
 * It will handle window creation, painting, and button/clicking interaction.
 * @author Matthew
 *
 */
public class RealEstate extends Frame implements MouseListener{

	/**
	 * main; the starting point of the program.
	 * It simply creates a new RealEstate object.
	 * @param args
	 */
	public static void main(String[] args) {

		new RealEstate();
	}

	/**
	 * Initializes window closure use.
	 */
	private GoodBye window;

	/**
	 * x and y values for MouseListener methods.
	 */
	private int x, y;

	/**
	 * Initializes buttons that will be in the window.
	 */
	private Button cheapest, closest, house, apartment, oneBed, twoBed, threeBed, fourBed;

	/**
	 * Keeps track of what sorting buttons user selected.
	 */
	private boolean cheapestOn, closestOn;

	/**
	 * decision dictates user decision on house, apartment, or both.
	 */
	private int decision, sortType, bedNum;

	/**
	 * An array containing the choices sorted from the user's input,
	 * will be used when outputting information and images of residence.
	 */
	private double homes[][];

	/**
	 * Used for grabbing images from the Images class for painting to the window.
	 */
	private Images displayHomes;


	/**
	 * Sets up the window, along with a few objects present in the window.
	 */
	public RealEstate(){

		//Popup window specifications.
		setTitle("Real Estate");
		setSize(600, 800);
		setLocation(300,100);
		setBackground(Color.lightGray);

		//To allow for window closing by hitting x button.
		window = new GoodBye(); 
		addWindowListener(window); 

		addMouseListener(this);

		//Constants for use in button sizes.
		final int BUTTON_WIDTH=75, BUTTON_HEIGHT=30;

		cheapest=new Button("Low to High", Color.green, 
				500, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
		closest=new Button("Closest", Color.green, 
				500, 200+BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
		house=new Button("House", Color.yellow,
				500, 200+BUTTON_HEIGHT*2, BUTTON_WIDTH, BUTTON_HEIGHT);
		apartment=new Button("Apartment", Color.yellow,
				500, 200+BUTTON_HEIGHT*3, BUTTON_WIDTH, BUTTON_HEIGHT);

		oneBed=new Button("1 Bed", Color.orange, 
				500, 200-BUTTON_HEIGHT*2, BUTTON_WIDTH/2, BUTTON_HEIGHT);
		twoBed=new Button("2 Bed", Color.orange, 
				500+BUTTON_WIDTH/2, 200-BUTTON_HEIGHT*2, BUTTON_WIDTH/2, BUTTON_HEIGHT);
		threeBed=new Button("3 Bed", Color.orange, 
				500, 200-BUTTON_HEIGHT, BUTTON_WIDTH/2, BUTTON_HEIGHT);
		fourBed=new Button("4 Bed", Color.orange, 
				500+(BUTTON_WIDTH/2), 200-BUTTON_HEIGHT, BUTTON_WIDTH/2, BUTTON_HEIGHT);

		setVisible(true);
	}

	/**
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * When a button is clicked, depending on which button it was,
	 * RealEstate will rely off another module to complete an operation. 
	 */
	public void mouseClicked(MouseEvent e) {

		//Flips the oneBed button and flips other ones off.
		if(oneBed.isInside(x,y)){
			oneBed.flip();
			if(bedNum!=1){	
				if(bedNum==2){
					twoBed.flip();
				}
				else if(bedNum==3){
					threeBed.flip();
				}
				else if(bedNum==4){
					fourBed.flip();
				}	
				bedNum=1;
			}
			//If button already on, turns off user preference in bed number, all buttons off.
			else{
				bedNum=0;
			}
		}

		//Flips the twoBed button and flips other ones off.
		else if (twoBed.isInside(x,y)){
			twoBed.flip();
			if(bedNum!=2){	
				if(bedNum==1){
					oneBed.flip();
				}
				else if(bedNum==3){
					threeBed.flip();
				}
				else if(bedNum==4){
					fourBed.flip();
				}	
				bedNum=2;
			}
			//If button already on, turns off user preference in bed number, all buttons off.
			else{
				bedNum=0;
			}
		}

		//Flips the threeBed button and flips other ones off.
		else if(threeBed.isInside(x,y)){
			threeBed.flip();
			if(bedNum!=3){	
				if(bedNum==2){
					twoBed.flip();
				}
				else if(bedNum==1){
					oneBed.flip();
				}
				else if(bedNum==4){
					fourBed.flip();
				}	
				bedNum=3;
			}
			//If button already on, turns off user preference in bed number, all buttons off.
			else{
				bedNum=0;
			}
		}

		//Flips the fourBed button and flips other ones off.
		else if(fourBed.isInside(x,y)){
			fourBed.flip();
			if(bedNum!=4){	
				if(bedNum==2){
					twoBed.flip();
				}
				else if(bedNum==3){
					threeBed.flip();
				}
				else if(bedNum==1){
					oneBed.flip();
				}	
				bedNum=4;
			}
			//If button already on, turns off user preference in bed number, all buttons off.
			else{
				bedNum=0;
			}
		}

		if(cheapest.isInside(x, y)){

			//If it is already on it will stay on and won't flip/repaint.
			if (cheapestOn!=true){
				cheapest.flip();
				cheapestOn=true;

				//If another sorting button is on, turns it off.
				if (closestOn==true){
					closest.flip();
					closestOn=false;
				}
			}
		}
		else if(closest.isInside(x,y)){

			//If it is already on it will stay on and won't flip.
			if(closestOn!=true){
				closest.flip();
				closestOn=true;
				//If another sorting button is on, turns it off.
				if (cheapestOn==true){
					cheapest.flip();
					cheapestOn=false;
				}
			}
		}
		else if(house.isInside(x,y)){

			house.flip();
			//Turns off apartment button glowing if on.
			if (decision==2){
				decision=1;
				apartment.flip();
			}
			//If user wants to see both apartment and houses again.
			else if (decision==1){
				decision=0;
			}
			//defaults to just turning house only on.
			else {
				decision=1;
			}
		}
		else if(apartment.isInside(x,y)){

			apartment.flip();
			//Turns off apartment button glowing if on.
			if (decision==1){
				decision=2;
				house.flip();
			}
			//If user wants to see both apartment and houses again.
			else if (decision==2){
				decision=0;
			}
			//defaults to just turning apartment only on.
			else {
				decision=2;
			}
		}

		repaint();
		values();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		//Mouse press gives x coordinate.
		x = e.getX(); 
		//Mouse press gives y coordinate.
		y = e.getY(); 

	}

	/** 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 * For buttons that do not remain on after the button release,
	 * this method will return it to it's normal state.
	 */
	public void mouseReleased(MouseEvent e){

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Takes the values from the buttons and resolves an output by sending them to 
	 * particular methods to carry out sorting, calculations, etc.
	 */
	private void values(){

		if (closestOn==true || cheapestOn==true){

			/*Gives sortType an integer value to differentiate what sort
			 * the user wants to do.
			 */
			if (cheapestOn==true){
				sortType=1;
			}
			else if (closestOn==true){
				sortType=2;
			}

			//Begins searching for proper arrays of residence based off user choice of residence.
			if (decision==0){
				Residence residence=new Residence(bedNum);
				homes=residence.returnArray();
			}

			if (decision==1){
				if(bedNum==1){
					warningMessage("There are no houses with only one bedroom!");
				}
				else{
					House house=new House(bedNum);
					homes=house.returnArray();	
				}
			}
			else if (decision==2){
				if(bedNum>2){
					warningMessage("There are no apartments with more than two bedrooms!");
				}
				else{
					Apartment apartment=new Apartment(bedNum);
					homes=apartment.returnArray();
				}
			}

			/*Sends the user's decided sorting order as well as home array
			 * to Sorting class.
			 */
			Sorting sorting=new Sorting(sortType, homes);
			homes=sorting.returnSorted();

			//Each of these grab the respective picture for bestFive array.
			displayHomes=new Images(homes);
		}
	}

	/**
	 * Everything that needs to be drawn goes here to 
	 * appear in the window.
	 */
	public void paint(Graphics pane){

		cheapest.paint(pane);
		closest.paint(pane);
		house.paint(pane);
		apartment.paint(pane);

		oneBed.paint(pane);
		twoBed.paint(pane);
		threeBed.paint(pane);
		fourBed.paint(pane);

		/*
		 * If there is an error when the user chooses an option that does not exist,
		 * it will ignore the error so the program can continue running with ease.
		 */
		try{
			displayHomes.paint(pane);
		}
		catch(NullPointerException e){
		}	
	}

	/**
	 * Shows a dialog box with a warning
	 * @param message the warning message to be shown
	 */
	private void warningMessage(String message){
		JFrame frame = new JFrame("");
		JOptionPane.showMessageDialog(frame,
				message, "Warning!!!", JOptionPane.WARNING_MESSAGE);
	}
}
