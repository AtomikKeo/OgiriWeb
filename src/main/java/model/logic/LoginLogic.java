package model.logic;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.AccountDAO;
import model.entity.Account;
import util.DBUtil;

public class LoginLogic {
	
	
	public Account login(String id, String pass) {
		DBUtil db = new DBUtil();
		Connection con = null;
		
		try {
			con = db.getConnection();
			AccountDAO dao = new AccountDAO(con);
			Account account = dao.select(id);
			
			boolean isLogin = (account != null && pass.equals(account.getPass())
								&& id.equals(account.getId()));
			if(isLogin) {
				return account;
			}else {
				return null;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			db.closeConnenction(con);
		}
		
	}
}
