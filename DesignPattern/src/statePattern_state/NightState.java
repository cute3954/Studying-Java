package statePattern_state;

import statePattern_context.Context;

// 夜間の状態を表す
public class NightState implements State {
	
	private static NightState singleton = new NightState();
	private NightState() {}
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if (hour >= 9 && hour < 17) {
			context.changeState(DayState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("非常：夜間の金庫使用！");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル（夜間）");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話（夜間）");
	}
	
	@Override
	public String toString() {
		return "[夜間]";
	}

}
