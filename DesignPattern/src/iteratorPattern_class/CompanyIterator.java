package iteratorPattern_class;

import iteratorPattern_iterator.Iterator;

public class CompanyIterator implements Iterator {

	private Company company;
	private int index;
	
	public CompanyIterator(Company company) {
		this.company = company;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < company.getNumber()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Employee employee = company.getEmployeeAt(index);
		index++;
		return employee;
	}

}
