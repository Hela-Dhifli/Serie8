package Exercice17;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;

public class PersonInputStream extends FileInputStream {

		//PersonInputStream  decoration de FileInputStream
	FileInputStream fis;
	public PersonInputStream (FileInputStream fis)  {
			super(FileDescriptor.in);
			this.fis = fis;
		}
	
	
		//Methode qui lit le contenu d'un fichier et retourne une liste de personne
		//enregistre dans le fihcier
	
	 public List<Person> readFields() {
		 int nbLigne = 0 ;
		 
		 try (FileInputStream fis = this.fis;
			  ByteArrayInputStream is = new ByteArrayInputStream(fis.readAllBytes());
			  DataInputStream dis = new DataInputStream (is);) {
				 
				nbLigne = dis.readInt();
				List<Person> listOfPerson = new ArrayList<>();
				for(int i=0 ; i< nbLigne ; i++) {
					String firstName = dis.readUTF();
					String lastName = dis.readUTF();
					int age = dis.readInt();
					Person p = new Person (firstName, lastName, age);
					listOfPerson.add(p);
				}
				
				return (listOfPerson);
			 
			 } catch (IOException e1) {
				 System.out.println(e1);
			 }
		 return null;
	 }
}
