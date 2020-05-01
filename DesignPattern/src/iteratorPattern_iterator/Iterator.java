package iteratorPattern_iterator;

// 要素を順番にスキャンしていくインターフェース
public interface Iterator {
	public abstract boolean hasNext();
	public abstract Object next();
}
