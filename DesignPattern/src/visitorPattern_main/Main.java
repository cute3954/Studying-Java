package visitorPattern_main;

import visitorPattern_class.Benefit;
import visitorPattern_class.DiscountBenefit;
import visitorPattern_class.FreeRentBenefit;
import visitorPattern_class.GoldMember;
import visitorPattern_class.Member;
import visitorPattern_class.PointBenefit;
import visitorPattern_class.VipMember;

/** 
 * Visitorパターン
 * データ構造と処理を分離するパターン
 * データ構造の中をめぐり歩く訪問者クラスを用意し、訪問者クラスに処理を任せる。
 * すると、新しい処理を追加したいときは新しい訪問者を作れば済むことになる
 * 
 * 参照： https://qiita.com/i-tanaka730/items/2e2d4fac2075b3e45ef7
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Member goldMember = new GoldMember();
		Member vipMember = new VipMember();
		Benefit pointBenefit = new PointBenefit();
		Benefit discountBenefit = new DiscountBenefit();
		Benefit freeRentBenefit = new FreeRentBenefit();
		
		goldMember.getBenefit(pointBenefit);
		vipMember.getBenefit(pointBenefit);
		goldMember.getBenefit(discountBenefit);
		vipMember.getBenefit(discountBenefit);
		goldMember.getBenefit(freeRentBenefit);
		vipMember.getBenefit(freeRentBenefit);
	}

}
