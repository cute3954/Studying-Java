package builderPattern_class;

// 寝室のインテリアを変えるクラス
public class NewBedroom {
	private Builder builder;
	
	public NewBedroom(Builder builder) {
		this.builder = builder;
	}
	
	public void construct() {
		builder.installFlooring("marble", 100);
		builder.paintWallColor("mintgreen", 10);
		builder.putFurnitures(new String[] {
				"bed", "lighting", "curtain", "closet"
		}, 50);
		builder.complete();
	}
}
