package builderPattern_class;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// HTMLファイルで見積もりを作成するクラス
public class EstimateBuilder_HTML extends Builder {

	private String filename;
	private PrintWriter writer;
	
	@Override
	public void installFlooring(String flooring, int price) {
		filename = "estimate.html";
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("<html><head><title>見積書</title></head><body>");
		writer.println("<h1>『床材』</h1>");
		writer.println("<ul>");
		writer.println("<li>" + flooring + "</li>");
		writer.println("</ul>");
		writer.println("<h2>" + price + "万円</h2>");

	}

	@Override
	public void paintWallColor(String wallColor, int price) {
		writer.println("<h1>『壁色』</h1>");
		writer.println("<ul>");
		writer.println("<li>" + wallColor + "</li>");
		writer.println("</ul>");
		writer.println("<h2>" + price + "万円</h2>");
	}

	@Override
	public void putFurnitures(String[] furnitures, int price) {
		writer.println("<h1>『家具』</h1>");
		writer.println("<ul>");
		for (int i = 0; i < furnitures.length; i++) {
			writer.println("<li>" + furnitures[i] + "</li>");
		}
		writer.println("</ul>");
		writer.println("<h2>" + price + "万円</h2>");	
	}

	@Override
	public void complete() {
		writer.println("</body></html>");
		writer.close();
	}
	
	public String getResult() {
		return filename;
	}

}
