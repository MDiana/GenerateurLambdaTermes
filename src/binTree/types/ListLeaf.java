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

	@Override
	public Terme generateTermeV1(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV1(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateMinTermeV2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateMinTermeV2(Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV2(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV2(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateMinTermeV3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateMinTermeV3(Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV3(int minSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme generateTermeV3(int minSize, Map<String, Type> vars) {
		// TODO Auto-generated method stub
		return null;
	}

}
