package questions.canessa.com;

/*
 * Double Check Locking Singleton class
 */
public class DCLSingleton {

	// **** without volatile it will NOT be thread-safe 
	//		write to a volatile field will happen before any read, 
	//		which negates the possibility of seeing a half initialized 
	//		instance of Singleton class ****
	private static volatile DCLSingleton singleInstance = null;
	
	// **** for testing purpose ****
	public 	String str = "class instantiated";
	
	// **** constructor made private to disable instance creation outside of this class ****
	private DCLSingleton() {
	}
	
	// **** creates an instance of this class ****
	public static DCLSingleton getSingleInstance() {
		
		// **** 1st check non-synchronized ****
		if (singleInstance == null) {
			
			synchronized (DCLSingleton.class) {
				
				// **** 2nd check synchronized (only executes one time during life cycle of the Singleton) ****
				if (singleInstance == null) {
					singleInstance = new DCLSingleton();
				}
			} 
		}
		
		// **** return the single instance ****
		return singleInstance;
	}

}
