package binTree.types;

import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

import binTree.Tree;
import binTree.termes.Terme;

public interface Type extends Tree {

	public Terme generateMinTerme();

	public Terme generateMinTerme(Map<String, Type> vars);

	public Terme generateTermeV1(int minSize) throws InvalidAttributeValueException;

	public Terme generateTermeV1(int minSize, Map<String, Type> vars)
			throws InvalidAttributeValueException;

	public Terme generateTermeV2(int minSize);

	public Terme generateTermeV2(int minSize, Map<String, Type> vars);

	public Terme generateTermeV3(int minSize);

	public Terme generateTermeV3(int minSize, Map<String, Type> vars);

}
