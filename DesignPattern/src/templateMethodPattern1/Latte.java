package templateMethodPattern1;

public class Latte extends Milk {

	@Override
	protected void breakfast() {
		System.out.println("ベーグルサンド");
	}
	
	@Override
	protected void dinner() {
		System.out.println("ミートソーススパゲティ");
	}

	@Override
	protected void dessert() {
		System.out.println("チーズスコーン");
	}

}
