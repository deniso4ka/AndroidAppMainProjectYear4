<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="org.codehaus.jettison.json.JSONArray"%>
	<%@page import="org.codehaus.jettison.json.JSONException"%>
	<%@page import="org.codehaus.jettison.json.JSONObject"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Sale</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />

</head>
<body>
<h2>Car Service</h2>

<%  if(request.getAttribute("message")!=null){
	 
	 String message = (String) request.getAttribute("message");
	 out.println("<h3>"+message+"</h3>");
 }
 
 %>

<form method="POST" action="ClientServlet">
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

String json = (String) request.getAttribute("output");



out.println("<table><tr><th>Id</th><th>Make</th><th>Model</th><th>Engine</th><th>Color</th><th>Description</th></tr>");

	
		
try {
	
	if(json!=null){

					JSONArray jsonArray =  new JSONArray(json);
					
							for (int i = 0; i < jsonArray.length(); i++)
							{
								JSONObject person = jsonArray.getJSONObject(i);
								out.println("<tr>");
								out.println("<td>"+person.getString("id")+"</td>");
								out.println("<td>"+person.getString("make")+"</td>");
								out.println("<td>"+person.getString("model")+"</td>");
								out.println("<td>"+person.getString("engine")+"</td>");
								out.println("<td>"+person.getString("color")+"</td>");
								out.println("<td>"+person.getString("description")+"</td>");
								out.println("</tr>");		
							}
	
	
					}//end of if
	
								out.println("</table>");	
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

 
%>


</body>
</html>