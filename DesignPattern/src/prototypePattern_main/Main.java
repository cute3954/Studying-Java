package prototypePattern_main;

import prototypePattern_class.*;
/** 
 * Prototypeパターン
 * クラスからインスタンスを生成するのではなく、インスタンスから別のインスタンスをコピーして生成するパターン
 * 
 * 種類が多すぎてクラスにまとめられない場合
 * クラスからのインスタンスを生成が難しい場合
 * フレームワークと生成するインスタンスを分けたい場合
 * 
 * 参照： https://qiita.com/shoheiyokoyama/items/61826e158b3c4a259065
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		
		UnderLinePen upen = new UnderLinePen('-');
		MessageBox mbox = new MessageBox('@');
		MessageBox sbox = new MessageBox('♪');
		
		manager.register("nendoroid", upen);
		manager.register("figure", mbox);
		manager.register("animal stuffed", sbox);
		
		Product p1 = manager.create("nendoroid");
		p1.use("Madoka Kaname");
		Product p2 = manager.create("figure");
		p2.use("Homura Akemi");
		Product p3 = manager.create("animal stuffed");
		p3.use("Kyubey");
	}

}
