package questions.canessa.com;

import java.io.Serializable;

/*
 * 
 */
public class Book implements Serializable {

	// **** ****
	private static final long serialVersionUID = 1L;
	
	// **** ****
	private int 			ISBN;
	private String 			title;
	private String 			author;
//	private int 			edition = 1;
	private transient int 	edition = 1;

	
	// **** constructor ****
	public Book (int ISBN, String title, String author, int edition) {
		this.ISBN 		= ISBN;
		this.title 		= title;
		this.author 	= author;
		this.edition	= edition;
	}
	
	// **** constructor ****
	public Book (int ISBN, String title, String author) {
		this.ISBN 		= ISBN;
		this.title 		= title;
		this.author 	= author;
	}
	
	// **** to string ****
	public String toString() {
		return "Book { ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", edition=" + edition + " }";
	}
}
