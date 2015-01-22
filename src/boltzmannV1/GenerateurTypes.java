package boltzmannV1;

import binTree.*;

public class GenerateurTypes {

	private double z_ = 0;
	private double probaFeuille = 0;

	/**
	 * 
	 * @param z
	 *            : B(z) = 1 + zB²(z)
	 */
	public GenerateurTypes(double z) {
		this.z_ = z;
		this.probaFeuille = (2 * this.z_) / (1 - Math.sqrt(1 - 4 * this.z_));
		System.err.println(this.probaFeuille);
	}

	public Tree generate() {
		double rand = Math.random();
		if (rand < this.probaFeuille) {
			return new Leaf("Int");
		} else {
			return new Node(this.generate(), this.generate(), "->");
		}
	}

}
