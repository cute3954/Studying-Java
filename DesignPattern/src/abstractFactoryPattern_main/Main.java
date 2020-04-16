package abstractFactoryPattern_main;

import abstractFactoryPattern_class.CurryIngredients;
import abstractFactoryPattern_class.CurryRecipe;
import abstractFactoryPattern_class.CurryRecipeInstance;

/** 
 * Abstract Factoryパターン
 * 
 * インスタンスの生成を専門に行うクラスを用意することで、整合性を必要とされる一連のオブジェクト群を間違いなく生成するためのパターン
 * このパターンでは呼び出し元クラスにnewしていたものを、Factoryというクラス群にインスタンス生成部分を移動して、
 * Factoryクラスが保持するメソッド経由したいクラスのインスタンスを取得する
 * 
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		CurryRecipe recipe = CurryRecipeInstance.getCurryRecipe("choi");
		CurryIngredients ing = recipe.curryIng();
		System.out.println(ing.toString());
	}

}
