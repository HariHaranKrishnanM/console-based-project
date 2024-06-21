package consolebasedproject1;
//MobileController.java
import java.util.List;

public class MobileController {
 private MobileModel model;
 private MobileView view;

 public MobileController(MobileModel model, MobileView view) {
     this.model = model;
     this.view = view;
 }

 public void displayMobiles() {
     List<Mobile> mobileLis = model.getAllMobiles();
     view.displayMobiles(mobileLis);
 }
 public void selected(String mmod,String name1) {
	 model.displayselected(mmod,name1);
 }
 public void addcustomer(String namee,String phonenumberr,String eemailid) {
	 model.addthecustomer(namee,phonenumberr,eemailid);
 }
 public void fetchcusdata(String cusnm) {
	 model.fetchrealdata(cusnm);
 }
 public void feedback(String feedback) {
	 view.cusfeedback(feedback);
 }
 // Add other methods to handle user input and update the model
}
