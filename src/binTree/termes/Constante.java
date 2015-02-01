package binTree.termes;

import binTree.Leaf;

public class Constante extends Leaf implements Terme {

	private Constante(int value) {
		super(String.valueOf(value));
	}

	private Constante(String value) {
		super(value);
	}

	public static Constante getIntConstAleas() {
		return new Constante((int) (Math.random() * 11));
	}

	public static Constante getListConst() {
		return new Constante("nil");
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
