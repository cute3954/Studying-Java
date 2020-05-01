package interpreterPattern_node;

import interpreterPattern_context.Context;

// <primitive command> ::= go | right | left
// goまたはrightまたはleft
public class PrimitiveCommandNode extends Node {

	private String name;
	
	@Override
	public void parse(Context context) throws Exception {
		name = context.currentToken();
		context.skipToken(name);
		if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
			throw new Exception(name + " is undefined");
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
