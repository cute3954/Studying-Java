package prototypePattern_class;

// Prototype: インスタンスを複製して、新しいインスタンスを生成するメソッドを定める
// 複製のためのメソッドを定めるインタフェース
// java.lang.Cloneableを継承していることで、Clone()メソッドでインスタンスを複製できる
public interface Product extends Cloneable {
	// use()に文字列を渡すとその文字列を装飾して表示する
	public abstract void use(String s);
	// 実際にインスタンスを複製する
	public abstract Product createClone();
}
