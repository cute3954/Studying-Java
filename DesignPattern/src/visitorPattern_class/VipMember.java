package visitorPattern_class;

// ConcreteElementクラス
// Elementインターフェースを実装する
public class VipMember implements Member{
	@Override
	public void getBenefit(Benefit benefit) {
		benefit.getBenefit(this);
	}
}
