package factoryMethodPattern1;

// インスタンス生成のための抽象クラス
// インスタンス生成をメソッドに任せることで、クラス名を指定する必要がなくなる
public abstract class Factory {
	
	public final Icecream create(String flavor) {
		Icecream icecream = createIcecream(flavor);
		registerIcecream(icecream);
		return icecream;
	}
	
	protected abstract Icecream createIcecream(String flavor);
	protected abstract void registerIcecream(Icecream icecream);
}
