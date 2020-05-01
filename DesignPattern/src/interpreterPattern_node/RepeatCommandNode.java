package interpreterPattern_node;

import interpreterPattern_context.Context;

// <repeat command> ::= repeat <number> <command list>
// トークンrepeatの後に繰り返し回数が続き、さらにコマンドの列が続いたもの
public class RepeatCommandNode extends Node {

	private int number;
	private Node commandListNode;
	
	@Override
	public void parse(Context context) throws Exception {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	@Override
	public String toString() {
		return "[repeat " + number + " " +commandListNode + "]";
	}
}
