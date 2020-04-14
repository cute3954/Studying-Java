package templateMethodPattern1;

public class MilkTea extends Milk {

	@Override
	protected void breakfast() {
		System.out.println("バナナ");
	}
	
	@Override
	protected void dinner() {
		System.out.println("コチュジャンプルコギ");
	}

	@Override
	protected void dessert() {
		System.out.println("苺");
	}

}
