import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * Shows pictures of the houses/apartment options that come up.
 * (*NOTE: Right now this comes up in a separate window. Parts of this class
 * may be recycled into another part of the program).
 * @author Matthew
 */
public class Images extends Component{

	/**
	 * Creates an object of an image file already stored outside of the
	 * src folder.
	 */
	private BufferedImage tempImage, imgOne, imgTwo, imgThree, imgFour, imgFive;

	/**
	 * Temporarily stores a String about the home's address for later storage.
	 */
	private String tempText;

	/**
	 * An array of strings full of information describing the first (best) option.
	 */
	private String[] textOne=new String[5];
	/**
	 * An array of strings full of information describing the second option.
	 */
	private String[] textTwo=new String[5];
	/**
	 * An array of strings full of information describing the third option.
	 */
	private String[] textThree=new String[5];
	/**
	 * An array of strings full of information describing the fourth option.
	 */
	private String[] textFour=new String[5];
	/**
	 * An array of strings full of information describing the fifth option.
	 */
	private String[] textFive=new String[5];

	/**
	 * Carried over from RealEstate to display the images
	 * and information of the top five results.
	 */
	private double [][] homes;

	/**
	 * Takes in the pixel ratios from the actual picture files for use in scaling.
	 */
	private double imageWidthOne, imageHeightOne, imageWidthTwo, imageHeightTwo,
	imageWidthThree, imageHeightThree, imageWidthFour, imageHeightFour, imageWidthFive, imageHeightFive;

	/**
	 * Default constructor for Images.
	 */
	public Images(){

		setImages();
	}

	/**
	 * This constructor takes in the value of the array home for
	 * picture and information display.
	 * @param homes
	 */
	public Images(double [][]homes){

		this.homes=homes;
		setImages();
	}

