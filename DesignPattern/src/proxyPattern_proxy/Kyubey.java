package proxyPattern_proxy;

import proxyPattern_class.PuellaMagi;

// 本人
public class Kyubey implements PuellaMagi {

	private String name;
	
	public Kyubey() {
		heavyJob("PuellaMagiのインスタンス生成中");
	}
	
	public Kyubey(String name) {
		this.name = name;
		heavyJob("PuellaMagiのインスタンス(" + name + ")生成中");
	}

	@Override
	public void setPuellaMagiName(String name) {
		this.name = name;
	}

	@Override
	public String getPuellaMagiName() {
		return name;
	}

	@Override
	public void make(String string) {
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}
	
	private void heavyJob(String string) {
		System.out.print(string);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.print(".");
		}
		System.out.println("完了。");
	}

}
