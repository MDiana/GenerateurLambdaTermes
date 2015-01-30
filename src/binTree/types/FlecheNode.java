package binTree.types;

import java.util.HashMap;
import java.util.Map;

import binTree.Node;
import binTree.termes.Abstraction;
import binTree.termes.Terme;

public class FlecheNode extends Node implements Type {

	public FlecheNode(Type left, Type right) {
		super(left, right, "->");
	}

	public Terme generateMinTermeV1() {
		return this.generateMinTermeV1(new HashMap<String, Type>());
	}

	public Terme generateMinTermeV1(Map<String, Type> vars) {
		String var = "x" + vars.size();
		vars.put(var, (Type) this.getLeftNode());
		return new Abstraction(var, (Type) this.getLeftNode(),
				((Type) this.rightNode_).generateMinTermeV1(vars));
	}
}
