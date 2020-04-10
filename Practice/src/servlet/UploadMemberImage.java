package servlet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String rootPath = request.getSession().getServletContext().getRealPath("UploadImage");
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
			MultipartRequest multi = new MultipartRequest(request, rootPath, maxsize, "UTF-8", new DefaultFileRenamePolicy());		
			// 画像アップロード
			uploadFileName = multi.getFilesystemName("member_imagefile");
			newFileName = simDf.format(new Date(currentTime)) + "." + uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
			
			File oldFile = new File(rootPath + "\\" + uploadFileName);
			File newFile = new File(rootPath + "\\" + newFileName);
			
			if (!oldFile.renameTo(newFile)) {
				buf = new byte[1024];
				fin = new FileInputStream(oldFile);
				fout = new FileOutputStream(newFile);
				read = 0;
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				fin.close();
				fout.close();
				oldFile.delete();
			}
			
			// DBに画像のファイル名を保存　実装中
			int member_no = Integer.parseInt(multi.getParameter("member_no"));
			Member member = new Member(); 
			member.setMember_no(member_no);
			MemberDAO memberDAO = new MemberDAO();
//			request.setAttribute("member", member);
//		  
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberInfo.jsp");
//			dispatcher.forward(request, response); 
		} catch (Exception e) {
			System.out.println("Error: " + e); 
			e.printStackTrace(); 
		}
	}
	
}
