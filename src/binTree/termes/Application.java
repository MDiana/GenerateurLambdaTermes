package binTree.termes;

import java.util.Map;

import binTree.Node;
import binTree.types.Type;

public class Application extends Node implements Type {

	public Application(Terme func, Terme t) {
		super(func, t, null);
	}

	public int size() {
		return 1 + this.rightNode_.getSize();
	}

	@Override
	public Terme generateMinTermeV1() {
		return null;
	}

	@Override
	public Terme generateMinTermeV1(Map<String, Type> vars) {
		return null;
	}

	public String toString() {
		return "( (" + this.leftNode_ + ") (" + this.rightNode_ + ") )";
	}

}
