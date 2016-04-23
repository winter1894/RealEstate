package Home;

/**
 * Apartment is a Residence. A Apartment is differentiated from other residences by
 * a few things such as different fees.
 * @author Matthew
 */
public class Apartment extends Residence{

	/**
	 * Default Constructor of Apartment class.
	 */
	public Apartment(){

		library();
	}

	/**
	 * Constructor for bed number and apartment preferences.
	 */
	public Apartment(int bedNum){

		this.bedNum=bedNum;
		library();
	}

	/**
	 * The Apartment class library method will contain all information
	 * about apartments if the user specifies that is the only type of
	 * residence that they are interested in.
	 */
	private void library(){

		//{house/apartment(possibly to become number indicating address),
		//cost ($), distance (mi), bed, bath}
		if(bedNum==0){
			homes=new double[][]{ 
					//Apartments
					{30,1235,5.3,1,1},
					{31,980,18.0,1,1},
					{32,825,1.4,1,1},
					{33,760,19.5,1,1},
					{34,1000,21.8,1,1},

					{40,1325,16.6,2,1},
					{41,1415,5.3,2,2},
					{42,1500,18.0,2,2},
					{43,907,19.5,2,1},
					{44,1125,21.8,2,1}
			};
		}
		else if (bedNum==1){
			homes=new double[][]{ 
					{30,1235,5.3,1,1},
					{31,980,18.0,1,1},
					{32,825,1.4,1,1},
					{33,760,19.5,1,1},
					{34,1000,21.8,1,1},
			};
		}
		else if (bedNum==2){
			homes=new double[][]{ 
					{40,1325,16.6,2,1},
					{41,1415,5.3,2,2},
					{42,1500,18.0,2,2},
					{43,907,19.5,2,1},
					{44,1125,21.8,2,1}
			};
		}

		costs();
	}

	/**
	 * Adds on other payments that come with Home ownership.  
	 */
	protected void costs(){

		super.costs();
	}

	/**
	 * returns the homes array of apartments if user selected apartments.
	 */
	public double[][] returnArray(){

		return homes;
	}

}
