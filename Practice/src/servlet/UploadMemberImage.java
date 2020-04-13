package servlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db.MemberDAO;
import model.Member;

@WebServlet("/UploadMemberImage")
public class UploadMemberImage extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		// 10MBまで
		int maxsize = 10 * 1024 * 1024; 
		// アップロードファイルを格納するPATHを取得
		String rootPath = "rootPath";
		// 元のファイル名
		String uploadFileName = "";
		// 新しいファイル名
		String newFileName = "";
		
		int read = 0;
		byte[] buf = new byte[1024];
		FileInputStream fin = null;
		FileOutputStream fout = null;
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			// MultipartRequest: ファイルをサーバーにアップロードする場合に使用されるマルチパート処理サーブレット
			// 通常のファイルアップロード時のformで使用するenctype="multipart/form-data"を指定した場合の他のリクエスト情報も取り出すことが可能。
			// MultipartRequest(HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, String inputFilename)
			//　new DefaultFileRenamePolicy(): ファイル名が重複する場合、別のファイル名を付与する
			MultipartRequest multi = new MultipartRequest(request, rootPath, maxsize, "UTF-8", new DefaultFileRenamePolicy());		
			// 画像アップロード
			uploadFileName = multi.getFilesystemName("member_imagefile");
			newFileName = simDf.format(new Date(currentTime)) + "." + uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
			
			// 変更前のファイル名
			File oldFile = new File(rootPath + "\\" + uploadFileName);
			
			/* 画像リサイズ */
			// Imageクラスの説明： https://docs.oracle.com/javase/jp/6/api/java/awt/Image.html
			// read(): 画像ファイルから読み込んだデータをデコードする
			Image originalImage = ImageIO.read(oldFile);
			int newWidth = 180;
			// 元画像のサイズ
			int imgWidth = originalImage.getWidth(null);
			int imgHeight = originalImage.getHeight(null);
			// 割合、横、縦を指定
			double ratio = (double)newWidth/(double)imgWidth;
			int w = (int)(imgWidth * ratio);
			int h = (int)(imgHeight * ratio);
			// 画像リサイズ
			// getScaledInstance(): デフォルトで指定されたwidthとheightで画像をレンダリングし、
			//						新しいimageオブジェクトが返される
			// SCALE_SMOOTH: スケーリング速度よりもイメージの滑らかさに高い優先順位を与える
			Image resizeImage = originalImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);

			// リサイズした画像の保存
			// BufferedImage: メモリ上に領域を作って、そこに画像を読み込んだり、物体を描画したりといｔったことを行うためのクラス
            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
           
            // Graphicsクラスの説明: https://docs.oracle.com/javase/jp/8/docs/api/java/awt/Graphics.html
            // getGraphics(): Graphicsインスタンスを取得
            Graphics g = newImage.getGraphics();
            // public abstract boolean drawImage(Image img, int x, int y, ImageObserver observer)
            // 指定されたイメージの現在利用可能な部分だけを描きます。
            g.drawImage(resizeImage, 0, 0, null);
            // dispose(): Graphicsインスタンスの破棄
            //			  Graphicsは、その内部でOSにあるAPIなどのJava仮想マシン外の機能を使い、
            //			  OSのメモリを余計に消費してしまうため、getGraphicsでGraphicsを取り出した時には、使い終わったらdisposeしておくべし
            g.dispose();
            // write(): BufferedImageクラスのオブジェクトとして作られた画像データをエンコードして書き込める
            // ImageIO.write(bufferedImage, フォーマット名, new File(ファイル名));
            ImageIO.write(newImage, "jpg", oldFile);
            
            // 変更後のファイル名
			File newFile = new File(rootPath + "\\" + newFileName);		
			
			if (!oldFile.renameTo(newFile)) {
				buf = new byte[1024];
				// FileInputStream(): ファイルを読み込み、ファイルの内容を元にした処理や新しいファイルの作成などを行うために使う
				// FileInputStreamクラスを使うと、ファイルはバイトストリームで読み込まれる。
				fin = new FileInputStream(oldFile);
				// FileOutputStream(): ファイルにバイト単位のデータを書き込むときに使用する出力ストリーム
				fout = new FileOutputStream(newFile);
				read = 0;
				// read(): 入力ストリームからバイト配列に読み込み
				// 戻り値はint型で、データの次のバイトを返し、ファイルの終わりに達した場合は-1を返す。
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					// write(): バイト配列の内容を出力ストリームにかきだす
					fout.write(buf, 0, read);
				}
				// ストリームを閉じる
				fin.close();
				fout.close();
				oldFile.delete();
			}
			
			int member_no = Integer.parseInt(multi.getParameter("member_no"));
			Member member = new Member(); 
			member.setMember_no(member_no);
			// DBにはファイル名を格納する
			member.setMember_image_fileurl(newFileName);
			MemberDAO memberDAO = new MemberDAO();
			// DBに画像のファイル名を保存
			memberDAO.uploadMemberImage(member);
		  
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uploadImageOk.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error: " + e); 
			e.printStackTrace(); 
		}
	}
	
}
