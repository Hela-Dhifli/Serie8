package Exercice18;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class PersonInputStream extends FileInputStream {
	
	FileInputStream fis;
	public PersonInputStream (FileInputStream fis)  {
		super(FileDescriptor.in);
		this.fis = fis;
	}

	List<Person> readPeople() {
		
		 try (FileInputStream fis = this.fis;
			 ObjectInputStream ois = new ObjectInputStream(fis);) {
					
			@SuppressWarnings("unchecked")
			List<Person> read = (List<Person>) ois.readObject();
			return (read);
					
		} catch (IOException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return null ;
	}

}
