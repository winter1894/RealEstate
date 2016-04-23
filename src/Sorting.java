/**
 * 
 * @author Matthew
 *This class will be able to accept an array and organize it
 *in the order that the user specified (smallest to largest)
 */
public class Sorting {

	/**
	 * the homes array filled with user preference in residence type.
	 */
	private double [][] homes;

	/**
	 * Value that dictates how the user wants the information sorted.
	 */
	private int sortType;

	/**
	 * This keeps track of what sortType the user wants and
	 * what the preference of housing is.
	 * @param sortType
	 */
	public Sorting(int sortType, double[][]homes){

		this.sortType=sortType;
		this.homes=homes;

		smalltoBig();
	}

	/**
	 * Sorts integers from smallest to largest value
	 */
	private void smalltoBig(){

		int unsorted=homes.length;
		for(int i=0; i<homes.length-1; i++){
			int largestIndex=0;
			double largest=homes[0][sortType];
			for(int j=1; j<unsorted; j++){
				if(largest<homes[j][sortType]){
					largest=homes[j][sortType];
					largestIndex=j;
				}
			}
			exchange(largestIndex, unsorted-1); //largest and last
			unsorted--; //move partition over
		}

		returnSorted();
	}

	/**
	 * The exchange method is used to momentarily store values 
	 * to swap indexes during the sorting method.
	 * @param first
	 * @param last
	 */
	private void exchange(int first, int last){

		for (int i=0; i<5; i++){
			double temp=homes[first][i]; //store
			homes[first][i]=homes[last][i]; //replace
			homes[last][i]=temp;
		}
	}

	/**
	 * This returns the sorted array when RealEstate calls for the updated sorted values.
	 * @return
	 */
	public double[][] returnSorted(){

		return homes;
	}
}
