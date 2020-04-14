package strategyPattern_2;

/** 
 * Strategyパターン
 * アルゴリズムを実装した部分をごっそり交換できる方式
 * クラスを使う人のコードを変更することなくアルゴリズムを変更することが可能になる
 * */
//ストラテジ：　アルゴリズムのインタフェース
public interface Strategy {
	public abstract Attack nextAttack();
}
