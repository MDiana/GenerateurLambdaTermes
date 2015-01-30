package binTree.types;

import java.util.Map;

import binTree.Tree;
import binTree.termes.Terme;

public interface Type extends Tree {

	public Terme generateMinTermeV1();

	public Terme generateMinTermeV1(Map<String, Type> vars);

	public Terme generateTermeV1(int minSize);

	public Terme generateTermeV1(int minSize, Map<String, Type> vars);

	public Terme generateMinTermeV2();

	public Terme generateMinTermeV2(Map<String, Type> vars);

	public Terme generateTermeV2(int minSize);

	public Terme generateTermeV2(int minSize, Map<String, Type> vars);

	public Terme generateMinTermeV3();

	public Terme generateMinTermeV3(Map<String, Type> vars);

	public Terme generateTermeV3(int minSize);

	public Terme generateTermeV3(int minSize, Map<String, Type> vars);

}
