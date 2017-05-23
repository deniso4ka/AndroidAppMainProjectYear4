package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import model.Car;

@WebService
public class CarServiceImpl {
	
	List <Car> carList = new ArrayList<Car>();
	
	
	public List <Car> addCar(String id, String make, String model, String color, String engine, String description){
		
		Car car = new Car();
		car.setId(id);
		car.setMake(make);
		car.setModel(model);
		car.setColor(color);
		car.setEngine(engine);
		car.setDescription(description);
		carList.add(car);
		
		
		
		System.out.println("Car was succesfully added on Service");
		
		return carList;
	}
	
	public List<Car> displayCars(){
		
		System.out.println("Display cars method executed on Service");
	
		return carList;
		
	}
	
	public List<Car>remove(String id){
		
		 for(Iterator<Car> iter = carList.listIterator(); iter.hasNext();){
			 
			 if(iter.next().getId().equals(id)){
			        iter.remove();
			        
			    }
		 
		 }
		
	
		
		System.out.println("Car removed on sevice on Service");
		return carList;
		
	}
	
	public List <Car> update(String id, String make, String model, String engine, String color, String description){
		
		
		  for (int i = 0; i < carList.size(); i++)
				if(carList.get(i).getId().equals(id)){
					
					carList.get(i).setId(id);
					carList.get(i).setMake(make);
					carList.get(i).setModel(model);
					carList.get(i).setEngine(engine);
					carList.get(i).setColor(color);
					carList.get(i).setDescription(description);
				}
		
		System.out.println("Car updated on Service");
		return carList;
		
		
	}


	
	
	
	
	

}
