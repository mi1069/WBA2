
package org.example.aufgabe4;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.example.aufgabe4.*;



public class RezepteMain {

	private static final String REZEPT_XML = "./src/Rezepte.xml";

	public static void main(String[] args) throws JAXBException, IOException {

		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(CollectionType.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");
		Unmarshaller um = context.createUnmarshaller();
		CollectionType collection = (CollectionType ) um.unmarshal(new FileInputStream(REZEPT_XML));
		for (RezeptType rezept : collection.getRezept()) {
			System.out.println("Rezept: " + rezept.rezeptId);
			System.out.println("Titel: " + rezept.title);

		}
	}
}