package binTree.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binTree.Leaf;
import binTree.termes.Constante;
import binTree.termes.Terme;
import binTree.termes.Variable;

public class ListLeaf extends Leaf implements Type {

	public ListLeaf() {
		super("List[Int]");
	}

	@Override
	public Terme generateMinTerme() {
		return this.generateMinTerme(new HashMap<String, Type>());
	}

	@Override
	public Terme generateMinTerme(Map<String, Type> vars) {
		List<String> listVars = new ArrayList<>();
		for (String key : vars.keySet()) {
			if (vars.get(key) instanceof ListLeaf) {
				listVars.add(key);
			}
		}
		double rand = 0;
		if (listVars.size() > 0) {
			rand = Math.random();
		}
		if (rand < 0.5) {
			return Constante.getListConstAleas();
		} else {
			int aleas = (int) (Math.random() * listVars.size());
			return new Variable(listVars.get(aleas));
		}
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
