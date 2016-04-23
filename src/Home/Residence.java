package Home;

/**
 * The residence class will contain information that pertain to 
 * houses and apartments. It is the parent class of the House
 * class and Apartment class more specifically.
 * @author Matthew
 */
public class Residence {

	/**
	 * This is the starting place for the double array homes.
	 * It takes in the user choices and only puts in relevant residences 
	 * for use throughout the program.
	 */
	protected double [][] homes;

	/**
	 * The number of beds comes in from RealEstate to only select the number of
	 * beds that the user is searching for. If there is nothing selected, the actual
	 * value is 0, which represents no number of bed preference.
	 */
	protected int bedNum;

	/**
	 * Default constructor.
	 */
	public Residence(){

		library();
	}

	/**
	 * Constructor for bed number preference but no residence preference.
	 */
	public Residence(int bedNum){

		this.bedNum=bedNum;
		library();
	}

	/**
	 * The library method contains all information 
	 * (such as cost, distance, how many bed and bath)
	 *  about available houses and apartments in a double array.
	 */
	private void library(){

		/*
		 * Uses the number of beds the user wants and stores 
		 * the matching residences into homes array.
		 */
		//{(Address ID), cost ($), distance (mi), bed, bath}
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
		else if(bedNum==1){
			homes=new double[][]{
					{30,1235,5.3,1,1},
					{31,980,18.0,1,1},
					{32,825,1.4,1,1},
					{33,760,19.5,1,1},
					{34,1000,21.8,1,1},
			};
		}
		else if(bedNum==2){
			homes=new double[][]{ 
					{20,1100,0.21,2,1}, 
					{21,1500,4.45,2,2}, 
					{22,1350,1.7,2,2},
					{23,850,9.1,2,1},
					{24,1000,6.3,2,1},

					{40,1325,16.6,2,1},
					{41,1415,5.3,2,2},
					{42,1500,18.0,2,2},
					{43,907,19.5,2,1},
					{44,1125,21.8,2,1}
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
					//Houses
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
	 * If there are any costs that pertain to both apartments and houses they will go here.
	 */
	protected void costs(){

		for (int i=0; i<homes.length; i++){
			//cable
			homes[i][1]=homes[i][1]+80;	
			//electricity (roughly $30 per person)
			homes[i][1]=homes[i][1]+30*homes[i][3];	
		}

		houseCosts();
		apartmentCosts();

		//Finds cost per person and stores that as new price value.
		for (int i=0; i<homes.length; i++){
			homes[i][1]=homes[i][1]/homes[i][3];
		}
	}

	/**
	 * Only adds these costs on if the residence is a house.
	 */
	private void houseCosts(){

		for (int i=0; i<homes.length; i++){
			if(homes[i][0]<30){
				//heating
				homes[i][1]=homes[i][1]+150;
				//water
				homes[i][1]=homes[i][1]+20;
			}
		}
	}

	/**
	 * Only adds these costs on if the residence is an apartment.
	 */
	private void apartmentCosts(){

		for (int i=0; i<homes.length; i++){
			if(homes[i][0]>=30){
				//parking
				homes[i][1]=homes[i][1]+200;
			}
		}
	}

	/**
	 * returns the homes array of residences if user has no preference in residence type.
	 */
	public double[][] returnArray(){

		return homes;
	}

}
