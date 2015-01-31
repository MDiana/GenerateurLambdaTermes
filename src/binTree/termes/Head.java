package binTree.termes;

import binTree.Node;

public class Head extends Node implements Terme {

	public Head(Terme t) {
		super(t, null, "head");
	}

	public int getSize() {
		return 1 + this.leftNode_.getSize();
	}

	public String toString() {
		return this.value_ + this.leftNode_;
	}

}
