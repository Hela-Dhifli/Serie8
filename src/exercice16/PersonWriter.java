package exercice16;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {

	//constructeur
	
	public PersonWriter() {
		
	}
	
	//fonction qui prend en parametre une personne
	//retourne la chaine contenat les valeurs des proprietes de personne 
	
	Function <Person, String> personToString = (Person person) -> {
		
		String lineFile = person.getLastName() + ", " + person.getFirstName() + ", " + person.getAge() ;
		return (lineFile);
		
	};
	
	// fonction qui prend en parametre une liste de personnes 
	//ecrit cette liste dans un fichier passé en parametre
	
	void write( List<Person> people, String fileName) {
		
		File fileOfPerson = new File (fileName);
		
		try (Writer writer = new FileWriter(fileOfPerson); 
				 BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
			
			for (Person p : people) {
				bufferedWriter.write(personToString.apply(p));
				bufferedWriter.write("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
