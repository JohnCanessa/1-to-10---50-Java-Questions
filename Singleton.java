package questions.canessa.com;

/*
 * 
 */
public class Singleton {

	// **** for testing purpose ****
	public String str = "class instantiated";
	
	// **** created by ClassLoader ****
	private static final Singleton singleInstance = new Singleton();
	
	// **** constructor made private to disable instance creation outside of this class ****
	private Singleton() {
	}
	
	// **** returns the single instance of this class ****
	public static Singleton getSingleInstance() {
		return singleInstance;
	}
}
