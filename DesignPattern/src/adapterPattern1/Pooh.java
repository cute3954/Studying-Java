package adapterPattern1;

// 具象クラス
public class Pooh implements StuffedAnimal{
	
	@Override
	public void nod() {
		System.out.println("3回機械音を出しながら、頷く");
	};
	
	@Override
	public void eat() {
		System.out.println("家に蜂蜜がないため、代わりに飲むヨーグルト蜜柑味を飲む");
	};
	
	@Override
	public void sleep() {
		System.out.println("鼾がうるさくて、ちょいが到底眠れない");
	};
	
}
