package adapterPattern1;

//　具象クラス
public class SocksMonster implements Monster {

	@Override
	public void eat() {
		System.out.println("毎食靴下を5枚食べる");
	}

	@Override
	public void spoil() {
		System.out.println("焼き肉が食べたいと、泣きながら甘える");

	}

	@Override
	public void run() {
		System.out.println("部屋の中で走りる");
	}

}
