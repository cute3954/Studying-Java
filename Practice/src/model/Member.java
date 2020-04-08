package model;

// シリアライズ（直列化）：Javaのインスタンスをバイト列として出力すること。
import java.io.Serializable;

/*
 * JavaBeans
 * 
 * インスタンスを保存できる領域の一つ。
 * 以下のルールあり
 * １．直列化可能
 * ２．クラスはpublicでパッケージに所属
 * ３．publicで引数のないコンストラクタを持つ
 * ４．フィールドなカプセル化されている。
 * ５．命令規則に従ったgetter/setterを持つ
*/

/* Model */
// 一般的なクラス
// アプリケーションの主なる処理やデータの格納などを行う
public class Member implements Serializable{
	private String name, groupName;
	
	// 名前
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 所属グループ名
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}	
}

