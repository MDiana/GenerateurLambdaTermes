package binTree.termes;

import binTree.Node;
import binTree.types.Type;

public class Abstraction extends Node implements Terme {

	public Abstraction(String val, Type tau, Terme M) {
		super(tau, M, val);
	}

	public String toString() {
		return "λ" + this.value_ + ":" + this.leftNode_ + ". "
				+ this.rightNode_;
	}

	public int getSize() {
		return 1 + this.rightNode_.getSize();
	}

	@Override
	public String toScheme() {
		return "(lambda (" + value_ + ") " + ((Terme) rightNode_).toScheme()
				+ ")";
	}

}
