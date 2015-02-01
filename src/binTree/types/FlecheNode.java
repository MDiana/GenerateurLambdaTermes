package binTree.types;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

import typeGenerators.GenerateurTypesV1;
import typeGenerators.GenerateurTypesV3;
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

	public Terme generateTermeV2(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV2(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV2(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {

		if (minSize < this.getSize()) {
			// throw new InvalidAttributeValueException("Min size is "
			// + this.getSize() + " not " + minSize);
			minSize = this.getSize();
		}

		GenerateurTypesV1 generator = new GenerateurTypesV1(1.0 / 4 - 1e-8);
		int tailleNewType = minSize - this.getSize();

		Type newType = generator.generate(tailleNewType);

//		Terme res = (new FlecheNode(newType, this)).generateTermeV2(this
//				.getSize() + tailleNewType);
		
		Terme res = (new FlecheNode(newType, this)).generateMinTerme();

		System.err.println("minSize : " + minSize + " ; type size : "
				+ this.getSize() + " ; NT size : " + tailleNewType);
		return new Application(res, newType.generateTermeV2(tailleNewType));
	}

	// public Terme generateTermeV2(int minSize, Map<String, Type> vars)
	// throws InvalidAttributeValueException {
	//
	// if (minSize < this.getSize()) {
	// // throw new InvalidAttributeValueException("Min size is "+
	// // this.getSize());
	// minSize = this.getSize();
	// }
	//
	// GenerateurTypesV1 generator = new GenerateurTypesV1(1.0 / 4 - 1e-8);
	//
	// int abstSize = (int) (Math.random() * (minSize - this.getSize()));
	//
	// Type newType = generator.generate(abstSize, 2*abstSize);
	//
	// Terme funct = (new FlecheNode(newType, this)).generateTermeV2(minSize
	// - abstSize);
	//
	// return new Application(funct, newType.generateTermeV2(abstSize));
	// }

	public Terme generateTermeV3(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV3(minSize, new HashMap<String, Type>());
	}

	@Override
	public Terme generateTermeV3(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {

		if (minSize < this.getSize()) {
			// throw new InvalidAttributeValueException("Min size is "+
			// this.getSize());
			minSize = this.getSize();
		}

		GenerateurTypesV3 generator = new GenerateurTypesV3(1.0 / 8 - 1e-8);

		int abstSize = (int) (Math.random() * (minSize - this.getSize()));

		Type newType = generator.generate(abstSize);

		Terme funct = (new FlecheNode(newType, this)).generateTermeV3(minSize
				- abstSize);

		return new Application(funct, newType.generateTermeV3(abstSize));
	}
}
