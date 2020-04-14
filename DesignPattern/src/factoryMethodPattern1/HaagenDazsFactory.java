package factoryMethodPattern1;

import java.util.ArrayList;
import java.util.List;

//　具象クラス
// 抽象クラスのcreateIcecream、registerIcecreamの処理を実装
public class HaagenDazsFactory extends Factory {
	
	// 生成したIcecream(HaagenDazs)はArrayListで管理
	private List flavors = new ArrayList();
	
	protected Icecream createIcecream(String flavor) {
		return new HaagenDazs(flavor);
	}
	protected void registerIcecream(Icecream icecream) {
		flavors.add(((HaagenDazs)icecream).getFlavor());
	}
	public List getFlavors() {
		return flavors;
	}
}
