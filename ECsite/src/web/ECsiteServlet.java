package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ECsiteServlet extends HttpServlet {

//⑤web.xmlから入力された値を受け取っている(dopost形式)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

//⑥nameとpasswordという名前の入力された値を受けとっている
		String name =req.getParameter("name");
		String password =req.getParameter("password");

//⑦ECsiteJDBCというクラスをインスタンス化している
//　※ECsiteJDBCに移動
		ECsiteJDBC JDBC = new ECsiteJDBC();

//16.JDBCクラスの実行結果のboolean型のflgを受け取っている
		boolean flg= JDBC.execute(name,password);

//17. Dispatcherを使い、flgの結果によってリンクを変えている
		if(flg) {
			RequestDispatcher rd =req.getRequestDispatcher("Search.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd =req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}

		req.setAttribute("result",JDBC);

	}

}
