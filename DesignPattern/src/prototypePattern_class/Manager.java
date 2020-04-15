package prototypePattern_class;

import java.util.HashMap;

//　client: 実際にインスタンスを複製して新しいインスタンスを生成する
// Productインタフェースを利用してインスタンスの複製を行う 
public class Manager {
	// 連想配列
	private HashMap<String, Product> showcase = new HashMap<>();
	public void register(String name, Product prototype) {
		showcase.put(name, prototype);
	}
	public Product create(String name) {
		// Productのインスタンスをクローンすることで、クラス名に依存することなく
		// Productインタフェースを実装したクラスを利用することができる
		Product p = (Product)showcase.get(name);
		return p.createClone();
	}
}
