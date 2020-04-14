package templateMethodPattern1;

public abstract class Milk {	
	public void Meal() {
		breakfast();
		lunch();
		dinner();
		dessert();
	}
	protected abstract void breakfast();
	// ミルクティーとコーヒー、どっちも似合うので抽象クラスで実装
	private void lunch() {
		System.out.println("フルーツサンド");
	}
	protected abstract void dinner();
	protected abstract void dessert();
}
