package decoratorPattern_class;

public class GreenTeaPowder extends AbstAdding {

	protected static int powderCount = 0;
	
	public GreenTeaPowder(Beverage material) {
		super(material);
	}
	
	@Override
	public int getTotalPrice() {
		return super.getTotalPrice() + addPrice();
	}
	
	private static int addPrice() {
		powderCount++;
		int addPrice = 100;
		
		if (powderCount > 1) {
			addPrice = 70;
		}
		
		return addPrice;
	}
}
