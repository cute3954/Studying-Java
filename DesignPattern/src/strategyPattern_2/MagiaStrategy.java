package strategyPattern_2;

//ストラテジの具象クラス：　アルゴリズムの実装
public class MagiaStrategy implements Strategy {

	@Override
	public Attack nextAttack() {
		return Attack.getAttack(Attack.ATTACK_MAGIA);
	}

}
