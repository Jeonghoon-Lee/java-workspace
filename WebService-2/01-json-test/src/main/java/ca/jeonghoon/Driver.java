package ca.jeonghoon;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 1- Create a new Java Project
 * 2- Convert it to Maven Project
 * 3- Add Dependencies in pom.xml
 * 4- Create a folder in project root which contains the JSON files
 * 5- Create Model Object
 * 6- Create a class to use ObjectMapper from Jackson project to convert JSON to Java object
 * */
public class Driver {

	public static void main(String[] args) {
		try {

			// 1- Create Object Mapper
			ObjectMapper mapper = new ObjectMapper();

			// JSON with nested object
			// 2- Read JSON file and map/convert to Java POJO from a path: data/sample-lite.json
			//    Unrecognized field "address" if setter and getter missed or Address class does not exist
			Student studentAddressFromJSON = mapper.readValue(new File("data/sample-full.json"), Student.class); 

			// 3- Print first name, last name and address
			System.out.println("First name = " + studentAddressFromJSON.getFirstName());
			System.out.println("Last name = " + studentAddressFromJSON.getLastName());
			System.out.println("Street = " + studentAddressFromJSON.getAddress().getStreet());

			for (String language : studentAddressFromJSON.getLanguages()) {
				System.out.println(language);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
