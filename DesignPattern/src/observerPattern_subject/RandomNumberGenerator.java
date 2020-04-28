package observerPattern_subject;

import java.util.Random;

// ConcreteSubject: Subjectの具象クラス
// 状態が変化した際に通知を行う
public class RandomNumberGenerator extends NumberGenerator {
	private Random random = new Random();
	private int number;
	
	// abstractメソッドを実装
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}

}
