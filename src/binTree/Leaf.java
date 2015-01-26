package binTree;

public class Leaf implements Tree {

	private String value_ = null;

	public Leaf(String value) {
		this.value_ = value;
	}

	public String toString() {
		return this.value_;
	}

}
