package builderPattern_class;

// インテリアを変えるためのメソッドを定義した抽象クラス
public abstract class Builder {
	public abstract void installFlooring(String flooring, int price);
	public abstract void paintWallColor(String wallColor, int price);
	public abstract void putFurnitures(String[] furnitures, int price);
	public abstract void complete();
}
