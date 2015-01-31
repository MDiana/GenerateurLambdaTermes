package binTree.termes;

import binTree.Node;

public class Sum extends Node implements Terme {

	public Sum(Terme t1, Terme t2) {
		super(t1, t2, "+");
	}

	public String toString() {
		return this.leftNode_ + this.value_ + this.rightNode_;
	}

}
