package bridgePattern_class;

// 実装クラス階層
// モース符号を表示するクラス
public class DefaultMCF implements MorseCodeInterface {

	@Override
	public void dot() {
		System.out.print("・");
	}

	@Override
	public void dash() {
		System.out.print("-");
	}

	@Override
	public void space() {
		System.out.print(" ");
	}

}
