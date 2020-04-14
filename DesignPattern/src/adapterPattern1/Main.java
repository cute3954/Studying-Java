package adapterPattern1;

//実行クラス
public class Main {
	public static void main(String[] args) {
		Pooh pooh = new Pooh();
		SocksMonster socksMonster = new SocksMonster();
		StuffedAnimal socksMonsterAdapter = new SocksMonsterAdapter(socksMonster);
		
		// 靴下のお化けを呼び出す
		socksMonster.spoil();
		socksMonster.eat();
		socksMonster.run();
		
		// プーを呼び出す
		testPooh(pooh);
		// 靴下のお化けをアダプタにセットして呼び出す
		testPooh(socksMonsterAdapter);
		
	}
	
	static void testPooh(StuffedAnimal stuffedAnimal) {
		stuffedAnimal.nod();
		stuffedAnimal.eat();
		stuffedAnimal.sleep();
	}
}
