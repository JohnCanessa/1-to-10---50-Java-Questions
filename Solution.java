package questions.canessa.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * First 10 questions of 50.
 */
public class Solution {

	/*
	 * How many String objects are created here?
	 * 
	 *  String s = new String("Hello World");
	 *  
	 *  1) One
	 *  2) Two
	 *  3) Three
	 */
	static int stringObjects() {
		
		// **** create initialized String instance ****
		String s1 = new String("Hello World");
		System.out.println("stringObjects <<<         s1.hashCode: " + s1.hashCode());
		System.out.println("stringObjects <<< s1.identityHashCode: " + System.identityHashCode(s1) + "\n");
		
		// **** String Constant Pool (SCP) ****
		String s2 = s1.intern();
		System.out.println("stringObjects <<<         s2.hashCode: " + s2.hashCode());
		System.out.println("stringObjects <<< s2.identityHashCode: " + System.identityHashCode(s2) + "\n");
		
		// **** false because they are two different objects ****
		System.out.println("stringObjects <<< s1 == s2: " + (s1 == s2) + "\n");
		
		// **** create a new string (uses SCP object) ****
		String s3 = "Hello World";
		System.out.println("stringObjects <<<         s3.hashCode: " + s3.hashCode());
		System.out.println("stringObjects <<< s3.identityHashCode: " + System.identityHashCode(s3) + "\n");
		
		// **** true because the objects are the same ****
		System.out.println("stringObjects <<< s2 == s3: " + (s2 == s3) + "\n");
		
		// **** generate count of objects ****
		int count = 0;
		if (s1 == s2)
			count = 1;
		else
			count = 2;
		
		if (s2 != s3)
			count++;
		
		// **** ****
		return count;
	}
	
	/*
	 * The main difference between ArrayList and HashSet is that 
	 * the first is a List implementation while the second is a Set implementation. 
	 */
	static void arrayListAndHashSet() {
		
		final int	MAX_ENTRIES	= 11;
		
		// **** instantiate an array list object ****
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		// **** insert data into the array list ****
		for (int i = 0; i < MAX_ENTRIES; i++)
			al.add(i % 5);
		
		// **** display data ****
		System.out.println("arrayListAndHashSet <<< al.size(): " + al.size());
		System.out.println("arrayListAndHashSet <<<        al: " + al.toString());
		
		
		// **** iterate through the data ****
		int remove = 0;
		
		Iterator<Integer> it = al.iterator();
		System.out.print("arrayListAndHashSet <<<        al: [");
		
		try {
			while (it.hasNext()) {
				
				// **** ****
				int val = it.next();
				if (it.hasNext())
					System.out.print(val + ", ");
				else
					System.out.print(val);
				
//				// **** remove an element from the array list  ****
//				if (remove == 2) {
//					val = al.remove(2);
//					System.out.println("\narrayListAndHashSet <<< remove(4): " + val);
//				}
				
				// **** increment counter ****
				remove++;
			}
		} catch (ConcurrentModificationException e) {
			System.err.println("\narrayListAndHashSet <<< EXCEPTION message: " + e.toString());
		}
		System.out.println("]");

		// **** iterate through the data (index elements) ****
		System.out.print("arrayListAndHashSet <<<        al: [");
		for (int i = 0; i < al.size(); i++) {
			if (i < al.size() - 1)
				System.out.print(al.get(i) + ", ");
			else
				System.out.print(al.get(i));
		}
		System.out.println("]");
		System.out.println();
		
		// **** find an element ****
		Boolean found = al.contains(3);
		System.out.println("arrayListAndHashSet <<< 3 found: " + found);

		found = al.contains(9);
		System.out.println("arrayListAndHashSet <<< 9 found: " + found);
		System.out.println();

		
		// **** instantiate a hash set object ****
		HashSet<Integer> hs = new HashSet<Integer>();
		
		// **** insert data into the hash set (no duplicates) ****
		for (int i = 0; i < MAX_ENTRIES; i++)
			if (hs.add(i % 5))
				System.out.println("arrayListAndHashSet <<< i % 5: " + (i % 5) + " inserted");
		
		// **** display data ****
		System.out.println("arrayListAndHashSet <<< hs.size(): " + hs.size());
		System.out.println("arrayListAndHashSet <<<        hs: " + hs.toString());
		
		// **** iterate through the data ****
		remove = 0;

		it = hs.iterator();
		System.out.print("arrayListAndHashSet <<<        hs: [");
		
		try {
			while (it.hasNext()) {
				int val = it.next();
				if (it.hasNext())
					System.out.print(val + ", ");
				else
					System.out.print(val);
				
//				// **** remove an element from the hash set  ****
//				if (remove == 2) {
//					if (hs.remove(4))
//					System.out.println("\narrayListAndHashSet <<< remove(4): " + val);
//				}
				
				// **** increment counter ****
				remove++;
			}
		
		} catch (ConcurrentModificationException e) {
			System.err.println("\narrayListAndHashSet <<< EXCEPTION message: " + e.toString());
		}
					
		System.out.println("]");
		System.out.println();
		
		// **** find an element ****
		found = hs.contains(3);
		System.out.println("arrayListAndHashSet <<< 3 found: " + found);

		found = hs.contains(9);
		System.out.println("arrayListAndHashSet <<< 9 found: " + found);
		System.out.println();
	}
	
