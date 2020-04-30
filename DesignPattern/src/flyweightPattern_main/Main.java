package flyweightPattern_main;

import java.util.ArrayList;
import java.util.List;

import flyweightPattern_flyweight.Stamp;
import flyweightPattern_flyweight.StampFactory;

/** 
 * Flyweightパターン
 * インスタンスをできるだけ共有させて、メモリ使用量を軽くするパターン
 * インスタンスを生成するのに必要なリソース（メモリ、時間）の量を減らすことができる
 * 
 * 参照： https://qiita.com/kaikusakari/items/7d6b0e403e96b4c1bd69
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		StampFactory factory = new StampFactory();
		List<Stamp> stamps = new ArrayList<Stamp>();
		stamps.add(factory.get('ち'));
		stamps.add(factory.get('ょ'));
		stamps.add(factory.get('ち'));
		stamps.add(factory.get('ょ'));
		stamps.add(factory.get('い'));
		for (Stamp s : stamps) {
			s.print();
		}
	}
}
