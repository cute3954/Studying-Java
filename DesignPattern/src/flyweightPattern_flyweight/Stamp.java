package flyweightPattern_flyweight;

// Flyweightクラス
// インスタンス化したいクラス
public class Stamp {
	
	char type;
	public Stamp(char type) {
		this.type = type;
	}
	
	public void print() {
		System.out.print(this.type);
	}
}
