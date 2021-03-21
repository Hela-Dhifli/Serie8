package Exercice18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;



public class Main {

	public static void main(String[] args) {
		
		//Question 1 : Quel flux doit-on utiliser pour �crire les objets Java dans des fichiers binaires ?
			
			//On doit utiliser ObjectInputStream et ObjectOutputStream
		
		// Question 2 : Comment doit-on modifier la classe Person pour �crire ses instances directement dans u fichier binaire ?
		
			// la classe Person doit implementer l'interface serializable 
		
		
		// Question 5
		
		//Ecriture
		List<Person> listPerson = List.of(
				new Person("Deschamps", "Didier", 51),
				new Person("Jacquet", "Aime", 79),
				new Person("Thuram", "Lilian", 48),
				new Person("Barthez", "Fabien", 49),
				new Person("Zidane", "Zinedine", 47));
		
		try (FileOutputStream fos = new FileOutputStream  ("Files/personWithObject.bin");
			 PersonOutputStream pos = new PersonOutputStream(fos) ;) {
		
			pos.writePeople(listPerson);
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//Lecture
		try (FileInputStream fis = new FileInputStream  ("Files/personWithObject.bin");
			PersonInputStream pis = new PersonInputStream(fis) ;) {
		
			List<Person> readPeople = pis.readPeople();
			readPeople.forEach(t -> System.out.println(t));
		
		} catch (IOException e) {
			System.out.println(e);
		}
	
	}
}
