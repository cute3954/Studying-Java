package singletonPattern_main;

import singletonPattern_class.FurudeRikaSingleton;

/** 
 * Singletonパターン
 * 生成するインスタンスの数を1つに制限するパターン
 * 主にインスタンスの状態を保持したかったり、クラス間の共通メソッド・プロパティにアクセスしたい場合に使う
 * 
 * 参照： https://qiita.com/shoheiyokoyama/items/c16fd547a77773c0ccc1
 * 		↓　Singletonパターンの使いどころがまとまっているので、参考してもいいかも
 * 		https://qiita.com/trashtoy/items/eea5dcfb1eb003101cc9
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		FurudeRikaSingleton furudeRika1 = FurudeRikaSingleton();
		FurudeRikaSingleton furudeRika2 = FurudeRikaSingleton();

		// 同一なオブジェクトが返される
		if (furudeRika1 == furudeRika2) {
			System.out.println("furudeRika1 and furudeRika2 are same instance");
			System.out.println("furudeRika1's age: " + furudeRika1.getAge());
			System.out.println("furudeRika2's age: " + furudeRika2.getAge());
		} else {
			System.out.println("furudeRika1 and furudeRika2 aren't same instance");
			System.out.println("furudeRika1's age: " + furudeRika1.getAge());
			System.out.println("furudeRika2's age: " + furudeRika2.getAge());
		}
	}
	private static FurudeRikaSingleton FurudeRikaSingleton() {
		// Singletonクラスを利用する側からはnewができない。
		return FurudeRikaSingleton.getInstance();
	}
	
}