	/**
	 * Controls the storage of the pictures and when they will be accessed.
	 */
	private void setImages(){

		//Used temporarily to simplify switch statement during picture selection.
		int num=0;

		//Runs through bestFive to connect the proper residence ID to the correct picture.
		for(int i=0; i<5; i++){
			num=(int)homes[i][0];
			try { 
				//Matches the case number with the ID number from homes array.
				switch (num){
				//case=ID given
				case 0: 
					tempImage=ImageIO.read(new File("10 Foster Lane.JPG"));
					tempText=("10 Foster Lane, Narragansett, RI 02882");
					break;
				case 1: 
					tempImage=ImageIO.read(new File("81 Bristol Rd.JPG"));
					tempText=("81 Bristol Rd., Narragansett, RI 02882");
					break;
				case 2: 
					tempImage=ImageIO.read(new File("17 Lakeworth Ave.JPG"));
					tempText=("17 Lakeworth Ave., Narragansett, RI 02882");
					break;
				case 3: 
					tempImage=ImageIO.read(new File("125 Foddering Farm Rd.JPG"));
					tempText=("125 Foddering Farm Road, Narragansett, RI 02882");
					break;
				case 4: 
					tempImage=ImageIO.read(new File("46 Exeter Blvd.JPG"));
					tempText=("46 Exeter Blvd, Narragansett, RI 02882");
					break;

				case 10:
					tempImage=ImageIO.read(new File("18 Earles Court.JPG"));
					tempText=("18 Earles Court, Narragansett, RI 02882");
					break;
				case 11: 
					tempImage=ImageIO.read(new File("36 DeSano Drive.JPG"));
					tempText=("36 DeSano Drive, Narragansett, RI 02882");
					break;
				case 12: 
					tempImage=ImageIO.read(new File("19 Eire Rd.JPG"));
					tempText=("19 Eire Rd., Narragansett, RI 02882");
					break;
				case 13:
					tempImage=ImageIO.read(new File("3 Camden Rd.JPG"));
					tempText=("3 Camden Rd., Narragansett, RI 02882");
					break;
				case 14: 
					tempImage=ImageIO.read(new File("34 Spruce Ave.JPG"));
					tempText=("34 Spruce Avenue, Narragansett, RI 02882");
					break;

				case 20: 
					tempImage=ImageIO.read(new File("79 Bayberry Rd.JPG"));
					tempText=("79 Bayberry Road, Kingston, RI 02881");
					break;
				case 21:
					tempImage=ImageIO.read(new File("64 Spicebush Trail.JPG"));
					tempText=("64 Spicebush Trail, Narragansett, RI 02882");
					break;
				case 22:
					tempImage=ImageIO.read(new File("85 Blackbird Rd.JPG"));
					tempText=("85 Blackbird Road, West Kingstown, RI 02892");
					break;
				case 23: 
					tempImage=ImageIO.read(new File("16 Glenwood Ave.JPG"));
					tempText=("16 Glenwood Avenue, Narragansett, RI, 02882");
					break;
				case 24:
					tempImage=ImageIO.read(new File("47 Westmoreland St.JPG"));
					tempText=("47 Westmoreland Street, Narragansett, RI, 02882");
					break;

					//
				case 30:
					tempImage=ImageIO.read(new File("1 Grande Isle Drive.JPG"));
					tempText=("1 Grande Isle Drive, Wakefield, RI 02879");
					break;
				case 31: 
					tempImage=ImageIO.read(new File("940 Quaker Lane.JPG"));
					tempText=("940 Quaker Lane, Warwick, RI 02818");
					break;
				case 32:
					tempImage=ImageIO.read(new File("50 Rolens Drive.JPG"));
					tempText=("50 Rolens Drive, Kingston, RI 02881");
					break;
				case 33:
					tempImage=ImageIO.read(new File("80 Rogers Lane.JPG"));
					tempText=("80 Rogers Lane, Middletown, RI 02842");
					break;
				case 34:
					tempImage=ImageIO.read(new File("20 Woodland Dr.JPG"));
					tempText=("20 Woodland Dr, Coventry, RI 02816");
					break;

				case 40:
					tempImage=ImageIO.read(new File("50 Dogwood Dr.JPG"));
					tempText=("50 Dogwood Dr, West Warwick, RI 02893");
					break;
				case 41:
					tempImage=ImageIO.read(new File("1 Grande Isle Drive.JPG"));
					tempText=("1 Grande Isle Drive, Wakefield, RI 02879");
					break;
				case 42: 
					tempImage=ImageIO.read(new File("940 Quaker Lane.JPG"));
					tempText=("940 Quaker Lane, Warwick, RI 02818");
					break;
				case 43:
					tempImage=ImageIO.read(new File("80 Rogers Lane.JPG"));
					tempText=("80 Rogers Lane, Middletown, RI 02842");
					break;
				case 44:
					tempImage=ImageIO.read(new File("20 Woodland Dr.JPG"));
					tempText=("20 Woodland Dr, Coventry, RI 02816");
					break;
				}
			}
			catch (IOException e) {
			}

			/*Takes temporary values from above and stores it in correct place,
			 * as well as store other information into a String array for display in the window.
			 */
			switch (i){
			case 0: imgOne=tempImage;
			textOne[0]=("This residence has " + homes[i][3] + " bedroom(s),");
			textOne[1]=("features " + homes[i][4] + " bathroom(s) and");
			textOne[2]=("is " + homes[i][2] + " miles from the URI Kingston campus.");
			textOne[3]=("This residence will cost $" + (int)homes[i][1] + " a month per person.");
			textOne[4]=tempText;
			break;
			case 1: imgTwo=tempImage;
			textTwo[0]=("This residence has " + homes[i][3] + " bedroom(s),");
			textTwo[1]=("features " + homes[i][4] + " bathroom(s) and");
			textTwo[2]=("is " + homes[i][2] + " miles from the URI Kingston campus.");
			textTwo[3]=("This residence will cost $" + (int)homes[i][1] + " a month per person.");
			textTwo[4]=tempText;
			break; 
			case 2: imgThree=tempImage;
			textThree[0]=("This residence has " + homes[i][3] + " bedroom(s),");
			textThree[1]=("features " + homes[i][4] + " bathroom(s) and");
			textThree[2]=("is " + homes[i][2] + " miles from the URI Kingston campus.");
			textThree[3]=("This residence will cost $" + (int)homes[i][1] + " a month per person.");
			textThree[4]=tempText;
			break;
			case 3: imgFour=tempImage;
			textFour[0]=("This residence has " + homes[i][3] + " bedroom(s),");
			textFour[1]=("features " + homes[i][4] + " bathroom(s) and");
			textFour[2]=("is " + homes[i][2] + " miles from the URI Kingston campus.");
			textFour[3]=("This residence will cost $" + (int)homes[i][1] + " a month per person.");
			textFour[4]=tempText;
			break;
			case 4: imgFive=tempImage;
			textFive[0]=("This residence has " + homes[i][3] + " bedroom(s),");
			textFive[1]=("features " + homes[i][4] + " bathroom(s) and");
			textFive[2]=("is " + homes[i][2] + " miles from the URI Kingston campus.");
			textFive[3]=("This residence will cost $" + (int)homes[i][1] + " a month per person.");
			textFive[4]=tempText;
			break;
			}
		}

		Frame window=new Frame();

		//Looks at the original image size to assist in resizing.
		imageWidthOne=imgOne.getWidth(null);
		imageHeightOne=imgOne.getHeight(null);
		imageWidthTwo=imgTwo.getWidth(null);
		imageHeightTwo=imgTwo.getHeight(null);
		imageWidthThree=imgThree.getWidth(null);
		imageHeightThree=imgThree.getHeight(null);
		imageWidthFour=imgFour.getWidth(null);
		imageHeightFour=imgFour.getHeight(null);
		imageWidthFive=imgFive.getWidth(null);
		imageHeightFive=imgFive.getHeight(null); 

		window.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.add(this);
		window.pack();
	}

