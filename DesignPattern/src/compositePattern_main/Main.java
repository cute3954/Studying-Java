package compositePattern_main;

import compositePattern_class.Directory;
import compositePattern_class.File;

/** 
 * Compositeパターン
 * 容器と中身を同一化し、再帰的な構造を作る方式
 * ディレクトリとファイルなどのような、木構造を伴う再帰的なデータ構造を表すことができる
 * 
 * 参照：https://qiita.com/i-tanaka730/items/577ca124f05bfe172248
 *		https://qiita.com/kaikusakari/items/60310c5a5003b1714896 
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		
		Directory workspaceDir = new Directory("workspace");
		Directory compositeDir = new Directory("composite");
		Directory testDir1 = new Directory("test1");
		Directory testDir2 = new Directory("test2");
		workspaceDir.add(compositeDir);
		workspaceDir.add(testDir1);
		workspaceDir.add(testDir2);
		
		File directory = new File("Directory.java");
		File entity = new File("Entity.java");
		File file = new File("file.java");
		File main = new File("main.java");
		compositeDir.add(directory);
		compositeDir.add(entity);
		compositeDir.add(file);
		compositeDir.add(main);
		workspaceDir.printList();
		/*
		 * 　　実行結果
			/workspace
			/workspace/composite
			/workspace/composite/Directory.java
			/workspace/composite/Entity.java
			/workspace/composite/file.java
			/workspace/composite/main.java
			/workspace/test1
			/workspace/test2
		 * 
		 */
	}

}
