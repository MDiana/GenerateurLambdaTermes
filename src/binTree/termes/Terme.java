package binTree.termes;

import binTree.*;

public interface Terme extends Tree {

	/**
	 * Generates a Scheme program for the term
	 * @return a String which is a Scheme representation of this term
	 */
	public String toScheme();
	
}
