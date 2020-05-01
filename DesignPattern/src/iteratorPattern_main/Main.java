package iteratorPattern_main;

import iteratorPattern_class.Company;
import iteratorPattern_class.Employee;
import iteratorPattern_iterator.Iterator;

/** 
 * Iteratorパターン
 * 集合体の要素に対し、順番にアクセスする処理を行うためのパターン
 * 実装とは切り離して、数え上げを行うことができる。
 * 
 * 参照： https://qiita.com/i-tanaka730/items/7c178409a4d5c1e4e42b
 * */
// 実行クラス
public class Main {
	public static void main(String[] args) {
		Company company = new Company(4);
		company.appendEmployee(new Employee("ちょい"));
		company.appendEmployee(new Employee("ちょちょい"));
		company.appendEmployee(new Employee("ちょちょちょちょちょい"));
		company.appendEmployee(new Employee("ちょこちょこっとちょい"));
	
		Iterator iterator = company.iterator();
		
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getName());
		}
	}
}
