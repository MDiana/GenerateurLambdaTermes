package binTree.types;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

import typeGenerators.GenerateurTypesV1;
import binTree.Node;
import binTree.termes.Abstraction;
import binTree.termes.Application;
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

	public Terme generateTermeV1(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV1(minSize, new HashMap<String, Type>());
	}

	@Override
	public Terme generateTermeV1(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {

		if (minSize < this.getSize()) {
			throw new InvalidAttributeValueException("Min size is "
					+ this.getSize());
		}

		GenerateurTypesV1 generator = new GenerateurTypesV1(1.0 / 4 - 1e-8);
		int tailleNewType = minSize - this.getSize();

		Type newType = generator.generate(tailleNewType);

		Terme res = (new FlecheNode(newType, this)).generateMinTerme();

		return new Application(res, newType.generateMinTerme());

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
