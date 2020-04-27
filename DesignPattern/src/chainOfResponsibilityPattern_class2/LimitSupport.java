package chainOfResponsibilityPattern_class2;

// トラブルを解決する具象クラス
// 指定した番号未満のトラブルを解決する
public class LimitSupport extends Support {
	
	private int limit;
	
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}

}
