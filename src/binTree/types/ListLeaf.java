package binTree.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

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
			return Constante.getListConst();
		} else {
			int aleas = (int) (Math.random() * listVars.size());
			return new Variable(listVars.get(aleas));
		}
	}

	public Terme generateTermeV1(int minSize)
			throws InvalidAttributeValueException {
		throw new InvalidAttributeValueException(
				"Not a right type for this grammar.");
	}

	public Terme generateTermeV1(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {
		throw new InvalidAttributeValueException(
				"Not a right type for this grammar.");
	}

	public Terme generateTermeV2(int minSize)
			throws InvalidAttributeValueException {
		throw new InvalidAttributeValueException(
				"Not a right type for this grammar.");
	}

	public Terme generateTermeV2(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {
		throw new InvalidAttributeValueException(
				"Not a right type for this grammar.");
	}

	public Terme generateTermeV3(int minSize) {
		return this.generateTermeV3(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV3(int minSize, Map<String, Type> vars) {
		return this.generateTermeV3(minSize, vars, true);
	}

	public Terme generateTermeV3(int minSize, Map<String, Type> vars,
			boolean canBeEmpty) {
		if (minSize <= 0) {
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
				if (!canBeEmpty) {
					return new Cons(Constante.getIntConstAleas(),
							Constante.getListConst());
				} else {
					return Constante.getListConst();
				}
			} else {
				int aleas = (int) (Math.random() * listVars.size());
				return new Variable(listVars.get(aleas));
			}
		} else {
			// Return tail or cons
			double rand = Math.random();
			if (rand < 0.5) {
				int intSize = (int) (Math.random() * (minSize - 2));
				return new Tail(new Cons((new IntLeaf()).generateTermeV3(
						intSize, vars), this.generateTermeV3(minSize - intSize
						- 2, vars, false)));
			} else {
				int intSize = (int) (Math.random() * minSize);
				Terme i = (new IntLeaf()).generateTermeV3(intSize, vars);
				return new Cons(i,
						this.generateTermeV3(minSize - intSize, vars));
			}
		}
	}
}
