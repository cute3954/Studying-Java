package interpreterPattern_node;

import interpreterPattern_context.Context;

// 構文木のノードとなるクラス
public abstract class Node {
	public abstract void parse(Context context) throws Exception;
}
