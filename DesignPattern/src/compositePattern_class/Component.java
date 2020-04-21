package compositePattern_class;

// FileとDirectoryの基底となるクラス
public abstract class Component {
	
	public abstract String getName();
	protected abstract void printList(String prefix);
	
	public void printList() {
		printList("");
	}
}
