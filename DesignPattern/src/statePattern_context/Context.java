package statePattern_context;

import statePattern_state.State;

// 金庫の状態変化を管理し、警備センターとの連絡を取るインターフェース
public interface Context {
	// 時間の設定
	public abstract void setClock(int hour);
	// 状態変化
	public abstract void changeState(State state);
	// 警備センター警備員呼び出し
	public abstract void callSecurityCenter(String msg);
	// 警備センター記録
	public abstract void recordLog(String msg);
}
