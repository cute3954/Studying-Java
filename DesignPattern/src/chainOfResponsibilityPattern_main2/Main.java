package chainOfResponsibilityPattern_main2;

import chainOfResponsibilityPattern_class2.LimitSupport;
import chainOfResponsibilityPattern_class2.NoSupport;
import chainOfResponsibilityPattern_class2.OddSupport;
import chainOfResponsibilityPattern_class2.SpecialSupport;
import chainOfResponsibilityPattern_class2.Support;
import chainOfResponsibilityPattern_class2.Trouble;

/** 
 * Chain of Responsibilityパターン
 * 複数のオブジェクトを鎖で繋いでおき、そのオブジェクトの鎖を順次渡り歩いて目的のオブジェクトを決定するパターン
 * 人に要求がやってくる、その人がそれを処理できるなら処理する。
 * 処理できないならその要求を次の人にたらい回しにする。
 * 
 * 注意点としては、柔軟性は高くなるが、たらい回しする分処理が遅くなってしまう。
 * よって、処理速度が非常に重要な場合はこのパターンを使わない方がよい。
 * 
 * 参照：https://qiita.com/i-tanaka730/items/073c106c58d7c74c1706
 * */
// 実行クラス
public class Main {

	public static void main(String[] args) {
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		
		// 最初の人に要求を出すと、後は連鎖の中をその要求が流れていき、適切な人によって要求が処理される。
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo);
		
		// さまざまなトラブル発生
		for (int i = 0; i < 500; i+= 33) {
			alice.support(new Trouble(i));
		}
	}

}
