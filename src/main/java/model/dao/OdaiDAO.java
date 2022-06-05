package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Odai;

public class OdaiDAO {
	
	private Connection con;
	public OdaiDAO(Connection con) {
		this.con = con;
	}
	public Odai select(String id) throws SQLException{
		Odai odai = null;
		String sql = "SELECT ID, TYPE, THEME, DUE_TIME, STATUS, ALLOW_MULTI_POST FROM ODAI WHERE ID = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,id);
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			int odaiId = rs.getInt("ID");
			int type = rs.getInt("TYPE");
			String theme = rs.getString("THEME");
			java.util.Date dueTime = rs.getTimestamp("DUE_TIME");
			int status = rs.getInt("STATUS");
			boolean allowMultiPost = rs.getBoolean("ALLOW_MULTI_POST");
			
			
			odai = new Odai(odaiId, type, theme, dueTime, status, allowMultiPost);
		}
		pStmt.close();
		return odai;
	}
	
	public List<Odai> selectAll() throws SQLException{
		List<Odai> odaiList = new ArrayList<>();
	
		String sql = "SELECT ID, TYPE, THEME, DUE_TIME, STATUS, ALLOW_MULTI_POST FROM ODAI";
		PreparedStatement pStmt = con.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			int odaiId = rs.getInt("ID");
			int type = rs.getInt("TYPE");
			String theme = rs.getString("THEME");
			java.util.Date dueTime = rs.getTimestamp("DUE_TIME");
			int status = rs.getInt("STATUS");
			boolean allowMultiPost = rs.getBoolean("ALLOW_MULTI_POST");
			
			
			Odai odai = new Odai(odaiId, type, theme, dueTime, status, allowMultiPost);
			odaiList.add(odai);
		}
		pStmt.close();
		return odaiList;
		
	}
	/*
	public int insert (Account accout) throws SQLException{
		String sql = "INSERT INTO ACCOUNT(ID, NAME, PASS, DISCORD_ID) VALUES(?, ?, ?, ?)";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, accout.getId());
		pStmt.setString(2, accout.getName());
		pStmt.setString(3, accout.getPass());
		pStmt.setString(4, accout.getDiscordId());
		int r = pStmt.executeUpdate();
		pStmt.close();
		return r;
	}
	
	public int update (Account accout) throws SQLException{
		String sql = "UPDATE ACCOUNT SET NAME = ?, PASS = ?, DISCORD_ID = ?"
				+ " WHERE ID = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, accout.getName());
		pStmt.setString(2, accout.getPass());
		pStmt.setString(3, accout.getDiscordId());
		pStmt.setString(4, accout.getId());
		int r = pStmt.executeUpdate();
		pStmt.close();
		return r;
	}
	*/
	public int delete (Odai odai) throws SQLException{
		String sql = "DELETE FROM ODAI WHERE ID=?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setInt(1, odai.getId());
		int r = pStmt.executeUpdate();
		pStmt.close();
		return r;
	}
}
