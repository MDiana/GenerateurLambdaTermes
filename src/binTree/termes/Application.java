package binTree.termes;

import binTree.Node;
import binTree.types.Type;

public class Application extends Node implements Type {

	public Application(Terme func, Terme t) {
		super(func, t, null);
	}

}
