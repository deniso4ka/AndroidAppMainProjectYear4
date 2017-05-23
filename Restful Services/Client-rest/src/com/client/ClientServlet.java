package com.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	
	String jsonList;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = Client.create();
		javax.ws.rs.client.Client clientWs = ClientBuilder.newClient();
		WebResource webResource;
		ClientResponse clientResponse;


		String act = request.getParameter("button");
		if (act == null) {
		   
		} 

			else if (act.equals("add")) {
				
				String id = (String) request.getParameter("id");
				String make = (String) request.getParameter("make");
				String model = (String) request.getParameter("model");
				String color = (String) request.getParameter("color");
				String engine = (String) request.getParameter("engine");
				String description = (String) request.getParameter("description");
		
				Car car = new Car();
				car.setId(id);
				car.setMake(make);
				car.setModel(model);
				car.setColor(color);
				car.setEngine(engine);
				car.setDescription(description);
					
				
				
				WebTarget postTarget = clientWs.target("http://localhost:8080/restful-service/webapi/rest").path("/add");
				String message = postTarget.request().post(Entity.entity(car, MediaType.APPLICATION_JSON), String.class);
				
				System.out.println(" "+ message);
				request.setAttribute("message", message);
			    request.getRequestDispatcher("client.jsp").forward(request,response);
				

		}
		else if (act.equals("delete")) {
			String id = (String) request.getParameter("id");
			Form form = new Form();
			form.add("id", id);
		
			
			
			webResource = client.resource("http://localhost:8080/restful-service/webapi/rest/delete/"+request.getParameter("id"));
			clientResponse = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
			if(clientResponse.getStatus() ==200){
				String message = clientResponse.getEntity(String.class);
				System.out.println(" "+ message);
				request.setAttribute("message", message);
			    request.getRequestDispatcher("client.jsp").forward(request,response);
			}
		
		} 
		else if (act.equals("edit")) {
			
			String id = (String) request.getParameter("id");
			String make = (String) request.getParameter("make");
			String model = (String) request.getParameter("model");
			String color = (String) request.getParameter("color");
			String engine = (String) request.getParameter("engine");
			String description = (String) request.getParameter("description");
			
			Car car = new Car();
			car.setId(id);
			car.setMake(make);
			car.setModel(model);
			car.setColor(color);
			car.setEngine(engine);
			car.setDescription(description);
			
			WebTarget postTarget = clientWs.target("http://localhost:8080/restful-service/webapi/rest").path("/update");
			String message = postTarget.request().put(Entity.entity(car, MediaType.APPLICATION_JSON), String.class);
			
			System.out.println(" "+ message);
			request.setAttribute("message", message);
		    request.getRequestDispatcher("client.jsp").forward(request,response);
					
		}
		else if (act.equals("display")) {
		
		
			webResource = client.resource("http://localhost:8080/restful-service/webapi/rest/displayAll");
			clientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			if(clientResponse.getStatus() ==200){
				jsonList = clientResponse.getEntity(String.class);
				System.out.println("output is "+ jsonList);
				request.setAttribute("output", jsonList);
			    request.getRequestDispatcher("client.jsp").forward(request,response);
			}
		}
		else {
		  
		
		}

	
	}

}
