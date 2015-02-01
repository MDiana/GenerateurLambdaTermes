package typeGenerators;

import javax.naming.directory.InvalidAttributeValueException;

import binTree.types.FlecheNode;
import binTree.types.IntLeaf;
import binTree.types.ListLeaf;
import binTree.types.Type;

/**
 * 
 * @author Érika Baëna
 * @author Willian Chasson
 * @author Diana Malabard
 *
 */
public class GenerateurTypesV3 {

	private double z_ = 0;
	private double probaInt_ = 0;
	private double probaList_ = 0;

	/**
	 * 
	 * @param z
	 *            : B(z) = 1 + 1 + zB²(z)
	 * @throws InvalidAttributeValueException
	 */
	public GenerateurTypesV3(double z) throws InvalidAttributeValueException {
		if (z <= 0 || z > (1.0 / 8)) {
			throw new InvalidAttributeValueException("z in ]0; 1/8[ ; not " + z);
		}
		this.z_ = z;
		this.probaInt_ = (2 * this.z_) / (1 - Math.sqrt(1 - 8 * this.z_));
		this.probaList_ = this.probaInt_;

	}

	public Type generate(int minSize) {
		Type t = null;
		do {
			t = generate();
		} while (t.getSize() < minSize);
		return t;
	}

	public Type generate() {
		double rand = Math.random();
		if (rand < this.probaInt_) {
			return new IntLeaf();
		} else if (rand < (this.probaInt_ + this.probaList_)) {
			return new ListLeaf();
		} else {
			return new FlecheNode(this.generate(), this.generate());
		}
	}

}
