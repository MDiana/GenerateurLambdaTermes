package binTree.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binTree.Leaf;
import binTree.termes.Constante;
import binTree.termes.Terme;
import binTree.termes.Variable;

public class IntLeaf extends Leaf implements Type {

	public IntLeaf() {
		super("Int");
	}

	public Terme generateMinTerme() {
		return this.generateMinTerme(new HashMap<String, Type>());
	}

	public Terme generateMinTerme(Map<String, Type> vars) {
		List<String> intVars = new ArrayList<>();
		for (String key : vars.keySet()) {
			if (vars.get(key) instanceof IntLeaf) {
				intVars.add(key);
			}
		}
		double rand = 0;
		if (intVars.size() > 0) {
			rand = Math.random();
		}
		if (rand < 0.5) {
			return Constante.getIntConstAleas();
		} else {
			int aleas = (int) (Math.random() * intVars.size());
			return new Variable(intVars.get(aleas));
		}
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
