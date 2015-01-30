package tests;

import boltzmannV1.*;
import binTree.termes.Terme;
import binTree.types.Type;

public class testBoltz1 {

	public static void main(String[] args) {

		try {

			GenerateurTypes typeGenerator = new GenerateurTypes(0.24999);
			Type typeTree = null;
			do {
				typeTree = typeGenerator.generate();
			} while (typeTree.getSize() < 5);
			System.out.println(typeTree);

			// GenerateurTerme termesGenerator = new GenerateurTerme(typeTree);
			// Terme termeTree = termesGenerator.generate();
			Terme termeTree = typeTree.generateMinTermeV1();
			System.out.println(termeTree);

		} catch (Exception e) {

		}

	}

}
