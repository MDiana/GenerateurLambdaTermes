package binTree.termes;

import binTree.Node;

public class Cons extends Node implements Terme {

	public Cons(Terme left, Terme right) {
		super(left, right, "cons");
	}

	public String toString() {
		return this.value_ + this.leftNode_ + this.rightNode_;
	}

	@Override
	public String toScheme() {
		return "(cons "+((Terme)leftNode_).toScheme()+" "+((Terme)rightNode_).toScheme()+")";
	}

}