	/*
	 * double check locking in Singleton
	 * no longer needed after Java 1.5
	 */
	static void dclSingleton() {
		
		// **** instantiate the singleton ****
		DCLSingleton w = DCLSingleton.getSingleInstance();
		System.out.println("dclSingleton <<< w.str ==>" + w.str + "<==");
		
		// ***** instantiate the singleton ****
		DCLSingleton x = DCLSingleton.getSingleInstance();
		
		// **** alter the string ****
		x.str = x.str.toUpperCase();
		System.out.println("dclSingleton <<< x.str ==>" + x.str + "<==");
		
		// **** w and x refer to the same instance ****
		System.out.println("dclSingleton <<< w.str ==>" + w.str + "<==");
		System.out.println();
	}
	
	/*
	 * Thread safe singleton
	 */
	static void threadSafeSingleton() {
		
		// **** instantiate the singleton ****
		Singleton w = Singleton.getSingleInstance();
		System.out.println("threadSafeSingleton <<< w.str ==>" + w.str + "<==");
		
		// ***** instantiate the singleton ****
		Singleton x = Singleton.getSingleInstance();
		
		// **** alter the string ****
		x.str = x.str.toUpperCase();
		System.out.println("threadSafeSingleton <<< x.str ==>" + x.str + "<==");
		
		// **** w and x refer to the same instance ****
		System.out.println("threadSafeSingleton <<< w.str ==>" + w.str + "<==");
		System.out.println();
	}
	
