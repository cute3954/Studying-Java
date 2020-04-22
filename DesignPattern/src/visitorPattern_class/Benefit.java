package visitorPattern_class;

// Visitorインターフェース
// Element(Member)を訪れる訪問者を表す抽象クラス
public interface Benefit {
	void getBenefit(GoldMember member);
	void getBenefit(VipMember member);
}