	/**
	 * Paints in another window for now. This will later come up in the
	 * same GUI panel that the user will see first when the program starts.
	 */
	public void paint(Graphics pane){

		//Values for placing the pictures, evenly spaced and the same size.
		final int ENDX=200;
		final int STARTY=50;
		final int SIZEY=150;
		//This shows all the home pictures in order depending on user input.
		//Note to self: name, startx, starty, endx, endy, cropping
		pane.drawImage(imgOne, 0, STARTY, ENDX, SIZEY, 0, 0, 
				(int)imageWidthOne, (int)imageHeightOne, null);
		pane.drawImage(imgTwo, 0, STARTY+SIZEY, ENDX, SIZEY*2, 0, 0, 
				(int)imageWidthTwo, (int)imageHeightTwo, null);
		pane.drawImage(imgThree, 0, STARTY+SIZEY*2, ENDX, SIZEY*3, 0, 0, 
				(int)imageWidthThree, (int)imageHeightThree, null);
		pane.drawImage(imgFour, 0, STARTY+SIZEY*3, ENDX, SIZEY*4, 0, 0, 
				(int)imageWidthFour, (int)imageHeightFour, null);
		pane.drawImage(imgFive, 0, STARTY+SIZEY*4, ENDX, SIZEY*5, 0, 0, 
				(int)imageWidthFive, (int)imageHeightFive, null);

		//Values used for placing the text.
		int y=80;
		final int NEXT_TEXT=75;
		//Outputs all the residence information in the window.
		for(int i=0; i<5; i++){
			pane.drawString(textOne[i], ENDX, y);
			y+=15;
		}
		for(int i=0; i<5; i++){
			pane.drawString(textTwo[i], ENDX, y+NEXT_TEXT);
			y+=15;
		}
		for(int i=0; i<5; i++){
			pane.drawString(textThree[i], ENDX, y+NEXT_TEXT*2);
			y+=15;
		}
		for(int i=0; i<5; i++){
			pane.drawString(textFour[i], ENDX, y+NEXT_TEXT*3);
			y+=15;
		}
		for(int i=0; i<5; i++){
			pane.drawString(textFive[i], ENDX, y+NEXT_TEXT*4);
			y+=15;
		}
	}
}
