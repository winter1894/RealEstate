package Home;

/**
 * House is a Residence. A Residence is differentiated from other residences by
 * a few things such as different fees.
 * @author Matthew
 */
public class House extends Residence{

	/**
	 * Default Constructor of House class.
	 */
	public House(){

		library();
	}

	/**
	 * Constructor for bed number and house preferences.
	 */
	public House(int bedNum){

		this.bedNum=bedNum;
		library();
	}

	/**
	 * The House class library method will contain all information
	 * about houses if the user specifies that is the only type of
	 * residence that they are interested in.
	 */
	private void library(){

		if(bedNum==0){
			homes=new double[][]{ 
					//Houses
					{0,1800,6.75,4,2},
					{1,2100,6.79,4,2.5},
					{2,1850,6.23,4,2},
					{3,1700,6.5,4,2},
					{4,2275,7.3,4,2},

					{10,1500,5.85,3,2}, 
					{11,1200,7.08,3,2}, 
					{12,1100,7.14,3,1}, 
					{13,1275,6.6,3,1.5}, 
					{14,1200,9.2,3,1}, 

					{20,1100,0.21,2,1}, 
					{21,1500,4.45,2,2}, 
					{22,1350,1.7,2,2},
					{23,850,9.1,2,1},
					{24,1000,6.3,2,1},
			};
		}
		else if(bedNum==2){
			homes=new double[][]{ 
					{20,1100,0.21,2,1}, 
					{21,1500,4.45,2,2}, 
					{22,1350,1.7,2,2},
					{23,850,9.1,2,1},
					{24,1000,6.3,2,1},
			};
		}
		else if(bedNum==3){
			homes=new double[][]{ 
					{10,1500,5.85,3,2}, 
					{11,1200,7.08,3,2}, 
					{12,1100,7.14,3,1}, 
					{13,1275,6.6,3,1.5}, 
					{14,1200,9.2,3,1},
			};
		}
		else if(bedNum==4){
			homes=new double[][]{ 
					{0,1800,6.75,4,2},
					{1,2100,6.79,4,2.5},
					{2,1850,6.23,4,2},
					{3,1700,6.5,4,2},
					{4,2275,7.3,4,2},
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
	 * returns the homes array of houses if user selected houses.
	 */
	public double[][] returnArray(){

		return homes;
	}
}
