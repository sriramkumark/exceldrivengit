import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven dd = new dataDriven();
		ArrayList<String> ts= dd.getData("purchase");  // Invoking the dataDriven user defiened method in testsample class to get the value in arraylist
	    System.out.println(ts.get(0));	
	    System.out.println(ts.get(1));
	    System.out.println(ts.get(2));
	    System.out.println(ts.get(3));
	}

}
