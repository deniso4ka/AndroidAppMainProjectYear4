

<%@page import="java.util.ArrayList"%>
<%@page import="main.CarServiceImplService"%>
<%@page import="main.CarServiceImpl"%>
<%@page import="main.Car"%>
<%@page import="java.awt.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String id=""; 
String make=""; 
String model=""; 
String color=""; 
String engine=""; 
String description=""; 

 	Car c = new Car();
	List <Car> carList = new ArrayList<Car>();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Sale</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />

</head>
<body>
<h2>Car Service</h2>
<form method="POST">
 <label for="id">Car id</label>
<input type="text" name="id" id="id">
<br>
 <label for="make">Car make</label>
<input type="text" name="make" id="make">
<br>
 <label for="model">Car model</label>
<input type="text" name="model" id="model">
<br>
 <label for="color">Car color</label>
<input type="text" name="color" id="color">
<br>
 <label for="engine">Car engine</label>
 <input type="text" name="engine" id="engine">
<br>
 <label for="description">Car description</label>
<input type="text" name="description" id="description">
<br>


<input type="submit" name="button" value="add"/>
<input type="submit" name="button" value="edit"/>
<input type="submit" name="button" value="delete"/>
<input type="submit" name="button" value="display"/>
</form>

<img src="${pageContext.request.contextPath}/car.png" />

<% 


String act = request.getParameter("button");
if (act == null) {
    //no button has been selected
} 

	else if (act.equals("add")) {
	
    //delete button was pressed
    
	if(request.getParameter("id")!=null){
		id = request.getParameter("id");
		make = request.getParameter("make");
		model = request.getParameter("model");
		color = request.getParameter("color");
		engine = request.getParameter("engine");
		description = request.getParameter("description");
		CarServiceImplService car = new CarServiceImplService();
		CarServiceImpl stub = car.getCarServiceImplPort();
		stub.addCar(id, make, model, color, engine, description);
		carList = stub.displayCars();
		 Iterator<Car> iterator = carList.iterator();
		 
		 out.println("<table><tr><th>Id</th><th>Make</th><th>Model</th><th>Engine</th><th>Color</th><th>Description</th></tr>");
		 while(iterator.hasNext()){
		 		
		 	Car carObject = new Car();
		 	carObject = iterator.next();
		 	if(carObject!=null){
		 		out.println("<tr>");
		 		out.println("<td>"+carObject.getId()+"</td>");
		 		out.println("<td>"+carObject.getMake()+"</td>");
		 		out.println("<td>"+carObject.getModel()+"</td>");
		 		out.println("<td>"+carObject.getEngine()+"</td>");
		 		out.println("<td>"+carObject.getColor()+"</td>");
		 		out.println("<td>"+carObject.getDescription()+"</td>");
		 		out.println("</tr>");	
		 	}
		 	
		 }
		 
		 out.println("</table>");	
	   }
	    

} else if (act.equals("delete")) {
	CarServiceImplService car = new CarServiceImplService();
	CarServiceImpl stub = car.getCarServiceImplPort();
	if(request.getParameter("id")!=null){
		id = request.getParameter("id");
	}
	carList = stub.remove(id);
	 Iterator<Car> iterator = carList.iterator();
	 
	 out.println("<table><tr><th>Id</th><th>Make</th><th>Model</th><th>Engine</th><th>Color</th><th>Description</th></tr>");
	 while(iterator.hasNext()){
	 		
	 	Car carObject = new Car();
	 	carObject = iterator.next();
	 	if(carObject!=null){
	 		out.println("<tr>");
	 		out.println("<td>"+carObject.getId()+"</td>");
	 		out.println("<td>"+carObject.getMake()+"</td>");
	 		out.println("<td>"+carObject.getModel()+"</td>");
	 		out.println("<td>"+carObject.getEngine()+"</td>");
	 		out.println("<td>"+carObject.getColor()+"</td>");
	 		out.println("<td>"+carObject.getDescription()+"</td>");
	 		out.println("</tr>");	
	 	}
	 	
	 }
	 
	 out.println("</table>");	
} 
else if (act.equals("edit")) {
	id = request.getParameter("id");
	make = request.getParameter("make");
	model = request.getParameter("model");
	color = request.getParameter("color");
	engine = request.getParameter("engine");
	description = request.getParameter("description");
	CarServiceImplService car = new CarServiceImplService();
	CarServiceImpl stub = car.getCarServiceImplPort();
	carList = stub.update(id, make, model,  engine, color, description);
	 Iterator<Car> iterator = carList.iterator();
	 out.println("<table><tr><th>Id</th><th>Make</th><th>Model</th><th>Engine</th><th>Color</th><th>Description</th></tr>");
	 while(iterator.hasNext()){
	 		
	 	Car carObject = new Car();
	 	carObject = iterator.next();
	 	if(carObject!=null){
	 		out.println("<tr>");
	 		out.println("<td>"+carObject.getId()+"</td>");
	 		out.println("<td>"+carObject.getMake()+"</td>");
	 		out.println("<td>"+carObject.getModel()+"</td>");
	 		out.println("<td>"+carObject.getEngine()+"</td>");
	 		out.println("<td>"+carObject.getColor()+"</td>");
	 		out.println("<td>"+carObject.getDescription()+"</td>");
	 		out.println("</tr>");	
	 	}
	 	
	 }
	 
	 out.println("</table>");	
	
}
else if (act.equals("display")) {
	CarServiceImplService car = new CarServiceImplService();
	CarServiceImpl stub = car.getCarServiceImplPort();
	carList = stub.displayCars();
	 Iterator<Car> iterator = carList.iterator();
	 out.println("<table><tr><th>Id</th><th>Make</th><th>Model</th><th>Engine</th><th>Color</th><th>Description</th></tr>");
	 while(iterator.hasNext()){
	 		
	 	Car carObject = new Car();
	 	carObject = iterator.next();
	 	if(carObject!=null){
	 		out.println("<tr>");
	 		out.println("<td>"+carObject.getId()+"</td>");
	 		out.println("<td>"+carObject.getMake()+"</td>");
	 		out.println("<td>"+carObject.getModel()+"</td>");
	 		out.println("<td>"+carObject.getEngine()+"</td>");
	 		out.println("<td>"+carObject.getColor()+"</td>");
	 		out.println("<td>"+carObject.getDescription()+"</td>");
	 		out.println("</tr>");	
	 	}
	 	
	 }
	 
	 out.println("</table>");	
}
else {
   out.println("<h3>Something went wrong!!!</h3>");
}


%>

</body>
</html>