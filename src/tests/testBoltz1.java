package tests;

import boltzmannV1.GenerateurTypes;
import binTree.*;

public class testBoltz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateurTypes gen = new GenerateurTypes(0.24999);
		Tree generatedTree = gen.generate();
		System.out.println(generatedTree);
	}
}
