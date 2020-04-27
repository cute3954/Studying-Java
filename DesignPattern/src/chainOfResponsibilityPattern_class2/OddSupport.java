package chainOfResponsibilityPattern_class2;

// トラブルを解決する具象クラス
// 奇数番号未満のトラブルを解決する
public class OddSupport extends Support{
	
	public OddSupport(String name) {
		super(name);
	}

	// 奇数番号の問題であれば解決可能
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}
}
