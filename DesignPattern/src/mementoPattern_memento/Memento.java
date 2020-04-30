package mementoPattern_memento;

import java.util.ArrayList;

// Gameの状態を表すクラス
public class Memento {
	
	int hp;
	ArrayList<String> masks;
	
	public int getHp() {
		return hp;
	}
	
	Memento(int hp) {
		this.hp = hp;
		this.masks = new ArrayList<String>();
	}
	
	void addMask(String mask) {
		masks.add(mask);
	}
	
	ArrayList<String> getMasks() {
		return (ArrayList<String>) masks.clone();
	}
}
