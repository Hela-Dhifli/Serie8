package Exercice17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class Main {

	
	public static void main(String[] args)  {
		
		List<Person> listPerson1 = List.of(
				new Person("Deschamps", "Didier", 51),
				new Person("Jacquet", "Aime", 79),
				new Person("Thuram", "Lilian", 48),
				new Person("Barthez", "Fabien", 49),
				new Person("Zidane", "Zinedine", 47));
		
			//teste des  méthodes de PersonWriter
		
		try (FileOutputStream fos = new FileOutputStream  ("Files/fileByteOfPerson.bin");
			     PersonOutputStream pos = new PersonOutputStream(fos) ;) {
			    //ecriture dans le fichier
				pos.writeFields(listPerson1);
					
	    } catch (IOException e) {
					System.out.println(e);
		}
		

		try ( FileInputStream  fis = new FileInputStream ("Files/fileByteOfPerson.bin");
				PersonInputStream pis = new PersonInputStream (fis);) {
			
			//lecture du fichier 
			List<Person> listOfPerson = pis.readFields();
			
			//affichage du contenu du fichier
			System.out.println ("\n************ Contenu du fichier ************\n");
			listOfPerson.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
	
	}
	
}
