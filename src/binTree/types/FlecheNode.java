package binTree.types;

import binTree.Node;
import binTree.Tree;

public class FlecheNode extends Node implements Type {

	public FlecheNode(Type left, Type right) {
		super(left, right, "->");
	}

}
