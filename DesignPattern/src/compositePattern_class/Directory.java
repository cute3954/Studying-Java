package compositePattern_class;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Component {

	private String name;
	private ArrayList<Component> directory = new ArrayList<Component>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public Component add(Component comp) {
		directory.add(comp);
		return this;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + name);
		// イテレータ：集合の要素に順番にアクセスするときに使用するインタフェース
		//			ArrayList, HashSet, LinkedList, Treeset等で使える
		Iterator<Component> it = directory.iterator();
		while (it.hasNext()) {
			// next(): 次の要素を返す
			Component comp = (Component) it.next();
			comp.printList(prefix + "/" + name);
		}
	}

}
