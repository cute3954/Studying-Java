package adapterPattern1;

/** 
 * Adapterパターン
 * 2つの異なる互換性のないクラスを連携させるパターン。
 * 本来のクラスのインタフェースとは異なるインタフェースを提供させる、つまりはインタフェースを変更することが可能。
 * 他の名称で「Wrapper」クラスとも呼ばれる。
 * 
 * 参照：http://doriven.hatenablog.com/entry/2014/05/31/002645
 * */
// Adapter
public class SocksMonsterAdapter implements StuffedAnimal {

	SocksMonster socksmonster;
	
	public SocksMonsterAdapter(SocksMonster socksMonster) {
		this.socksmonster = socksMonster;
	}
	
	@Override
	public void nod() {
		socksmonster.spoil();

	}

	@Override
	public void eat() {
		for (int i = 0; i < 5; i++) {
			socksmonster.eat();
		}
	}

	@Override
	public void sleep() {
		socksmonster.run();
	}

}
