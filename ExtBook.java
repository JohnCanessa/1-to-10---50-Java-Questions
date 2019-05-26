package questions.canessa.com;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 * 
 */
public class ExtBook implements Externalizable {

	// **** ****
	private int 	ISBN;
	private String 	title;
	private String 	author;
	private int 	edition;
	
	// **** constructor ****
	public ExtBook (int ISBN, String title, String author, int edition) {
		this.ISBN 		= ISBN;
		this.title 		= title;
		this.author 	= author;
		this.edition	= edition;
	}
	
	// **** no argument constructor ****
	public ExtBook() {
	}

	// **** write object ****
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(ISBN);
		out.writeObject(title);
		out.writeObject(author);
		out.writeInt(edition);
	}

	// **** read object ****
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		ISBN 	= in.readInt();
		title 	= (String)in.readObject();
		author 	= (String)in.readObject();
		edition	= in.readInt();
	}
	
	// **** to string ****
	public String toString() {
		return "Book { ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", edition=" + edition + " }";
	}
}
