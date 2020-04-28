package mediatorPattern_mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mediatorPattern_colleague.ColleagueButton;
import mediatorPattern_colleague.ColleagueRadioButton;
import mediatorPattern_colleague.ColleagueTextField;

// 表示の有無/無効に関するロジックを仲介する
// 仕様を変更したい場合、LoginFrameクラスのみ修正・デバッグすればよい
public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueRadioButton checkGuest;
	private ColleagueRadioButton checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		// public GridLayout(int rows, int cols): 行と列の数を指定する
		setLayout(new GridLayout(4, 2));
		
		createColleagues();
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username: "));
		add(textUser);
		add(new Label("Password: "));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		colleagueChanged();
		
		// pack(): コンテナーに登録(add())されているコンポーネントの推奨サイズを設定したレイアウトから
		// 			コンテナーのサイズを決定してくれるメソッド
		pack();
		setVisible(true);
	}
	
	@Override
	public void createColleagues() {
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueRadioButton("Guest", g, true);
		checkLogin = new ColleagueRadioButton("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleagueからの通知で、各Colleagueの有効/無効を判定する。
	@Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            // Guest
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            // Login
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    // actionPerformed(): イベントが発生された際にこのメソッドが呼び出されるため、
    // 						このメソッド内にイベント処理ロジックを書けばよい。
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

}
