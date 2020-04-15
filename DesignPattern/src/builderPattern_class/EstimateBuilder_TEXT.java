package builderPattern_class;

// プレーンテキストで見積もりを作成するクラス
public class EstimateBuilder_TEXT extends Builder {

	// StringBuffer: Stringクラス同様に宣言した変数に文字列を格納する
	//				　Stringクラスとの違いとして、変数に文字列を格納した後でも「値を追加」「挿入」「変更」などの、文字列操作が可能
	private StringBuffer buffer = new StringBuffer();
	
	@Override
	public void installFlooring(String flooring, int price) {
		buffer.append("===========見積書============\n");
		buffer.append("『床材』\n");
		buffer.append("・　" + flooring + "\n");
		buffer.append(price + "万円\n");

	}

	@Override
	public void paintWallColor(String wallColor, int price) {
		buffer.append("『壁色』\n");
		buffer.append("・　" + wallColor + "\n");
		buffer.append(price + "万円\n");
	}

	@Override
	public void putFurnitures(String[] furnitures, int price) {
		buffer.append("『家具』\n");
		for (int i = 0; i < furnitures.length; i++) {
			buffer.append("・　" + furnitures[i] + "\n");
		}
		buffer.append(price + "万円\n");
	}

	@Override
	public void complete() {
		buffer.append("===========================\n");
	}
	
	public String getResult() {
		return buffer.toString();
	}

}
