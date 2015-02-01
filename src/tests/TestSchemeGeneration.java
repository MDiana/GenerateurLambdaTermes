package tests;

import javax.naming.directory.InvalidAttributeValueException;

import typeGenerators.GenerateurTypesV1;
import binTree.termes.Terme;
import binTree.types.Type;

public class TestSchemeGeneration {

	public static void main(String[] args) {
		
		GenerateurTypesV1 generator;
		try {
			generator = new GenerateurTypesV1(0.24444);
			
			Type t = generator.generate();
			
			Terme term = t.generateTermeV3(3);			
			
			System.out.println(term.toScheme());
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
		}
		
	}

}
