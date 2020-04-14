package strategyPattern_2;

//ストラテジの具象クラス：　アルゴリズムの実装
public class DoppelStrategy implements Strategy {

	@Override
	public Attack nextAttack() {
		return Attack.getAttack(Attack.ATTACK_DOPPEL);
	}

}
