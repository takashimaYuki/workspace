package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword =req.getParameter("product_name");
		String category =req.getParameter("product_category");

		SearchJDBC SJDBC= new SearchJDBC();

		String Keyword= SJDBC.execute(keyword,category);
//		String ProName= SJDBC.execute(category);

		if(Keyword!=(null)){
			System.out.println(Keyword);
			RequestDispatcher rd =req.getRequestDispatcher("SearchResult.jsp");
			rd.forward(req, resp);

		}else {
			System.out.println("見つかりませんでした");
			RequestDispatcher rd =req.getRequestDispatcher("SearchResult.jsp");
			rd.forward(req, resp);
		}
		}
}
