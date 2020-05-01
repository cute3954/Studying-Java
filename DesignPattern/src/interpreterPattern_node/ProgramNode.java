package interpreterPattern_node;

import interpreterPattern_context.Context;

// <program> ::= program <command list>
// トークンprogramの後にコマンドの列が続いたもの
public class ProgramNode extends Node {

	private Node commandListNode;
	
	@Override
	public void parse(Context context) throws Exception {
		context.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	@Override
	public String toString() {
		return "[program " + commandListNode + "]";
	}
}
