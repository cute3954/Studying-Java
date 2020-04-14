package templateMethodPattern2;

import templateMethodPattern1.Latte;
import templateMethodPattern1.Milk;
import templateMethodPattern1.MilkTea;

/** 
 * TemplateMethodパターン
 * 処理の共通部分をテンプレートとして抽象クラスに抽出し、固有に処理を具象クラスで実装するパターン
 * 「前処理、メイン処理、後処理」といったように複数の具象クラスの似たような流れの処理を共通化したいときに使える。
 * 
 * 参照： https://qiita.com/yoshinori_hisakawa/items/4f19c9cc6a5dccafe053
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Milk milkTea = new MilkTea();
		Milk latte = new Latte();
		
		System.out.println("***ミルクティー***");
		milkTea.Meal();
		
		System.out.println("***ラテ***");
		latte.Meal();
	}

}
