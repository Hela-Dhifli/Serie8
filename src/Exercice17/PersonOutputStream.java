package Exercice17;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonOutputStream  extends FileOutputStream {


		// DataOutputStream pour ecrire les types primitifs 
		//Cette fonction prend en parametre une personne et retourne un tableau d'octets 
		//contenant le nom, le prenom et l'age de la personne en octet
	
	public Function <Person, byte[]> personToByte = (Person p) -> {
		
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream (bos);) {
			
			dos.writeUTF(p.getLastName());
			dos.writeUTF(p.getFirstName());
			dos.writeInt(p.getAge());
			
			dos.flush();
			return (bos.toByteArray());
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return (null);
	};
	
	
	
		//Question 2 : PersonOutputStream, en tant une decoration de FileOutputStream
		//Le constructeur doit prendre en parametre FileOutputStream
	FileOutputStream fos ; 
	
	public PersonOutputStream (FileOutputStream fos)  {
		super(FileDescriptor.in);
		this.fos = fos ;
	}
	 
	 
	 	//Question 3
	 
	 void writeFields (List<Person> listPerson1) {
		 
		 int numberPerson = listPerson1.size();
		 
		 try (FileOutputStream fos = this.fos ;
			   BufferedOutputStream bos = new BufferedOutputStream(fos);
			    DataOutputStream dos1 = new DataOutputStream(bos);) {
			 
			 dos1.writeInt(numberPerson); //ecrire le nombre de personnes pr�sentes dans la liste
			 for (Person p : listPerson1) //ecrire les champs de chaque personne
				 dos1.write(personToByte.apply(p));
		 
		 } catch (IOException e1) {
			 System.out.println(e1);
		 }
		 
	 }
}
