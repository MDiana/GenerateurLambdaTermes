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
	 *            : B(z) = 1 + 1 + B²(z)
	 * @throws InvalidAttributeValueException
	 */
	public GenerateurTypesV3(double z) throws InvalidAttributeValueException {
		// TODO
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
