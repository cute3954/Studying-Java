package prototypePattern_class;

//　ConcetePrototype: 実際にインスタンスを複製して、新しいインスタンスを生成するメソッドを実装
// 文字列に下線を表示
// Productインタフェースを実装
public class UnderLinePen implements Product {
	private char ulChar;
	
	public UnderLinePen(char ulChar) {
		this.ulChar = ulChar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		System.out.println(s);
		System.out.print("");
		for (int i = 0; i < length; i++) {
			System.out.print(ulChar);
		}
		System.out.println("");
	}

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
