package tests;

import typeGenerators.GenerateurTypesV1;
import binTree.termes.Terme;
import binTree.types.Type;

public class TestBoltz2 {

	public static void main(String[] args) {

		try {
			double z = 1.0 / 4 - 1e-8;
			GenerateurTypesV1 typeGenerator = new GenerateurTypesV1(z);
			Type typeTree = typeGenerator.generate(5);

			Terme termeTree = typeTree.generateMinTerme();
			int minSize = termeTree.getSize();
			System.out.println("Minimal term :");
			System.out.println(termeTree);

			termeTree = typeTree.generateTermeV2(minSize + 5);
			System.out.println("Term, size " + termeTree.getSize() + " :");
			System.out.println(termeTree);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
