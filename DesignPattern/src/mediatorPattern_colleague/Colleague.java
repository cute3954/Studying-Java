package mediatorPattern_colleague;

import mediatorPattern_mediator.Mediator;

// メンバー
public interface Colleague {
	public abstract void setMediator(Mediator mediator);
	public abstract void setColleagueEnabled(boolean enabled);
}
