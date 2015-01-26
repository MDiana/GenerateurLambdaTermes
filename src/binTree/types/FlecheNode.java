package binTree.types;

import binTree.Node;
import binTree.Tree;

public class FlecheNode extends Node implements Type {

	public FlecheNode(Tree left, Tree right) {
		super(left, right, "->");
	}

}
