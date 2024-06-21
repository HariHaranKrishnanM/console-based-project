package consolebasedproject1;

import java.util.*;
//MobileShopApp.java
public class Main {
 public static void main(String[] args){ 
     MobileModel model = new MobileModel();
     MobileView view = new MobileView();
     MobileController controller = new MobileController(model, view);
     
     // Example: Display all mobiles
     Scanner sc=new Scanner(System.in);
     System.out.println("*************Moblies and Assesories**************");
     System.out.println("\n Enter a number to check further");
     System.out.println("\n1.login if you are not an existing customer");
     System.out.println("\n2.Display Mobiles in Inventory");
     System.out.println("\n3.Buy a Mobile");
     System.out.println("\n4.Emergency Enquiry for Cutomers details");
     System.out.println("\n5.customer feedback");
     System.out.println("\n6.generate bill");
     int num=sc.nextInt();
     sc.nextLine();
     while(num!=0) {
     switch(num) {
     	case 1:
    	 
    	 System.out.println("Enter your name:");
    	 String name=sc.nextLine();
    	 System.out.println("Enter your phonenumber:");
    	 String phonenumber=sc.nextLine();
    	 System.out.println("Enter your email id:");
    	 String emailid=sc.nextLine();
    	 controller.addcustomer(name,phonenumber,emailid);
    	 break;
       case 2:
    	   controller.displayMobiles();
    	   break;
       case 3:
    	 System.out.println("Type Model to buy");
    	 String mod=sc.nextLine();
    	 String name1=sc.nextLine();
    	 controller.selected(mod,name1);
         break;
       case 4:
    	   System.out.println("enter customer details");
    	   String cusnm=sc.nextLine();
    	   controller.fetchcusdata(cusnm);
    	   break;
       case 5:
    	   System.out.println("Add your feedback");
    	   String feedback=sc.nextLine();
    	   controller.feedback(feedback);
    	   break;
    /* case 6:
    	   System.out.println("Enter how many mobiles have you bought here");
    	   int loop=sc.nextInt();
    	   for(int i=0;i<loop;i++) {
    		   String */ 
    	   
       default:
    	 break;
     }
     
     System.out.println("select 1 to 5 to move further or 0 to logout");
     int n=sc.nextInt();
     sc.nextLine();
     num=n;
     }
     System.out.println("Thank you!");
 }

}
