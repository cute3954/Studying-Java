package iteratorPattern_class;

import iteratorPattern_iterator.Iterator;

public class Company implements Aggregate {
	
	private Employee[] employees;
	private int last = 0;
	
	public Company(int maxsize) {
		this.employees = new Employee[maxsize];
	}
	
	public Employee getEmployeeAt(int index) {
		return employees[index];
	}
	
	public void appendEmployee(Employee employee) {
		this.employees[last] = employee;
		last++;
	}
	
	public int getNumber() {
		return last;
	}

	@Override
	public Iterator iterator() {
		return new CompanyIterator(this);
	}

}
