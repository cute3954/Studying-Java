package prototypePattern_class;

// ConcetePrototype: 実際にインスタンスを複製して、新しいインスタンスを生成するメソッドを実装
// 文字列の周りを枠線で囲む
// Productインタフェースを実装
public class MessageBox implements Product {
	private char decoChar;
	
	public MessageBox(char decoChar) {
		this.decoChar = decoChar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decoChar);
		}
		System.out.println("");
		System.out.println(decoChar + " " + s + " " + decoChar);
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decoChar);
		}
		System.out.println("");
	}

	// Productインタフェースを実装してなければCloneNotSupportedExceptionが投げられる
	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

}
