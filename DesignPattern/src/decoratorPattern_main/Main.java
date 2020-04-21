package decoratorPattern_main;

import java.util.Scanner;

import decoratorPattern_class.Base;
import decoratorPattern_class.Beverage;
import decoratorPattern_class.GreenTeaPowder;
import decoratorPattern_class.Milk;

/** 
 * Decoratorパターン
 * 元となるオブジェクトにデコレートを行うことで、機能の拡張を行うようなパターン
 * 継承元となるクラスに変更を加えずに機能の追加、
 * 必要な部品を組み合わせることによって多様な機能を追加できる
 * 
 * 参照：https://qiita.com/mk777/items/6f463466027939a4b137
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Beverage beverage = new Base();
		boolean done = false;
		while (!done) {
			System.out.println("current price of drinks: " + beverage.getTotalPrice());
			System.out.print("choose: 1. add green tea powder / 2. add milk");
			switch (sc.nextInt()) {
			case 0:
				done = true;
				break;
			case 1:
				beverage = new GreenTeaPowder(beverage);
				break;
			case 2:
				beverage = new Milk(beverage);
				break;
			default:
				break;
			}
		}
		System.out.println("total price of drinks: " + beverage.getTotalPrice());
		sc.close();
	}

}
