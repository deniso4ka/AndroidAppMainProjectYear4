package com.deniss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.deniss.model.Car;


@Path("/rest")
public class ActivityResource {
	
	 private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/rest";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";
	    private static final String MAX_POOL = "250";
	    
	    // init connection object
	    private Connection connection;
	    // init properties object
	    private Properties properties;
	
	ArrayList<Car> list = new ArrayList<Car>();
	
	
	@GET
	@Path("/displayAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCars(){
		
		try {
				properties = new Properties();
	            properties.setProperty("user", USERNAME);
	            properties.setProperty("password", PASSWORD);
	            properties.setProperty("MaxPooledStatements", MAX_POOL);
			
			
	            try {
					Class.forName(DATABASE_DRIVER);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                connection = DriverManager.getConnection(DATABASE_URL, properties);
			
                Statement myStatement = connection.createStatement();
			
			
			ResultSet myRs = myStatement.executeQuery("select * from car");
			
			while(myRs.next()){
				Car car = new Car();
				car.setId(myRs.getString("id"));
				car.setMake(myRs.getString("make"));
				car.setModel(myRs.getString("model"));
				car.setEngine(myRs.getString("engine"));
				car.setColor(myRs.getString("color"));
				car.setDescription(myRs.getString("description"));
				list.add(car);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
public String add(Car car){
		properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        
        try {
			Class.forName(DATABASE_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			connection = DriverManager.getConnection(DATABASE_URL, properties);
			 
			 String sql = "insert into car"
						+ "(id, make, model, engine, color, description)"
						+ "values (?,?,?,?,?,?)";
						
						PreparedStatement myStatemAdd  = connection.prepareStatement(sql);
						
				
						myStatemAdd.setString(1, car.getId());
						myStatemAdd.setString(2, car.getMake());
						myStatemAdd.setString(3, car.getModel());
						myStatemAdd.setString(4, car.getEngine());
						myStatemAdd.setString(5, car.getColor());
						myStatemAdd.setString(6, car.getDescription());
						myStatemAdd.executeUpdate();
						System.out.println("added");
						connection.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	
       return "Car "+car.getMake()+ " "+car.getModel()+" has been succesfully added to the Database!!!";
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
		public String update(Car car){
		
		properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        
        try {
			Class.forName(DATABASE_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
        try {
        	
        	connection = DriverManager.getConnection(DATABASE_URL, properties);
        	
        	String sqlUpdate = "update car set make=?, model=?, engine=?, color=?, description=?  where id=?";
    		
    		PreparedStatement myStatemUpdate = connection.prepareStatement(sqlUpdate);
    		
    	
    		myStatemUpdate.setString(1, car.getMake());
    		myStatemUpdate.setString(2, car.getModel());
    		myStatemUpdate.setString(3, car.getEngine());
    		myStatemUpdate.setString(4, car.getColor());
    		myStatemUpdate.setString(5, car.getDescription());
    		myStatemUpdate.setString(6, car.getId());
    		
    		myStatemUpdate.executeUpdate();
    		
    		
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "Car with id " + car.getId() + " has been succesfully edited!!!";
	}
	
	@DELETE
	@Path("/delete/{id}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String remove(@PathParam("id") String id){
		
		properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        
        try {
			Class.forName(DATABASE_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			connection = DriverManager.getConnection(DATABASE_URL, properties);
		String sqldelete = "delete from car where id=?";
		PreparedStatement myStatemDelete = connection.prepareStatement(sqldelete);
		myStatemDelete.setString(1, id);
		myStatemDelete.executeUpdate();
		
		
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return "The car with id " + id +" has been succesfully deleted";
	}

}

