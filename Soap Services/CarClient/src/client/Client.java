package client;





import java.util.ArrayList;
import java.util.List;



import main.Car;
import main.CarServiceImpl;
import main.CarServiceImplService;


public class Client {
	
	


	static List<Car> carList;
	
	public static List<Car> getCarList() {
		return carList;
	}

	public static void setCarList(List<Car> carList) {
		Client.carList = carList;
	}

	public static void main(String[] args) {
			
		carList = new ArrayList<>();
		
		CarServiceImplService car = new CarServiceImplService();
		CarServiceImpl some = car.getCarServiceImplPort();
		System.out.println("-----------------------------------------------");
		carList = some.addCar("dont", "two", "three", "four", "five", "six");
		System.out.println("The car has been succesfully added by client!!!!");

		System.out.println("-----------------------------------------------");
		
		for(Car c : carList){

			System.out.println("Car id is "+ c.getId());
			System.out.println("Car make is "+c.getMake());
			System.out.println("Car model "+c.getModel());
			System.out.println("Car engine is "+c.getEngine());
			System.out.println("Car color is "+c.getColor());
			System.out.println("Car description is "+c.getDescription());
			
		}
		
		System.out.println("Here are the cars from the list by client!!!!");
		
		System.out.println("-----------------------------------------------");
		
		carList = some.update("dont", "twoUpdated", "threetwoUpdated", "fourtwoUpdated", "fivetwoUpdated", "sixtwoUpdated");
		
		System.out.println("The car has been succesfully edited by client!!!!");
		
		for(Car c : carList){

			System.out.println("Car id is "+ c.getId());
			System.out.println("Car make is "+c.getMake());
			System.out.println("Car model "+c.getModel());
			System.out.println("Car engine is "+c.getEngine());
			System.out.println("Car color is "+c.getColor());
			System.out.println("Car description is "+c.getDescription());
			
		}
		
		System.out.println("-----------------------------------------------");
		
		carList = some.remove("no");
		
		System.out.println("The car has been succesfully removed by client!!!!");
		
		
		System.out.println("-----------------------------------------------");
	}
	

	
	
	

}
