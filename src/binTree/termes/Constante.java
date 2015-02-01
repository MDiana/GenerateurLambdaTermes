package binTree.termes;

import binTree.Leaf;

public class Constante extends Leaf implements Terme {

	public Constante(int value) {
		super(String.valueOf(value));
	}

	public Constante(String value) {
		super(value);
	}

	public static Constante getIntConstAleas() {
		return new Constante((int) (Math.random() * 11));
	}

	public static Constante getListConstAleas() {
		// TODO : Generate a random list
		return null;
	}

	@Override
	public String toScheme() {
		if (value_ == "nil") {
			return "[]";
		} else {
			return value_;
		}
	}

}
