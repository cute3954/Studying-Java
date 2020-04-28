package mediatorPattern_main;

import mediatorPattern_mediator.LoginFrame;

/** 
 * Mediatorパターン
 * 相談役を通して行動を起こすようにしてもらうパターン
 * 
 * 参照： https://qiita.com/i-tanaka730/items/9f96d28d32ab3c9099d9
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		new LoginFrame("Mediator Sample");
	}

}
