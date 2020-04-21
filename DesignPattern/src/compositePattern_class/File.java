package compositePattern_class;

public class File extends Component {
	
	private String name;
	
	public File(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + name);
	}

}
