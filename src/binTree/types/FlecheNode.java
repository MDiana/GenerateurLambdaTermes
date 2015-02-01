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
			return this.generateMinTerme();
		}

		while (true) {
			try {
				GenerateurTypesV1 generator = new GenerateurTypesV1(
						1.0 / 4 - 1e-8);
				int tailleNewType = minSize - this.getSize();

				Type newType = generator.generate(tailleNewType);

				Terme res = (new FlecheNode(newType, this)).generateMinTerme();

				return new Application(res, newType.generateMinTerme());
			} catch (Exception e) {
				// Capture rarely cases of stackOverflow
				System.err.println("Another try of generateTermeV1");
			}
		}

	}

	public Terme generateTermeV2(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV2(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV2(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {

		if (minSize < this.getSize()) {
			return this.generateMinTerme(vars);
		}
		while (true) {
			try {

				double rand = Math.random();

				if (rand < 0.5) {
					String var = "x" + vars.size();
					vars.put(var, (Type) this.getLeftNode());
					System.err.println("Abstraction");
					return new Abstraction(var, (Type) this.getLeftNode(),
							((Type) this.rightNode_).generateTermeV2(
									minSize - 1, vars));
				} else {

					int size = this.getSize();
					GenerateurTypesV1 generator = new GenerateurTypesV1(
							1.0 / 4 - 1e-8);

					int missingSize = minSize - size;

					Type newType = generator.generate(0, missingSize);
					int tailleNewType = newType.getSize();

					Terme res = (new FlecheNode(newType, this))
							.generateTermeV2(size + tailleNewType + 1);

					System.err.println("Application, NT size " + tailleNewType
							+ " ; taille gauche " + (size + tailleNewType + 1));
					return new Application(res,
							newType.generateTermeV2(tailleNewType));

				}
			} catch (Exception e) {
				// Capture rarely cases of stackOverflow
				System.err.println("Another try of generateTermeV2");
			}
		}
	}

	public Terme generateTermeV3(int minSize)
			throws InvalidAttributeValueException {
		return this.generateTermeV3(minSize, new HashMap<String, Type>());
	}

	public Terme generateTermeV3(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException {

		if (minSize < this.getSize()) {
			return this.generateMinTerme(vars);
		}

		while (true) {
			try {
				double rand = Math.random();

				if (rand < 0.5) {
					String var = "x" + vars.size();
					vars.put(var, (Type) this.getLeftNode());
					return new Abstraction(var, (Type) this.getLeftNode(),
							((Type) this.rightNode_).generateTermeV3(
									minSize - 1, vars));
				} else {

					int size = this.getSize();
					GenerateurTypesV3 generator = new GenerateurTypesV3(
							1.0 / 8 - 1e-8);

					int missingSize = minSize - size;

					Type newType = generator.generate(0, missingSize);
					int tailleNewType = newType.getSize();

					Terme res = (new FlecheNode(newType, this))
							.generateTermeV3(size + tailleNewType + 1);
					return new Application(res,
							newType.generateTermeV3(tailleNewType));

				}
			} catch (Exception e) {
				// Capture rarely cases of stackOverflow
				System.err.println("Another try of generateTermeV3");
			}
		}
	}
}
