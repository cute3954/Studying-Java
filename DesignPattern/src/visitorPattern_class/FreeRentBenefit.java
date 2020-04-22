package visitorPattern_class;

// ConcreteVisitorクラス
// Visitorインターフェースを実装する
public class FreeRentBenefit implements Benefit {

	@Override
	public void getBenefit(GoldMember member) {
		System.out.println("FreeRent for Gold Member");
	}

	@Override
	public void getBenefit(VipMember member) {
		System.out.println("FreeRent for Vip Member");
	}

}
