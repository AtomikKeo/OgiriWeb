package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Account;
import model.logic.LoginLogic;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginLogic loginLogic = new LoginLogic();
		Account account = loginLogic.login(id, pass);
		
		ProcessBuilder pb = new ProcessBuilder(
	            "curl",
	            "-X", "POST", "\"https://us-south.dynamic-dashboard-embedded.cloud.ibm.com/daas/v1/session\"",
	            "-H", "\"accept: application/json\"",
	            "-u", "b8c5ffc5-50dc-4149-8fb6-7b233e63a99d:62405c64ded7ff3c0c7ea9ccbdea9a3179e2fdc1",
	            "-H", "\"Content-Type: application/json\"",
	            "-d", "\"{ \\\"expiresIn\\\":3600, \\\"webDomain\\\":\\\"http://localhost:8080\\\"}\"");
	    pb.redirectErrorStream(true);
	    Process p = pb.start();
        String sessionCode = "";
	    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.defaultCharset()))) {
            String line;
            while ((line = r.readLine()) != null) {
            	int index = line.indexOf("sessionCode");
            	if(index!=-1) {
            		int endIndex = line.indexOf("\"", index+14);
            		sessionCode = line.substring(index+14, endIndex);
            		break;
            	}
            }
        }
        System.out.println(sessionCode);

		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAccount", account);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Top");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMsg", "アカウントが存在しないか、ID・パスワードが間違っています");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
