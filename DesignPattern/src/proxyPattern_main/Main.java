package proxyPattern_main;

import proxyPattern_class.PuellaMagi;
import proxyPattern_proxy.KyubeyProxy;

/** 
 * Proxyパターン
 * 仕事ができない本人オブジェクトの代わりに、代理人オブジェクトが一部の仕事をこなすパターン
 *
 * https://qiita.com/i-tanaka730/items/47efbab5eccc2d36759f
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		PuellaMagi a = new KyubeyProxy("環いろは");
		System.out.println("キュゥべえは現在" + a.getPuellaMagiName() + "を魔法少女に誘っています");
		a.setPuellaMagiName("高坂穂乃果");
		System.out.println("キュゥべえは現在" + a.getPuellaMagiName() + "を魔法少女に誘っています");
		a.make("僕と契約して魔法少女になってよ／人◕ ‿‿ ◕人＼");
	}

}
