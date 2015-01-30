package binTree.termes;

import binTree.Node;
import binTree.types.Type;

public class Abstraction extends Node implements Terme {

	public Abstraction(String val, Type tau, Terme M) {
		super(tau, M, "λ" + val);
	}

	public String toString() {
		return this.value_ + ":" + this.leftNode_ + ". " + this.rightNode_;
	}

}
