package factoryMethodPattern2;

import factoryMethodPattern1.Factory;
import factoryMethodPattern1.HaagenDazsFactory;
import factoryMethodPattern1.Icecream;

/** 
 * FactoryMethodパターン
 * インスタンスの作り方をスーパークラスで定め、具体的な処理をサブクラスで行うパターン
 * TemplateMethodパターンをオブジェクト生成の場面に適応させたパターン
 * 
 * 参照： https://qiita.com/shoheiyokoyama/items/d752834a6a2e208b90ca
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Factory factory = new HaagenDazsFactory();
		Icecream icecream1 = factory.create("Rich Milk");
		Icecream icecream2 = factory.create("Halloween Pumpkin");
		Icecream icecream3 = factory.create("Strawberry & Parfait");
		Icecream icecream4 = factory.create("Salted Caramel");
	
		icecream1.eat();
		icecream2.eat();
		icecream3.eat();
		icecream4.eat();
		
//		Create: Rich Milk flavor
//		Create: Halloween Pumpkin flavor
//		Create: Strawberry & Parfait flavor
//		Create: Salted Caramel flavor
//		Eat: Rich Milk flavor
//		Eat: Halloween Pumpkin flavor
//		Eat: Strawberry & Parfait flavor
//		Eat: Salted Caramel flavor

	}
}
