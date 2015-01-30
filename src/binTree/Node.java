package binTree;

public class Node implements Tree {

	protected Tree leftNode_ = null;
	protected Tree rightNode_ = null;
	protected String value_ = null;

	public Node(Tree left, Tree right, String value) {
		this.leftNode_ = left;
		this.rightNode_ = right;
		this.value_ = value;
	}

	/* Getters */

	public Tree getLeftNode() {
		return this.leftNode_;
	}

	public Tree getRightNode() {
		return this.rightNode_;
	}

	public String getValue() {
		return this.value_;
	}

	public int getSize() {
		return 1 + this.leftNode_.getSize() + this.rightNode_.getSize();
	}

	public String toString() {
		return "(" + this.leftNode_ + this.value_ + this.rightNode_ + ")";
	}

}
