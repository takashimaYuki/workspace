package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ECsiteJDBC {

	public boolean execute(String name,String password) {

		boolean flg =false;

//⑧DBに接続するために必要な情報を変数に定義している。
//　接続する場所を定義（URLとして）
		String url = "jdbc:mysql://localhost/ECsite?autoReconnect=true&useSSL=false";

//⑨接続する際のIDを定義
		String id ="root";

//⑩接続する際のパスワードを定義
		String pw = "password";

//11.接続する情報を保管している
		Connection cnct = null;
		Statement st =null;
		ResultSet rs = null;


		try {
			//MysqlのJDBCドライバを読み込ませるための記述
			Class.forName("com.mysql.jdbc.Driver");
			//JDBCのドライバがなかったらclassnotfound exception


			////引数（url,id,pw）を元に、実際にDBに接続する。
			//cnctの代入結果としては、接続が成功したか失敗したか
			// の結果が格納される。
			cnct =DriverManager.getConnection(url,id,pw);

			//接続に成功した場合は、stに接続情報を設定する。
			//生成後stに接続情報を代入する。
			st =cnct.createStatement();

			//接続情報(st)を元に""内のSQL文を実行する。
			//実行結果をrsに格納する。
			//※rsには実行結果のテーブルが格納されているイメージ
			//MySQL上の実行結果が格納されているイメージでも可。
//12.実行したいSQL文を記載し実行結果を変数rsに格納している
			rs = st.executeQuery("SELECT * FROM user");

			// カーソルが終了するまでループ
			while(rs.next()) {

				// 各データを格納する
//13.DBのカラム"login_pw"と"user_name"の値を取得している
				String dbpassword =rs.getString("login_pw");
				String dbname =rs.getString("user_name");

//14.DBのlogin_pwとuser_nameが一致しているか結果によってflgの値を変えている
				if((dbpassword.equals(password))&&(dbname.equals(name))) {
					flg = true;
					return flg;
				} else {
					flg=false;
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
//15.実行結果に基づくboolean型のflgの値を返している
		return flg;
	}
}
