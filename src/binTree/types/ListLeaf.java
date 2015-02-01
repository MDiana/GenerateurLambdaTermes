package binTree.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binTree.Leaf;
import binTree.termes.Cons;
import binTree.termes.Constante;
import binTree.termes.Tail;
import binTree.termes.Terme;
import binTree.termes.Variable;

public class ListLeaf extends Leaf implements Type {

	public ListLeaf() {
		super("List[Int]");
	}

	public Terme generateMinTerme() {
		return this.generateMinTerme(new HashMap<String, Type>());
	}

	public Terme generateMinTerme(Map<String, Type> vars) {
		List<String> listVars = new ArrayList<>();
		for (String key : vars.keySet()) {
			if (vars.get(key) instanceof ListLeaf) {
				listVars.add(key);
			}
		}
		double rand = 0;
		if (listVars.size() > 0) {
			rand = Math.random();
		}
		if (rand < 0.5) {
			return Constante.getListConstAleas();
		} else {
			int aleas = (int) (Math.random() * listVars.size());
			return new Variable(listVars.get(aleas));
		}
	}

	public Terme generateTermeV1(int minSize) {
		System.err.println("Not a right type for this grammar.");
		return null;
	}

	public Terme generateTermeV1(int minSize, Map<String, Type> vars) {
		System.err.println("Not a right type for this grammar.");
		return null;
	}

	public Terme generateTermeV2(int minSize) {
		System.err.println("Not a right type for this grammar.");
		return null;
	}

	public Terme generateTermeV2(int minSize, Map<String, Type> vars) {
		System.err.println("Not a right type for this grammar.");
		return null;
	}

	public Terme generateTermeV3(int minSize) {
		return this.generateTermeV3(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV3(int minSize, Map<String, Type> vars) {
		if (minSize == 0) {
			// Return constante or variable
			List<String> listVars = new ArrayList<>();
			for (String key : vars.keySet()) {
				if (vars.get(key) instanceof ListLeaf) {
					listVars.add(key);
				}
			}
			double rand = 0;
			if (listVars.size() > 0) {
				rand = Math.random();
			}
			if (rand < 0.5) {
				return new Constante("nil");
			} else {
				int aleas = (int) (Math.random() * listVars.size());
				return new Variable(listVars.get(aleas));
			}
		} else {
			// Return tail or cons
			double rand = Math.random();
			if (rand < 0.5) {
				return new Tail(this.generateTermeV3(minSize - 1, vars));
			} else {
				int intSize = (int) (Math.random() * minSize);
				Terme i = (new IntLeaf()).generateTermeV3(intSize, vars);
				return new Cons(i,
						this.generateTermeV3(minSize - intSize, vars));
			}
		}
	}

}
