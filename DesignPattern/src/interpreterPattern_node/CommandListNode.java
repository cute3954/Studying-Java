package interpreterPattern_node;

import java.util.ArrayList;
import interpreterPattern_context.Context;

// <command list> ::= <command>* end
// コマンドが0以降以上繰り返した後トークンendが続いたもの
public class CommandListNode extends Node {

	private ArrayList list = new ArrayList();
	
	@Override
	public void parse(Context context) throws Exception {
		while (true) {
			if (context.currentToken() == null) {
				throw new Exception("Missing 'end'");
			} else if (context.currentToken().equals("end")) {
				context.skipToken("end");
				break;
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

}
