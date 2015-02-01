package binTree.termes;

import binTree.Leaf;

public class Variable extends Leaf implements Terme {
	
	public Variable (String name) {
		super(name);
	}

	@Override
	public String toScheme() {
		return value_;
	}

}
