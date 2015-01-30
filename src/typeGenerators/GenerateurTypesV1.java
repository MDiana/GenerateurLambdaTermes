package typeGenerators;

import javax.naming.directory.InvalidAttributeValueException;

import binTree.types.FlecheNode;
import binTree.types.IntLeaf;
import binTree.types.Type;

public class GenerateurTypesV1 {

	private double z_ = 0;
	private double probaFeuille = 0;

	/**
	 * 
	 * @param z
	 *            : B(z) = 1 + zB²(z)
	 * @throws InvalidAttributeValueException
	 */
	public GenerateurTypesV1(double z) throws InvalidAttributeValueException {
		if (z <= 0 || z > 0.25) {
			throw new InvalidAttributeValueException();
		}
		this.z_ = z;
		this.probaFeuille = (2 * this.z_) / (1 - Math.sqrt(1 - 4 * this.z_));
		System.err.println(this.probaFeuille);
	}

	public Type generate() {
		double rand = Math.random();
		if (rand < this.probaFeuille) {
			return new IntLeaf();
		} else {
			return new FlecheNode(this.generate(), this.generate());
		}
	}

}
