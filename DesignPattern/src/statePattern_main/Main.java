package statePattern_main;

import statePattern_context.SafeFrame;

/** 
 * Stateパターン
 * 状態をクラスとして表現し、個々の具体的な状態を別々のクラスとして表現して分割を行う。
 * クラスを切り替えることによって「状態の変化」を表すパターン
 * 
 * 参照： https://qiita.com/i-tanaka730/items/49ee4e3daa3aeaf6e0b5
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("State Sample");
		while (true) {
			for (int hour = 0; hour < 24; hour++) {
				frame.setClock(hour);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
