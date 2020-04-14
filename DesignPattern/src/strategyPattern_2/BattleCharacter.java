package strategyPattern_2;

//コンテキスト：　ストラテジをインスタンス化する
public class BattleCharacter {
	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int attackcount;
	
	public BattleCharacter(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}
	
	public String getName() {
		return name;
	}
	
	public Attack nextAttack() {
		return strategy.nextAttack();
	}
	
	public void win() {
		wincount++;
		attackcount++;
	}
	
	public void lose() {
		losecount++;
		attackcount++;
	}
	
	public void even() {
		attackcount++;
	}
	
	public String toString() {
		return "[" + name + "]" + attackcount + " attacks, " + wincount + " win, " + losecount + " lose";
	}
}
