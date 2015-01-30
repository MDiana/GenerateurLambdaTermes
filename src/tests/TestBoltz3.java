package tests;

import typeGenerators.GenerateurTypesV3;
import binTree.termes.Terme;
import binTree.types.Type;

public class TestBoltz3 {

	public static void main(String[] args) {

		try {

			GenerateurTypesV3 typeGenerator = new GenerateurTypesV3(0.24999);
			Type typeTree = null;
			do {
				typeTree = typeGenerator.generate();
			} while (typeTree.getSize() < 5);
			System.out.println("Type, size " + typeTree.getSize() + " :");
			System.out.println(typeTree);

			Terme termeTree = typeTree.generateMinTermeV3();
			int minSize = termeTree.getSize();
			System.out.println("Minimal term :");
			System.out.println(termeTree);

			termeTree = typeTree.generateTermeV3(minSize + 5);
			System.out.println("Term:");
			System.out.println(termeTree);

		} catch (Exception e) {

		}

	}

}
