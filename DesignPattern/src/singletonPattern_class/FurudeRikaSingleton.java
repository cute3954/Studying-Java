package singletonPattern_class;

public class FurudeRikaSingleton {
	//　Singletonパターンを適応するにあたり、以下のルールを準拠する必要がある。
	// ① 自身の型でインスタンスがprivateなクラス変数として定義されている
	// ここのstaticフィールドによってクラス初期化時に唯一のインスタンスが生成されるので、
	// どこからでも参照できるグローバル領域で管理される。
	private static FurudeRikaSingleton frSingleton;
	private int age;
	
	// ②　外部から生成されないようにprivateにしている
	private FurudeRikaSingleton() {
		age = 9;	
	}
	// ③　インスタンスを返すためのクラスを定義されている
	// synchronized: 排他制御、複数のプロセスまたはスレッドが同時に入ることを防ぐこと
	// 実際のシステムは複数のスレッドに同時にアクセスする場合があり、
	// 想定しないインスタンスが生成される場合がある。
	// その場合は、インスタンスを返すgetInstance()のメソッドをsynchronized指定し、同期処理をさせる必要がある
	public static synchronized FurudeRikaSingleton getInstance() {
		if (frSingleton == null) {
			frSingleton = new FurudeRikaSingleton();
			System.out.println("Created Furude Rika Instance");
		} else {
			System.out.println("You have already created Furude Rika Instance");
		}
		return frSingleton;
	}	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}
