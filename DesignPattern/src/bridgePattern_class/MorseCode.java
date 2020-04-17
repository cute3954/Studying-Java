package bridgePattern_class;

// 機能クラス階層
public class MorseCode {
	
	// ２つのクラス階層の「橋」になる
	private MorseCodeInterface codeInterface;
	
	public MorseCode(MorseCodeInterface codeInterface) {
		this.codeInterface = codeInterface;
	}
	
	public void dot() {
		codeInterface.dot();
	};
	public void dash() {
		codeInterface.dash();
	};
	public void space() {
		codeInterface.space();
	};
}
