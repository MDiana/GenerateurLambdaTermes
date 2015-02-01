package tests;

import binTree.termes.Constante;
import binTree.termes.Opposite;
import binTree.termes.Sum;
import binTree.termes.Terme;

public class TestSchemeGeneration {

	public static void main(String[] args) {
		
		Terme add = new Sum(new Constante(0), new Opposite(new Constante(1)));
		
		System.out.println(add.toScheme());
		
	}

}
