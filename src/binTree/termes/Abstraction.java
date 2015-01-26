package binTree.termes;

import binTree.Node;
import binTree.Tree;
import binTree.types.Type;

public class Abstraction extends Node implements Terme {

	public Abstraction(String val, Type tau, Terme M) {
		super(tau, M, "lambda " + val);
	}

}
