package bridgePattern_main;

import bridgePattern_class.DefaultMCF;
import bridgePattern_class.PrintMorseCode;

/** 
 * bridgeパターン
 * ２つのクラス階層、「機能のクラス階層」と「実装のクラス階層」を分離した上で、橋を渡すように結びつけるパターン
 * 
 * 参照：https://qiita.com/i-tanaka730/items/91debf39a7f64ef6cb23
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		PrintMorseCode code = new PrintMorseCode(new DefaultMCF());
		code.c().h().o().i();
	}

}
