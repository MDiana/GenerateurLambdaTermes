package binTree;

public class Leaf implements Tree {

	protected String value_ = null;

	public Leaf(String value) {
		this.value_ = value;
	}

	/* Getters */

	public String getValue() {
		return this.value_;
	}

	public int getSize() {
		return 0;
	}

	public String toString() {
		return this.value_;
	}

}
