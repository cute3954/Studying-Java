package abstractFactoryPattern_class;

// カレーの具材を定義したインタフェース
public abstract interface CurryIngredients {
	public abstract String getVegetables();
	public abstract String getMeats();
	public abstract String getEtc();
}
