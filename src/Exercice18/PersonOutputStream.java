package Exercice18;


import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersonOutputStream extends FileOutputStream  {

	FileOutputStream fos;
	public PersonOutputStream(FileOutputStream fos)  {
		super(FileDescriptor.in);
		this.fos = fos;
	}

	//Fonction qui enregistre directement la liste des personne dans un ficher
	
	void writePeople(List<Person> people) {
		
		try (FileOutputStream fos = this.fos ;
			 ObjectOutputStream oos = new ObjectOutputStream(fos);) {
				
			oos.writeObject(people);
				
				
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}
}
