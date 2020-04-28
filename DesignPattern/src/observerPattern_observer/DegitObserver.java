package observerPattern_observer;

import observerPattern_subject.NumberGenerator;

// ConcreteObserver: Observerの具象クラス
public class DegitObserver implements Observer {

	// 実際にNumberGeneratorの数が更新された際の処理を実装
	// push型: 状態変化時にSubjectがObserverに通知する
	@Override
	public void update(NumberGenerator generator) {
		System.out.println("DegitObserver: " + generator.getNumber());
		try {
			// 処理を遅延させる
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
	}

}
