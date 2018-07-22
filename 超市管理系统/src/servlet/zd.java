package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class zd
 */
@WebServlet("/zd")
public class zd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public zd() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String zdname=request.getParameter("mc");
		String gys=request.getParameter("gys");
		String zdje=request.getParameter("je");
		String fukuan=request.getParameter("fk");
		String time=request.getParameter("newtime");
		String zdnumber=request.getParameter("bh");
		System.out.println(zdname+gys+zdje+fukuan+time+zdnumber);
		System.out.println("成功连接数据库！");
	}

}
