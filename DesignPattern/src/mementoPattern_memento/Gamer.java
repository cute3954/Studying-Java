package mementoPattern_memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Gamer {
	
	private int hp;
	private ArrayList<String> masks = new ArrayList<String>();
	private Random random = new Random();
	private static String[] maskscolor = {
			"white", "black", "pink", "mustache",
	};
	
	public Gamer(int hp) {
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void bet() {
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			hp += 100;
			System.out.println("体力が増えました。");
		} else if (dice == 2) {
			hp /= 2;
			System.out.println("体力が半分になりました。");
		} else if (dice == 6) {
			String m = getMask();
			System.out.println("マスク（" + m + "）をもらいました。");
			masks.add(m);
		} else {
			System.out.println("何も起こりませんでした。");
		}
	}
	
	// スナップショットを取る
	public Memento createMemento() {
		Memento m = new Memento(hp);
		Iterator it = masks.iterator();
		while (it.hasNext()) {
			String ma = (String) it.next();
			if (ma.startsWith("不良")) {
				m.addMask(ma);
			}
		}
		return m;
	}
	
	// アンドゥを行う
	public void restoreMemento(Memento memento) {
		this.hp = memento.hp;
		this.masks = memento.getMasks();
	}
	
	@Override
	public String toString() {
		return "[hp=" + hp + ", masks=" + masks + "]";
	}

	private String getMask() {
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "不良";
		}
		return prefix + maskscolor[random.nextInt(maskscolor.length)];
	}
}
