package observerPattern_subject;

import java.util.ArrayList;
import java.util.Iterator;

import observerPattern_observer.Observer;

public abstract class NumberGenerator {
	// 観察者のインスタンスを管理するための配列
	private ArrayList observers = new ArrayList();
	
	// Observerのインスタンスの管理
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	// 実際に数が生成されたタイミングで観察者に通知する
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer) iterator.next();
			observer.update(this);
		}
	}
	// 数を取得する
	public abstract int getNumber();
	// 数を生成する
	public abstract void execute();
}
