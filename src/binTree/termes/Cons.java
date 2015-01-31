package binTree.termes;

import binTree.Node;

public class Cons extends Node implements Terme {

	public Cons(Terme left, Terme right) {
		super(left, right, "cons");
	}

	public String toString() {
		return this.value_ + this.leftNode_ + this.rightNode_;
	}

}
