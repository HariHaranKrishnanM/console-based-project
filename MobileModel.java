package consolebasedproject1;

//MobileModel.java
import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

 public class MobileModel {
 private Connection connection;
 String brandname="";
 String modelname="";
 
 public MobileModel() {
     try {
         this.connection = DatabaseConnector.getConnection();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 } 

 public List<Mobile> getAllMobiles() {
     List<Mobile> mobileList = new ArrayList<>();
     try (Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * FROM mobiles")) {

         while (resultSet.next()) {
             int id = resultSet.getInt("id");
             String brand = resultSet.getString("brand");
             String model = resultSet.getString("model");
             double price = resultSet.getDouble("price");

             Mobile mobile = new Mobile(id, brand, model, price);
             mobileList.add(mobile);
         }
     } 
     catch (SQLException e) {
         e.printStackTrace();
     }
     return mobileList;
 }
 public void addthecustomer(String name,String ph,String email) {
	 try {
	 String sql = "INSERT INTO customers (cus_name,Phone_num,email_id) VALUES (?,?,?)";
     PreparedStatement preparedStatement = connection.prepareStatement(sql);

    
    
     preparedStatement.setString(1, name);
     preparedStatement.setString(2, ph);
     preparedStatement.setString(3, email);

    
     int rowsAffected=preparedStatement.executeUpdate();

    
     if (rowsAffected > 0) {
         System.out.println("Logged in successfully.");
     } else {
         System.out.println("Failed to add customer details.");
     }

     preparedStatement.close();
     connection.close();
	 }
	 catch (SQLException e) {
         e.printStackTrace();
     }
 }
  public void displayselected(String ood,String name1){
	  String valueToValidate = ood;  // Replace with your actual value
      String ond=name1;
      // SQL query with a placeholder for the value to validate
      String selectQuery = "SELECT * FROM mobiles WHERE model = ?";
      
      try(
          // Creating a PreparedStatement with the query
          PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
      ) {
          // Setting the value to validate in the PreparedStatement
          preparedStatement.setString(1, valueToValidate);

          // Executing the query
          ResultSet resultSet = preparedStatement.executeQuery();
          String modell="";
          // Checking if the result set is not empty
          if (resultSet.next()) {
              // Retrieving and displaying data from the result set
              int id = resultSet.getInt("id");
              String brandd= resultSet.getString("brand");
              modell = resultSet.getString("model");
              String pricee =resultSet.getString("price");
              System.out.println("The model found in inventory"); 
              System.out.println("ID: " + id);
              System.out.println("you selected "+brandd+" "+modell+" and the price is :"+pricee);
              // Add more columns as needed
              		 
                      // SQL query to update a specific column in a table
                      String updateQuery = "UPDATE customers SET purchased_model = ? WHERE cus_name= ?";
                      String updateQuery2 = "UPDATE customers SET purchased_date = CURRENT_TIMESTAMP WHERE cus_name= ?";
                      

                      // Values to be updated
                      String newValue = modell;
                    
                      String conditionValue = ond;

                      try 
                          // Establishing a connection to the database
                         
                          
                          // Creating a prepared statement for the update query
                       {
                    	  PreparedStatement Statement1 = connection.prepareStatement(updateQuery);
                          // Setting the new value and the condition value in the prepared statement
                          Statement1.setString(1, newValue);
                          
                          Statement1.setString(2, conditionValue);

                          // Executing the update query
                          Statement1.executeUpdate();
                          PreparedStatement Statement2 = connection.prepareStatement(updateQuery2);
                          // Setting the new value and the condition value in the prepared statement
                          
                          Statement2.setString(1, conditionValue);
                          

                          // Executing the update query
                          Statement2.executeUpdate();
                         

                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                  }
              

           
          else {
              System.out.println("sorry we not have that mobile in our inventory");
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  public void fetchrealdata(String cusnm) {
	  String valueToValidate = cusnm;  // Replace with your actual value

      // SQL query with a placeholder for the value to validate
      String selectQuery = "SELECT * FROM customers WHERE cus_name = ?";
      
      try (
          // Creating a PreparedStatement with the query
          PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
      ) {
          // Setting the value to validate in the PreparedStatement
          preparedStatement.setString(1, valueToValidate);

          // Executing the query
          ResultSet resultSet = preparedStatement.executeQuery();
        
          // Checking if the result set is not empty
          if (resultSet.next()){
              // Retrieving and displaying data from the result set
        	  System.out.println("customer details you asked for");
              int id = resultSet.getInt("customer_id");
              String name= resultSet.getString("cus_name");
               String phone= resultSet.getString("Phone_num");
              String email =resultSet.getString("email_id");
              System.out.println("CUSTOMER ID:                 " + id);
              System.out.println("THE NAME OF THE CUSTOMER IS: "+name);
              System.out.println("phone number:                "+phone);
              System.out.println("email id:                    "+email);
            
          } 
          else {
              System.out.println("sorry we not have thet mobile in our inventory");
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

 }

 


