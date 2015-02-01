package binTree.termes;

import binTree.Node;

public class Opposite extends Node implements Terme {

	public Opposite(Terme t) {
		super(t, null, "-");
	}

	public int getSize() {
		return 1 + this.leftNode_.getSize();
	}

	public String toString() {
		return this.value_ + "(" + this.leftNode_ + ")";
	}

	@Override
	public String toScheme() {
		return "(- " + ((Terme) this.leftNode_).toScheme() + ")";
	}
}
