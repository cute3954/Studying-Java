package builderPattern_main;

import builderPattern_class.*;

/** 
 * builderパターン
 * コンストラクタに対して数多くのパラメータをセットする必要があるときに、代わりに使うことが推奨されているパターン
 * 
 * 参照：https://qiita.com/i-tanaka730/items/10596f3c7a7a2df806e2
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		args = new String[]{"html"};
		if (args.length != 1) {
			System.exit(0);
		}
		if (args[0].equals("plain")) {
			EstimateBuilder_TEXT esBuilder_text = new EstimateBuilder_TEXT();
			NewBedroom newBedroom = new NewBedroom(esBuilder_text);
			newBedroom.construct();
			String result = esBuilder_text.getResult();
			System.out.println(result);
		} else if (args[0].equals("html")) {
			EstimateBuilder_HTML esBuilder_html = new EstimateBuilder_HTML();
			NewBedroom newBedroom = new NewBedroom(esBuilder_html);
			newBedroom.construct();
			String filename = esBuilder_html.getResult();
			System.out.println(filename + "が作成されました。");
		} else {
			System.exit(0);
		}
	}

}
