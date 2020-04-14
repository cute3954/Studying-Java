package strategyPattern_2;

//実行クラス
public class Main {

	public static void main(String[] args) {
		// new BattleCharacter("Mami", new OOStrategy())のOO部分を入れ替えることで
		// 処理内容を高速に変更することがストラテジパターンの目的
		BattleCharacter character1 = new BattleCharacter("Mami", new RandomStrategy());
		BattleCharacter character2 = new BattleCharacter("Homura", new MagiaStrategy());
		for (int i = 0; i < 8; i++) {
			Attack nextAttack1 = character1.nextAttack();
			Attack nextAttack2 = character2.nextAttack();
			if (nextAttack1.isStrongerThan(nextAttack2)) {
				System.out.println("Winner:" + character1.getName());
				character1.win();
				character2.lose();
			} else if (nextAttack2.isStrongerThan(nextAttack1)) {
				System.out.println("Winner:" + character2.getName());
				character2.win();
				character1.lose();
			} else {
				System.out.println("Even...");
				character1.even();
				character2.even();
			}
		}
		System.out.println("----- Total result -----");
		System.out.println(character1.toString());
		System.out.println(character2.toString());
	}

}
