import java.util.ArrayList;

/**
 * This class is the main class: it models a city.
 * @author swynsma18
 *
 */
public class City {
	private ArrayList<Building> buildings = new ArrayList<Building>();
	private ArrayList<Person> residents = new ArrayList<Person>();
	
	
	/**
	 * Constructor for the city: this is meant for testing purposes.
	 */
	public City()
	{
		Person A = new Kid("A", "A", 4, "345");
		Person B = new Kid("B", "B", 8, "567");
		residents.add(A);
		residents.add(B);
		Person C = new Police("C", "C", 37, "911");
		residents.add(C);
		Person D = new Teacher("D", "D", 70, "1000");
		ArrayList<Kid> K = new ArrayList<Kid>();
		K.add((Kid)A);
		K.add((Kid)B);
		ArrayList<Teacher> T = new ArrayList<Teacher>();
		T.add((Teacher)D);
		ArrayList<Police> Pol = new ArrayList<Police>();
		Pol.add((Police)C);
		Building E = new CityHall(Pol);
		Building F = new School(K, T);
		Building G = new Building("House1", "East101");
		Building H = new Building("House2", "East102");
		residents.add(D);
		buildings.add(E);
		buildings.add(F);
		buildings.add(G);
		buildings.add(H);
		
		
	}
	
	/**
	 * Outputs the names of all residents of the city.
	 */
	public void outputPersons()
	{
		for(int i = 0; i < residents.size(); i++)
		{
			System.out.printf("%s %s\n", residents.get(i).getFirstName(), residents.get(i).getLastName());
		}
	}
	
	/**
	 * Outputs the names of all buildings in the city.
	 */
	public void outputBuildings()
	{
		for(int i = 0; i < buildings.size(); i++)
		{
			System.out.printf("%s\n", buildings.get(i).getName());
		}
	}
	
	/**
	 * Gives employees their pay, based on their occupation.
	 */
	public void payEmployees()
	{
		for (int i = 0; i < residents.size(); i++)
		{
			if (residents.get(i) instanceof Employee)
			{
				System.out.printf("Paid %s %s $%f\n", residents.get(i).getFirstName(), residents.get(i).getLastName(), ((Employee)residents.get(i)).givePay());
			}
		}
	}
	
	/**
	 * Outputs all the kids and teachers in school.
	 */
	public void outputPeopleInSchool()
	{
		for(int i = 0; i < buildings.size(); i++)
		{
			if(buildings.get(i) instanceof School)
			{
				ArrayList<String> O = ((School)buildings.get(i)).GetStudents();
				for (int j = 0; j < O.size(); j++)
				{
					System.out.printf("%s is a student at %s.\n", O.get(j), buildings.get(i).getName());
				}
				O = ((School)buildings.get(i)).GetTeachers();
				for (int l = 0; l < O.size(); l++)
				{
					System.out.printf("%s is a teacher at %s.\n", O.get(l), buildings.get(i).getName());
				}
			}
		}
	}
	
	/**
	 * Outputs all officers in the city hall.
	 */
	public void outputPeopleInCityHall()
	{
		for(int i = 0; i < buildings.size(); i++)
		{
			if(buildings.get(i) instanceof CityHall)
			{
				ArrayList<String> O = ((CityHall)buildings.get(i)).GetPolice();
				for (int j = 0; j < O.size(); j++)
				{
					System.out.printf("%s is an officer at %s.\n", O.get(j), buildings.get(i).getName());
				}
			}
		}
	}
	
	
}
