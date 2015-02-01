package binTree.termes;

import binTree.Node;

public class Application extends Node implements Terme {

	public Application(Terme func, Terme t) {
		super(func, t, null);
	}

	public int size() {
		return 1 + this.rightNode_.getSize();
	}

	public String toString() {
		return "( (" + this.leftNode_ + ") (" + this.rightNode_ + ") )";
	}

	@Override
	public String toScheme() {
		return "(" + ((Terme)leftNode_).toScheme() + " " + ((Terme)rightNode_).toScheme() + ")";
	}

}
