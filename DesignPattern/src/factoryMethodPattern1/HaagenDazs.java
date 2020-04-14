package factoryMethodPattern1;
// 具象クラス
public class HaagenDazs extends Icecream {
	
	private String flavor;
	
	// インスタンス生成時にログを吐き出す
	HaagenDazs(String flavor) {
		System.out.println("Create: " + flavor + " flavor");
		this.flavor = flavor;
	}
	
	// useが呼び出された時にログを吐き出す
	@Override
	public void eat() {
		System.out.println("Eat: " + flavor + " flavor");
	}
	public String getFlavor() {
		return flavor;
	}

}
