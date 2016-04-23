import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Matthew
 * Modifies how buttons appear and reacts in the window.
 */
public class Button {
	/**
	 * To hold the label, color, location, and size of the button.
	 */
	private String label;
	private Color color;
	private int x, y,
	width, height;

	/**
	 * 	To know if the button is up or not
	 */
	private boolean up;						

	/**
	 * Default constructor.
	 */
	public Button() {

	}

	/** Sets the button's values for use Abutton class.
	 * @param someLabel
	 * @param someColor
	 * @param someX
	 * @param someY
	 * @param someWidth
	 * @param someHeight
	 */
	public Button(String someLabel,
			Color someColor,
			int someX, int someY,
			int someWidth, int someHeight)
	{						
		//Creates a button with a given label, color, location, and size.
		setup(someLabel,
				someColor,	
				someX, someY,
				someWidth, someHeight);	
	}

	/**Initializes (or re-sets) the components of a button.
	 * @param someLabel
	 * @param someColor
	 * @param someX
	 * @param someY
	 * @param someWidth
	 * @param someHeight
	 */
	public void setup(String someLabel,
			Color someColor,
			int someX, int someY,
			int someWidth, int someHeight)
	{
		label = someLabel;
		color = someColor;
		x = someX;
		y = someY;
		width = someWidth;
		height = someHeight;
		//Initially, the button is not up
		up = false;							
	}

	/**
	 * flips the up/down state of the button
	 */
	public void flip()
	{
		up = !up;
	}

	/**
	 *	Determines if a given point is inside a button.
	 *	Note:  The boundary is considered within (inside) the button.
	 */
	public boolean isInside(int someX, int someY)
	{
		return(someX>=x && someX<=(x+width) && someY>=y && someY <=(y+height));		
	}

	/**
	 *	Draws/paints the button
	 */
	public void paint(Graphics pane)
	{
		//To define the space between the frame and inside of button.
		final int DELTA = 2;
		//Drawing the button frame in black.
		pane.setColor(Color.black);	
		pane.drawRect(x, y, width, height);	
		//The inside of the button is the given color.
		pane.setColor(color);
		pane.fill3DRect(x + DELTA, y + DELTA,
				width - (2*DELTA - 1),
				height - (2*DELTA - 1),
				up);
		//Puts the label in black and nicely centered.
		pane.setColor(Color.black);
		int labelWidth = pane.getFontMetrics().stringWidth(label);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(label,
				x + (width - labelWidth)/2,
				y + (height + labelHeight)/2);
	}
}
