
public class MySwingMVCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Assemble all the pieces of the MVC
		  Model m = new Model("Sylvain", "Saurel");
		  View v = new View("MVC with SSaurel");
		  Controller c = new Controller(m, v);
		  CashRegister test = new CashRegister();
		  
		  // create scanner
		  Scanner scanner = new Scanner(test);
		  
		  c.initController();
	}

}
