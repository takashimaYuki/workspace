package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class SearchJDBC {

	public String execute(String keyword,String category) {

		String Product=null;
		String Category=null;

		HttpSession session = req.getSession(true);



		String url = "jdbc:mysql://localhost/ECsite?autoReconnect=true&useSSL=false";

		String id ="root";

		String pw = "password";

		Connection cnct = null;
		Statement st =null;
		ResultSet rs = null;


		try {
			Class.forName("com.mysql.jdbc.Driver");

			cnct =DriverManager.getConnection(url,id,pw);

			st =cnct.createStatement();

			//接続情報(st)を元に""内のSQL文を実行する。
			//実行結果をrsに格納する。
			//※rsには実行結果のテーブルが格納されているイメージ
			//MySQL上の実行結果が格納されているイメージでも可。
			//12.実行したいSQL文を記載し実行結果を変数rsに格納している

			rs = st.executeQuery("SELECT * FROM product");
//			+"SELECT * FROM category");

			// カーソルが終了するまでループ
			while(rs.next()) {

				// 各データを格納する
				//13.DBのカラム"login_pw"と"user_name"の値を取得している
				String dbproname =rs.getString("pro_name");
//				String dbcatname =rs.getString("cat_name");

				//14.DBのlogin_pwとuser_nameが一致しているか結果によってflgの値を変えている
				if(dbproname.equals(keyword)){
//						&&(dbcatname.equals(category))) {
					Product =dbproname;
//					Category =dbcatname;
				} else {
					System.out.println("なにもありませんでした");
				}
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (rs!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
		return Product+Category;
	}
}
