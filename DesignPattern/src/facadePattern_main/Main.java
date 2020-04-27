package facadePattern_main;

import facadePattern_class.PageMaker;

/** 
 * Facadeパターン
 * 複雑なシステムに対してシンプルな窓口を用意するパターン
 * インターフェースを少なくし、複雑なものを単純に見せることができる
 * 
 * 参照： https://qiita.com/i-tanaka730/items/911604bcd4136684ff1c
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		PageMaker.makeWelcomePage("homura@test.com", "welcome.html");
	}
}
