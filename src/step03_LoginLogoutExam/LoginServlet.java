package step03_LoginLogoutExam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost....");
		//private static final long serialVersionUID = 1L;
		resp.setContentType("text/html;charset=utf-8");//이거 안해주면 물음표로 뜸 
		//req.setCharacterEncoding("utf-8");


		String id=req.getParameter("userId");
		String pwd=req.getParameter("userPwd");
		String name=req.getParameter("userName");

		PrintWriter out=resp.getWriter();


		if(id.equals("ch") && pwd.equals("1234")){
			HttpSession session = req.getSession();


			//String str = (String) session.getAttribute("id");

			//인증된 사용자의 정보를 세션에 저장하기!!
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionName", name);
			session.setAttribute("sessionTime", new Date().toLocaleString());

			//쿠키에 저장하기 
			Cookie co =new Cookie("cookieID", id);
			co.setMaxAge(60*60*24*365);
			co.setPath("/");
			resp.addCookie(co);

			//이동 
			resp.sendRedirect("../LoginOk.jsp");

		}else {
			//메세지 출력
			//뒤로가기 
			out.println("<script>");
			out.println("alert('"+name+"님 회원정보를 확인해주세요');");
			out.println("history.back();");
			out.println("</script>");

		}
	}
}
