package model.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.dao.OdaiDAO;
import model.entity.Odai;
import util.DBUtil;

public class GetOdaiListLogic {
	public List<Odai> execute() {
		DBUtil db = new DBUtil();
		Connection con = null;
		
		try {
			con = db.getConnection();
			OdaiDAO dao = new OdaiDAO(con);
			List<Odai> odaiList = dao.selectAll();
			
			return odaiList;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			db.closeConnenction(con);
		}
		
	}
}
