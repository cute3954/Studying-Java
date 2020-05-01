package iteratorPattern_class;

import iteratorPattern_iterator.Iterator;

// 集合体
// Iteratorを作り出すインターフェース。
public interface Aggregate {
	public abstract Iterator iterator();
}
