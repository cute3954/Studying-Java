package commandPattern_drawer;

import java.awt.Point;

import commandPattern_command.Command;

// 点の描画命令を表現するクラス
public class DrawCommand implements Command {

	// 描画対象
	protected Drawable drawable;
	// 描画位置
	private Point position;
	
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}

	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}

}
