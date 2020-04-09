package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MemberDAO;
import model.Member;

/* Controller */
// サーブレットクラス
// ユーザーからの要求を受け取り、処理の実行をモデルに依頼し、
// その結果の表示をビューに依頼する

// サーブレットのプログラミングでは、アノテーションによってURLパスとサーブレットとのマッピング情報を宣言することができる
// web.xmlを使うか、アノテーションをつかうかは選択できる
@WebServlet("/MemberInfo")
public class MemeberInfo extends HttpServlet {
	// シリアルバージョンIDの追加
	// 直列化した時（Serializableをインポートした時）に必要。
	// Serializableクラスのバージョンコントロールとして使用される
	private static final long serialVersionUID = 1L;
	
	// throws: 複数のメソッドを使用した処理を書く際、例外処理を各メソッドの中ではなく呼び出し元でまとめて行いたい場合
	//			各メソッドの宣言時にthrowsステートメントを加えることで例外処理を呼び出し元に移譲する
	// このメソッド内で例外が発生すると、その呼び出し元のcatch節に処理が移る。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// フォワード
		// 処理をフォワード先のサーブレットに移してしまうので、呼び出し元のサーブレットには処理は戻ってこない。
		// また呼び出し元の方ではレスポンスに対する出力も行わない。
		// そのため、呼び出し元の方で何らかの処理を行った上で、処理をフォワード先のサーブレットに完全に移す場合に利用する。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberInfo.jsp");
		// forwardの引数は、呼び出し元のサーブレットのdoGetやdoPostが呼び出された時に引数に指定されている値をそのまま渡す。
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// リクエストパラメータを取得
		int member_no = Integer.parseInt(request.getParameter("member_no"));
		
		// 入力値をプロパティに設定
		Member member = new Member();
		member.setMember_no(member_no);
		
		// 各メンバーの紹介を出す
		MemberDAO memberDAO = new MemberDAO();
		try {
			memberDAO.execute(member);
			
			// リクエストスコープに保存
			// リクエストごとに生成されるスコープ。
			// フォワード先とフォワード元でインスタンスを共有することが可能になる。
			// 第1引数：スコープに保存するインスタンスの管理用の名前、第2引数：保存するインスタンスを指定。
			request.setAttribute("member", member);
			
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberInfo.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error: "+e);
			e.printStackTrace();
		}
	}
	
}
