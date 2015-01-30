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

	public Terme generateMinTerme() {
		return this.generateMinTerme(new HashMap<String, Type>());
	}

	public Terme generateMinTerme(Map<String, Type> vars) {
		String var = "x" + vars.size();
		vars.put(var, (Type) this.getLeftNode());
		return new Abstraction(var, (Type) this.getLeftNode(),
				((Type) this.rightNode_).generateMinTerme(vars));
	}

	@Override
	public Terme generateTermeV1(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV1(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV2(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV2(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV3(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV3(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}
}
