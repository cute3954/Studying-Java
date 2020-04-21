package decoratorPattern_class;

public class Milk extends AbstAdding {

	public Milk(Beverage material) {
		super(material);
	}
	
	@Override
	public int getTotalPrice() {
		return super.getTotalPrice() + 50;
	}
}
