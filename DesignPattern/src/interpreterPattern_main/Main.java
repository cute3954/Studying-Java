package interpreterPattern_main;

import java.io.BufferedReader;
import java.io.FileReader;

import interpreterPattern_context.Context;
import interpreterPattern_node.Node;
import interpreterPattern_node.ProgramNode;

/** 
 * Interpreterパターン
 * 何らかの形式で書かれたファイルの中身を、翻訳の役目を果たすプログラムで分析・表現するパターン
 * 1つの規則を1つのクラスで表し、新しい規則を追加する場合はNodeクラスのサブクラスを追加するだけでよい。
 * 
 * 参照： https://qiita.com/i-tanaka730/items/adf5090cdbfd55cbc9b5
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		try {
			// BNF記法を使う。
			BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
			String text;
			while ((text = reader.readLine()) != null) {
				System.out.println("text = \"" + text + "\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("node = " + node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
