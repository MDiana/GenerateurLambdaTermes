package tests;

import typeGenerators.GenerateurTypesV3;
import binTree.termes.Terme;
import binTree.types.Type;

public class TestBoltz3 {

	public static void main(String[] args) {

		try {
			double z = 1.0 / 8 - 1e-8;
			GenerateurTypesV3 typeGenerator = new GenerateurTypesV3(z);
			Type typeTree = typeGenerator.generate(5);
			System.out.println("Type, size " + typeTree.getSize() + " :");
			System.out.println(typeTree);

			Terme termeTree = typeTree.generateMinTerme();
			int minSize = termeTree.getSize();
			System.out.println("Minimal term :");
			System.out.println(termeTree);

			termeTree = typeTree.generateTermeV3(minSize + 5);
			System.out.println("Term, size " + termeTree.getSize() + " :");
			System.out.println(termeTree);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
