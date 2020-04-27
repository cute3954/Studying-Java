package chainOfResponsibilityPattern_class2;

// トラブルを解決する具象クラス
public class NoSupport extends Support {

	public NoSupport(String name) {
		super(name);
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		return false;
	}

}
