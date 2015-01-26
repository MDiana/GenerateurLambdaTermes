package binTree;

public class Node implements Tree {

	private Tree leftNode_ = null;
	private Tree rightNode_ = null;
	private String value_ = null;

	public Node(Tree left, Tree right, String value) {
		this.leftNode_ = left;
		this.rightNode_ = right;
		this.value_ = value;
	}

	public String toString() {
		return "( " + this.leftNode_ + this.value_ + this.rightNode_ + " )";
	}

}
