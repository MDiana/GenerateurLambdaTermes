package tests;

import typeGenerators.GenerateurTypesV1;
import binTree.termes.Terme;
import binTree.types.Type;

public class TestBoltz2 {

	public static void main(String[] args) {

		try {

			GenerateurTypesV1 typeGenerator = new GenerateurTypesV1(0.24999);
			Type typeTree = null;
			do {
				typeTree = typeGenerator.generate();
			} while (typeTree.getSize() < 5);
			System.out.println("Type, size " + typeTree.getSize() + " :");
			System.out.println(typeTree);

			Terme termeTree = typeTree.generateMinTerme();
			int minSize = termeTree.getSize();
			System.out.println("Minimal term :");
			System.out.println(termeTree);

			termeTree = typeTree.generateTermeV2(minSize + 5);
			System.out.println("Term:");
			System.out.println(termeTree);

		} catch (Exception e) {

		}

	}

}
