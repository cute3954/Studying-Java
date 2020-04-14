package strategyPattern_2;

import java.util.Random;

public class RandomStrategy implements Strategy {

	@Override
	public Attack nextAttack() {
		Random random = new Random();
		return Attack.getAttack(random.nextInt(3));
	}

}
