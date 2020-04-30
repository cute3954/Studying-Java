package mementoPattern_main;

import mementoPattern_memento.Gamer;
import mementoPattern_memento.Memento;

/** 
 * Mementoパターン
 * インスタンスの状態を表す役割を導入して、カプセル化の破壊に陥ることなく保存/復元を行うパターン
 * 
 * 参照： https://qiita.com/i-tanaka730/items/c664aeec431da492f5de
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		
		Gamer gamer = new Gamer(100);
		// 最初の状態を保存しておく
		Memento memento = gamer.createMemento();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("==== " + i);
			System.out.println("現状：" + gamer);
			
			gamer.bet();
			
			System.out.println("体力は"+ gamer.getHp() +"になりました。");
			
			// スナップショットを取る
			if (gamer.getHp() > memento.getHp()) {
				System.out.println("　　（だいぶ増えたので、現在の状態を保存しておこう）　　");
				memento = gamer.createMemento();
			// アンドゥを行う
			} else if (gamer.getHp() < memento.getHp() / 2) {
				System.out.println("　　（だいぶ減ったので、以前の状態に復帰しよう）　　");
				gamer.restoreMemento(memento);
			}
		}
	}

}
