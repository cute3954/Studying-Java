package flyweightPattern_flyweight;

import java.util.HashMap;
import java.util.Map;

// FlyweightFactoryクラス
// インスタンス化したクラスの状態を保持する
public class StampFactory {

	Map<Character, Stamp> pool;
	
	public StampFactory() {
		this.pool = new HashMap<Character, Stamp>();
	}

	public Stamp get(char type) {
		// 定義されている文字列であれば使いまわす
		Stamp stamp = this.pool.get(type);
		// 定義されていなければ生成する
		if (stamp == null) {
			stamp = new Stamp(type);
			this.pool.put(type, stamp);
		}
		return stamp;
	}
	
}
