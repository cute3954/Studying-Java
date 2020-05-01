package proxyPattern_class;

// KyubeyとKyubeyProxy共通のインターフェース
public interface PuellaMagi {
	public abstract void setPuellaMagiName(String name);
	public abstract String getPuellaMagiName();
	public abstract void make(String string);
}
