import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Matthew
 * Allows user control of closing the window.
 */
public class GoodBye extends WindowAdapter {

	/**
	 * So our window closes when the user hits the close button
	 * (upper right hand corner x).
	 */
	public void windowClosing(WindowEvent event){
		System.exit(0);
	}
}
