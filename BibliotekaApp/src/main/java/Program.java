import Models.Administrator;

import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {
		StartUp app = new StartUp();
		app.RegisterResources();
		app.Start();
	}

}
