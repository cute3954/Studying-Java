package interpreterPattern_node;

import interpreterPattern_context.Context;

// <command> ::= <repeat command> | <primitive command>
// 繰り返しコマンドまたは基本コマンドのいずれか
public class CommandNode extends Node {

	private Node node;
	
	@Override
	public void parse(Context context) throws Exception {
		if (context.currentToken().equals("repeat")) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}
	
	@Override
	public String toString() {
		return node.toString();
	}

}
