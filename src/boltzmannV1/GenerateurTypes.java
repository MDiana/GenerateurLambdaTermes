package boltzmannV1;

import javax.naming.directory.InvalidAttributeValueException;

import binTree.*;
import binTree.types.FlecheNode;
import binTree.types.IntLeaf;

public class GenerateurTypes {

	private double z_ = 0;
	private double probaFeuille = 0;

	/**
	 * 
	 * @param z
	 *            : B(z) = 1 + zB²(z)
	 * @throws InvalidAttributeValueException
	 */
	public GenerateurTypes(double z) throws InvalidAttributeValueException {
		if (z <= 0 || z > 0.25) {
			throw new InvalidAttributeValueException();
		}
		this.z_ = z;
		this.probaFeuille = (2 * this.z_) / (1 - Math.sqrt(1 - 4 * this.z_));
		System.err.println(this.probaFeuille);
	}

	public Tree generate() {
		double rand = Math.random();
		if (rand < this.probaFeuille) {
			return new IntLeaf();
		} else {
			return new FlecheNode(this.generate(), this.generate());
		}
	}

}
