package bridgePattern_class;

// 機能クラス階層
// choiをモース符号で表示する機能を追加したクラス
public class PrintMorseCode extends MorseCode {
	
	public PrintMorseCode(MorseCodeInterface codeInterface) {
		super(codeInterface);
	}
	
	// choi
	public PrintMorseCode c() {
		dash();
		dot();
		dash();
		dot();
		space();
		return this;
	};
	public PrintMorseCode h() {
		dot();
		dot();
		dot();
		dot();
		space();
		return this;
	};
	public PrintMorseCode o() {
		dash();
		dash();
		dash();
		space();
		return this;
	};
	public PrintMorseCode i() {
		dot();
		dot();
		space();
		return this;
	};
}
