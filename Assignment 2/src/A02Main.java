
public class A02Main {

	//The purpose of this class is to start the program and display the GUI
	
	public static void main(String[] args) {
		A02FrontEnd window = new A02FrontEnd();
		A02MiddleTier app = new A02MiddleTier();
		window.setVisible(true);
	}

}
