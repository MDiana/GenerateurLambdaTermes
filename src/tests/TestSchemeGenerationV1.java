package tests;

import javax.naming.directory.InvalidAttributeValueException;

import typeGenerators.GenerateurTypesV1;
import typeGenerators.GenerateurTypesV3;
import binTree.termes.Terme;
import binTree.types.Type;

@SuppressWarnings("unused")
public class TestSchemeGenerationV1 {

	public static void main(String[] args) {

		GenerateurTypesV1 generator;
		try {
			generator = new GenerateurTypesV1(1 / 8.0 - 1e-8);

			Type t = null;
			t = generator.generate(10);

			Terme term = t.generateTermeV1(20);
			System.out.println(term.getSize());
			System.out.println(term.toScheme());
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
		}

	}
}
