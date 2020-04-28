package observerPattern_observer;

import observerPattern_subject.NumberGenerator;

// Observer
public interface Observer {
	public abstract void update(NumberGenerator generator);
}
