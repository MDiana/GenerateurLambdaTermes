package binTree.types;

import java.util.Map;

import binTree.Tree;
import binTree.termes.Terme;

public interface Type extends Tree {
	
	public Terme generateMinTermeV1();
	
	public Terme generateMinTermeV1(Map<String, Type> vars);

}
