package exercice16;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;

public class PersonReader {


	// fonction qui prend en paramètre une ligne de ce fichier texte (String)  
	// et retourne une instance de Person.
	
	Function <String, Person> stringToPerson = (String line) -> {
		
		String[] lineDecoupe = line.split(", ");
		Person p = new Person (lineDecoupe[0], lineDecoupe[1], Integer.parseInt(lineDecoupe[2]));
		return (p);
		
	};
	

	// fonction qui prend en parametre un fichier
	// retourne la liste des personne contenue dans ce fichier 
	
	List <Person> read (String fileName) {
		
		File fileOfPerson = new File (fileName);
		
		try (Reader reader = new FileReader(fileOfPerson);
			 BufferedReader bufferedReader = new BufferedReader(reader);) {
			
			List<Person> listOfPerson = 
					bufferedReader.lines()
					.filter( filterCommentaire -> ! filterCommentaire.startsWith("#"))
					.map(stringToPersonLine -> stringToPerson.apply(stringToPersonLine) )
					.collect(Collectors.toList());
			return (listOfPerson);
		
	} catch (IOException e) {
			System.out.println("Erreur : " + e.getMessage());
	}
		return null;
	}
	

}
