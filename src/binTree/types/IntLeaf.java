package binTree.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

import binTree.Leaf;
import binTree.termes.Cons;
import binTree.termes.Constante;
import binTree.termes.Head;
import binTree.termes.Opposite;
import binTree.termes.Sum;
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

	public Terme generateTermeV1(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV1(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV1(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {
		if (minSize != 0) {
			throw new InvalidAttributeValueException();
		}
		return this.generateMinTerme(vars);
	}

	public Terme generateTermeV2(int minSize) {
		return this.generateTermeV2(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV2(int minSize, Map<String, Type> vars) {
		if (minSize == 0) {
			// Return Constante or Variable
			return this.generateMinTerme(vars);
		} else {
			// Return + or -
			double rand = Math.random();
			if (rand < 0.5) {
				int size = (int) (Math.random() * minSize);
				return new Sum(this.generateTermeV2(size, vars),
						this.generateTermeV2(minSize - size, vars));
			} else {
				return new Opposite(this.generateTermeV2(minSize - 1, vars));
			}
		}
	}

	public Terme generateTermeV3(int minSize) {
		return this.generateTermeV3(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV3(int minSize, Map<String, Type> vars) {
		if (minSize <= 0) {
			// Return constante or variable
			return this.generateMinTerme(vars);
		} else {
			// Return +, - or head
			double rand = Math.random();
			if (rand < 1.0 / 3) {
				int size = (int) (Math.random() * minSize);
				return new Sum(this.generateTermeV3(size, vars),
						this.generateTermeV3(minSize - size, vars));
			} else if (rand < 2.0 / 3) {
				return new Opposite(this.generateTermeV3(minSize - 1, vars));
			} else {
				int intSize = (int) (Math.random() * (minSize - 2));
				return new Head(new Cons(this.generateTermeV3(intSize, vars),
						(new ListLeaf()).generateTermeV3(minSize - intSize - 2,
								vars, false)));
			}
		}
	}
}
