package exercice16;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//test PersonReader
	System.out.println("************** Test PersonReader **************\n");
	
	PersonReader pReader = new PersonReader();
	
	List<Person> read = pReader.read("Files/Person.txt");
	read.forEach(t -> System.out.println(t));	
	
	
	
		//test PersonWriter
	System.out.println("\n************** Test PersonWriter **************\n");
	
	List<Person> listPerson = List.of(
			new Person("Deschamps", "Didier", 51),
			new Person("Jacquet", "Aime", 79),
			new Person("Thuram", "Lilian", 48),
			new Person("Barthez", "Fabien", 49),
			new Person("Zidane", "Zinedine", 47));
	PersonWriter pReader2 = new PersonWriter();
	
	pReader2.write(listPerson, "Files/personWriter.txt");
	
	}
}
