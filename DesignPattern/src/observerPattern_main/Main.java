package observerPattern_main;

import observerPattern_observer.DegitObserver;
import observerPattern_observer.GraphObserver;
import observerPattern_observer.Observer;
import observerPattern_subject.NumberGenerator;
import observerPattern_subject.RandomNumberGenerator;

/** 
 * Observerパターン
 * 観察される側（Subject）と観察する側（Observer）の２つの役割が存在し、
 * Subjectの状態が変化した際にObserverに通知されるパターン
 * 
 * 参照： https://qiita.com/shoheiyokoyama/items/d4b844ed29f84a80795b
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		NumberGenerator generator = new RandomNumberGenerator();
		// RandomNumberGeneratorを観察する
		Observer degitObserver = new DegitObserver();
		Observer graphObserver = new GraphObserver();
		// 数字が変化したタイミングでdegitObserverは値を、graphObserverが値を簡易グラフで出力
		generator.addObserver(degitObserver);
		generator.addObserver(graphObserver);
		generator.execute();
	}

}
