package model;

// シリアライズ（直列化）：Javaのインスタンスをバイト列として出力すること。
import java.io.Serializable;
import java.sql.Timestamp;

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
	private int member_no;
	private String member_name, member_groupName, member_name_hurigana, member_name_eng, member_bloodType, member_hobby, member_skill, member_image_fileurl;
	private int member_grade, member_height;
	private Timestamp member_birthday;
	
	// getter/setter
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_groupName() {
		return member_groupName;
	}
	public void setMember_groupName(String member_groupName) {
		this.member_groupName = member_groupName;
	}
	public String getMember_name_hurigana() {
		return member_name_hurigana;
	}
	public void setMember_name_hurigana(String member_name_hurigana) {
		this.member_name_hurigana = member_name_hurigana;
	}
	public String getMember_name_eng() {
		return member_name_eng;
	}
	public void setMember_name_eng(String member_name_eng) {
		this.member_name_eng = member_name_eng;
	}
	public String getMember_bloodType() {
		return member_bloodType;
	}
	public void setMember_bloodType(String member_bloodType) {
		this.member_bloodType = member_bloodType;
	}
	public String getMember_hobby() {
		return member_hobby;
	}
	public void setMember_hobby(String member_hobby) {
		this.member_hobby = member_hobby;
	}
	public String getMember_skill() {
		return member_skill;
	}
	public void setMember_skill(String member_skill) {
		this.member_skill = member_skill;
	}
	public int getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(int member_grade) {
		this.member_grade = member_grade;
	}
	public int getMember_height() {
		return member_height;
	}
	public void setMember_height(int member_height) {
		this.member_height = member_height;
	}
	public Timestamp getMember_birthday() {
		return member_birthday;
	}
	public void setMember_birthday(Timestamp member_birthday) {
		this.member_birthday = member_birthday;
	}
	public String getMember_image_fileurl() {
		return member_image_fileurl;
	}
	public void setMember_image_fileurl(String member_image_fileurl) {
		this.member_image_fileurl = member_image_fileurl;
	}
}

