package interpreterPattern_context;

import java.util.StringTokenizer;

// 構文分析のための前後関係を表すクラス
public class Context {
	
	private StringTokenizer tokenizer;
	private String currentToken;
	
	public Context(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
	}

	public String nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}
	
	public String currentToken() {
		return currentToken;
	} 
	
	public void skipToken(String token) throws Exception {
		if (!token.equals(currentToken)) {
			throw new Exception("Warning: " + token + " is excepted, but " + currentToken + " is found.");
		}
		nextToken();
	}
	
	public int currentNumber() throws Exception {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new Exception("Warning: " + e);
		}
		return number;
	}
	
}
