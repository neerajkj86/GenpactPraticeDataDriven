package screenshot;

import java.util.Date;

public class Datetime {

	public static void main(String[] args) {
		
		
		Date d  = new Date();
		
		System.out.println(d);
		
		System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		
		System.out.println(System.getProperty("user.dir"));

	}

}
