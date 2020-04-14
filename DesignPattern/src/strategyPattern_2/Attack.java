package strategyPattern_2;

public class Attack {

	// 攻撃パターン
	public static final int ATTACK_NORMAL = 0;
	public static final int ATTACK_MAGIA = 1;
	public static final int ATTACK_DOPPEL = 2;
	
	public static final Attack[] attack = {
		new Attack(ATTACK_NORMAL),
		new Attack(ATTACK_MAGIA),
		new Attack(ATTACK_DOPPEL),
	};
	
	private int attack_pattern;
	
	// コンストラクタ
	private Attack(int attack_pattern) {
		this.attack_pattern = attack_pattern;
	}
	
	public static Attack getAttack(int attack_pattern) {
		return attack[attack_pattern];
	}
	
	public boolean isStrongerThan(Attack attack) {
		// thisがattackより強い時、trueを返す
		return fight(attack) == 1;
	}

	private int fight(Attack attack) {
		if (this == attack) {
			// 引き分け
			return 0;
		} else {
			if (this.attack_pattern > attack.attack_pattern) {
				// thisの勝ち
				return 1;
			} else {
				// attackの勝ち
				return -1;
			}	
		}
	}
	
}