	/*
	 * Volatile variable.
	 * Volatile has semantics for memory visibility.
	 * Basically, the value of a volatile field becomes visible to all readers 
	 * (other threads in particular) after a write operation completes on it. 
	 * Without volatile, readers could see some non-updated value.
	 */
	static void volatileVariable() {
		
		// Ensures that the value should always be read from main memory and a thread 
		// should not use the cached value of that variable from their own stack.
		
		// **** create and start my thread ****
		MyThread myThread = new MyThread();
		myThread.start();
		
		// **** wait for a few seconds ****
		try {
			System.out.println("volatileVariable <<< waiting...");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("volatileVariable <<< awake!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// **** stop the thread ****
		myThread.die();
	}
	
	/*
	 * Transient test
	 */
	static void transientTest() {
		
		// **** ****
		Book oldBook = null;
		
		// **** create a book ****
		Book book = new Book(7007007, "To Live and Let Die", "Ian Fleming", 3);
//		Book book = new Book(7007007, "To Live and Let Die", "Ian Fleming");
		
		// **** ****
		final String fileName = "c:\\temp\\book.ser";
		
		// **** ****
		try {
			
			// **** serialize ****
			FileOutputStream fos 	= new FileOutputStream(fileName);
	        ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			oos.writeObject(book);
			
			// **** close streams ****
			oos.close();
			fos.close();
			
			// ???? ????
			System.out.println("transientTest <<< book serialized");
			
			// **** deserialize ****
            FileInputStream fis 	= new FileInputStream(fileName);
            ObjectInputStream ois 	= new ObjectInputStream(fis);
            oldBook = (Book)ois.readObject();
            
            // **** close streams ****
            ois.close();
            fis.close();

			// ???? ????
			System.out.println("transientTest <<< book deserialized"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// **** display books ****
		System.out.println("transientTest <<<    book: " + book.toString());
		System.out.println("transientTest <<< oldBook: " + oldBook.toString());
	}
	
	/*
	 * Externalizable test.
	 * 
	 * When an Externalizable object is reconstructed, 
	 * an instance is created first using the public no-argument constructor, 
	 * then readExternal method is called.
	 * 
	 * When an object implements the Serializable interface, 
	 * no constructor is called and hence any initialization 
	 * which is implemented in constructor can not be done.
	 */
	static void externalizableTest() {
		
		// **** ****
		ExtBook oldBook = null;
		
		// **** create a book ****
		ExtBook book = new ExtBook(7007007, "To Live and Let Die", "Ian Fleming", 3);
		
		// **** name for file ****
		final String fileName = "c:\\temp\\book.ext";
		
		// **** serialize book ****
		try {
			FileOutputStream fos 	= new FileOutputStream(fileName);
			ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			oos.writeObject(book);
			oos.flush();
			
			// **** close streams ****
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("externalizableTest <<< EXCEPTION serializing");
			System.exit(-1);
		}
		
		// ???? ????
		System.out.println("externalizableTest <<< book serialized");
					
		// **** deserialize book ****
		try {
			
            FileInputStream fis 	= new FileInputStream(fileName);
            ObjectInputStream ois 	= new ObjectInputStream(fis);
            oldBook = (ExtBook)ois.readObject();
            
            // **** close streams ****
            ois.close();
            fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("externalizableTest <<< EXCEPTION deserializing");
			System.exit(-1);
		}
		
		// ???? ????
		System.out.println("externalizableTest <<< book deserialized"); 

		// **** display books ****
		System.out.println("externalizableTest <<<    book: " + book.toString());
		System.out.println("externalizableTest <<< oldBook: " + oldBook.toString());
	}
	
	/*
	 * Test scaffold.
	 */
	public static void main(String[] args) {

		// **** open scanner ****
		Scanner sc = new Scanner(System.in);
		
		// **** Q0. How many String Objects are created?  1, 2, or 3 ****
		System.out.println("main <<< String s1 = new String(\"Hello World\") stringObjects: " + stringObjects());

		// **** Q3. Write a Java program to check if a number is Even or Odd? ****
		System.out.print("\nmain >>> n: ");
		int n = Integer.parseInt(sc.next());
		
		System.out.println("main <<< n: " + n + " is " + (((n % 2) == 0) ? "even" : "odd"));
		System.out.println("main <<< n: " + n + " is " + ((((n / 2) * 2) == n) ? "even" : "odd"));
		System.out.println("main <<< n: " + n + " is " + (((n & 1) == 0) ? "even" : "odd"));
		
		int ns = n >> 1;
		ns = ns << 1;
		System.out.println("main <<< n: " + n + " is " + ((n == ns) ? "even" : "odd"));
		
		// **** Q4. Difference between ArrayList and HashSet? ****
		System.out.println();
		arrayListAndHashSet();
		
		// **** Q5. What is double checked locking in Singleton? ****
		dclSingleton();
		
		// **** Q6. How do you create thread-safe Singleton? ****
		threadSafeSingleton();
		
		// **** Q7. When to use the volatile (synchronization) variable? ****
		volatileVariable();
		System.out.println();
		
		// **** Q8. When to use a transient (Serialization) variable? ****
		transientTest();
		System.out.println();
		
		
		
		
		// **** Q10. Difference between Serializable (Q8) and Externalizable? ****
		externalizableTest();

		// **** close scanner ****
		sc.close();
	}

}
