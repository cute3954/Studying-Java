package strategyPattern_2;

// ストラテジの具象クラス：　アルゴリズムの実装
// 新しい種類の攻撃パターンを追加する場合には新規ストラテジの具象クラスを追加して
// Mainクラスのnew BattleCharacter("Mami", new OOStrategy())のOO部分を入れ替えることで実装できる
public class NormalStrategy implements Strategy {

	@Override
	public Attack nextAttack() {
		return Attack.getAttack(Attack.ATTACK_NORMAL);
	}

}
