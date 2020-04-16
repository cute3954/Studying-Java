package abstractFactoryPattern_class;

// カレーレシピ＆具材の具象クラス
public class CurryRecipeInstance {
	public static CurryRecipe getCurryRecipe(String name) {
		switch (name) {
		case "nagisa":
			return new SpinachCheezeCurryRecipe();
		case "choi":
			return new PorkCurryRecipe();
		case "gudetama":
			return new ScrambledEggCurryRecipe();
		default:
			return new PorkCurryRecipe();
		}
	}	
}

class SpinachCheezeCurryRecipe implements CurryRecipe{
	@Override
	public CurryIngredients curryIng() {
		return new SpinachCheezeCurryIngredients();
	}
}

class SpinachCheezeCurryIngredients implements CurryIngredients{
	@Override
	public String getVegetables() {
		return "ほうれん草 ";
		
	}
	@Override
	public String getMeats() {
		return "豚肉  ";
		
	}
	@Override
	public String getEtc() {
		return "チーズ";
	}
	@Override
	public String toString() {
		return "SpinachCheezeCurryIngredients = ["+ this.getVegetables() + ", " + this.getMeats() + ", " + this.getEtc() + "]";
	}
}

class PorkCurryRecipe implements CurryRecipe{
	@Override
	public CurryIngredients curryIng() {
		return new PorkCurryIngredients();
	}
}

class PorkCurryIngredients implements CurryIngredients{
	@Override
	public String getVegetables() {
		return "";
		
	}
	@Override
	public String getMeats() {
		return "豚肉";
		
	}
	@Override
	public String getEtc() {
		return "";
	}
	@Override
	public String toString() {
		return "PorkCurryIngredients = ["+ this.getVegetables() + ", " + this.getMeats() + ", " + this.getEtc() + "]";
	}
}

class ScrambledEggCurryRecipe implements CurryRecipe{
	@Override
	public CurryIngredients curryIng() {
		return new ScrambledEggCurryIngredients();
	}
}

class ScrambledEggCurryIngredients implements CurryIngredients{
	@Override
	public String getVegetables() {
		return "";
		
	}
	@Override
	public String getMeats() {
		return "";
		
	}
	@Override
	public String getEtc() {
		return "卵";
	}
	@Override
	public String toString() {
		return "ScrambledEggCurryIngredients = ["+ this.getVegetables() + ", " + this.getMeats() + ", " + this.getEtc() + "]";
	}
}