package binTree.termes;

import binTree.Node;

public class Tail extends Node implements Terme {

	public Tail(Terme t) {
		super(t, null, "tail");
	}

	public int getSize() {
		return 1 + this.leftNode_.getSize();
	}

	public String toString() {
		return this.value_ + this.leftNode_;
	}

	@Override
	public String toScheme() {
		return "(cdr "+((Terme)leftNode_).toScheme()+")";
	}
}
