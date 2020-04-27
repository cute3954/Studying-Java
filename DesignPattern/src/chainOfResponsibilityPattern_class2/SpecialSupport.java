package chainOfResponsibilityPattern_class2;

// トラブルを解決する具象クラス
// 特定番号未満のトラブルを解決する
public class SpecialSupport extends Support {
	
	private int number;
	
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}

	// numberであれば解決可能
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}

}
