package consolebasedproject1;

//MobileView.java
import java.util.List;

class MobileView {
 public void displayMobiles(List<Mobile> mobileList) {
     System.out.println("Mobiles in the inventory:");
     for (Mobile mobile : mobileList) {
         System.out.println(mobile);
     }
 }
 public void cusfeedback(String feedback) {
	 System.out.println("Thank you for your feedback");
 }
 
}

