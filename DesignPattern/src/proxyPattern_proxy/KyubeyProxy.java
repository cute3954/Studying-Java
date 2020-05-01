package proxyPattern_proxy;

import proxyPattern_class.PuellaMagi;

// 代理人
public class KyubeyProxy implements PuellaMagi {
	
	private String name;
	private Kyubey real;

	public KyubeyProxy(String name) {
		this.name = name;
	}
	
	@Override
	public synchronized void setPuellaMagiName(String name) {
		if (real != null) {
			real.setPuellaMagiName(name);
		}
		this.name = name;
	}

	@Override
	public String getPuellaMagiName() {
		return name;
	}

	@Override
	public void make(String string) {
		realize();
		real.make(string);
	}

	private synchronized void realize() {
		if (real == null) {
			real = new Kyubey(name);
		}
	}

}
