package binTree.termes;

import binTree.Leaf;

public class Constante extends Leaf implements Terme {

	public Constante(int value) {
		super(String.valueOf(value));
	}

	public static Constante getIntConstAleas() {
		return new Constante((int) (Math.random() * 10));
	}

	public static Constante getListConstAleas() {
		// TODO : Generate a random list
		return null;
	}

}
