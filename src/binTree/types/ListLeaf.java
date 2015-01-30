package binTree.types;

import java.util.Map;

import binTree.Leaf;
import binTree.termes.Terme;

public class ListLeaf extends Leaf implements Type {
	
	public ListLeaf () {
		super ("List[Int]");
	}

	@Override
	public Terme generateMinTermeV1() {
		return null;
	}

	@Override
	public Terme generateMinTermeV1(Map<String, Type> vars) {
		return null;
	}

}
