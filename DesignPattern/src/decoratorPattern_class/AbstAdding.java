package decoratorPattern_class;

public abstract class AbstAdding implements Beverage{
	// 装飾の対象であるBeverageオブジェクトをフィールドに持つ
	private Beverage base;
	
	// インスタンス生成時に中身を引数で指定
	public AbstAdding(Beverage base) {
		super();
		this.base = base;
	}
	
	@Override
	public int getTotalPrice() {
		return base.getTotalPrice();
	}
	
	protected Beverage getBase() {
		return base;
	}
}
