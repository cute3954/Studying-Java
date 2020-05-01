package commandPattern_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import commandPattern_command.Command;
import commandPattern_command.MacroCommand;
import commandPattern_drawer.DrawCanvas;
import commandPattern_drawer.DrawCommand;

/** 
 * Commandパターン
 * 命令を表すクラスのインスタンスを、１つのものとして表現するパターン
 * 命令をオブジェクトとして表現することで、命令の履歴を取ったり、命令の再実行を行ったりすることができる。
 * 
 * https://qiita.com/i-tanaka730/items/6f8c3423eda95c230f3b
 * */
// 実行クラス
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

	// 描画履歴
	private MacroCommand history = new MacroCommand();
	// 描画領域
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// アンドゥボタン
	private JButton undoButton = new JButton("undo");
	// 消去ボタン
	private JButton clearButton = new JButton("clear");
	
	public static void main(String[] args) {
		new Main("Command Pattern Example");
	}

	public Main(String title) {
		super(title);
		
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		undoButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(undoButton);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		show();
	}
	

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	// MouseMotionListener用
	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// ActionListener用
	// undoやclearを押した場合の処理を記述
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == undoButton) {
			history.undo();
			canvas.repaint();
		} else if (source == clearButton) {
			history.clear();
			canvas.repaint();
		}
	}
	
	

}
