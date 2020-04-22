package visitorPattern_class;

// ConcreteElementクラス
// Elementインターフェースを実装する
public class GoldMember implements Member{
	@Override
	public void getBenefit(Benefit benefit) {
		benefit.getBenefit(this);
	}
}
