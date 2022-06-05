package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Account;

public class AccountDAO {
	private Connection con;
	public AccountDAO(Connection con) {
		this.con = con;
	}
	
	
	public Account select(String id) throws SQLException{
		Account account = null;
		String sql = "SELECT ID, NAME, PASS, DISCORD_ID FROM ACCOUNT WHERE ID = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,id);
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			String accountId = rs.getString("ID");
			String name = rs.getString("NAME");
			String pass = rs.getString("PASS");
			String discordId = rs.getString("DISCORD_ID");
			
			account = new Account(accountId, name, pass, discordId);
		}
		pStmt.close();
		return account;
	}
	
	public List<Account> selectAll() throws SQLException{
		List<Account> accountList = new ArrayList<>();
		String sql = "SELECT ID, NAME, PASS, DISCORD_ID FROM ACCOUNT";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			String accountId = rs.getString("ID");
			String name = rs.getString("NAME");
			String pass = rs.getString("PASS");
			String discordId = rs.getString("DISCORD_ID");
			
			Account account = new Account(accountId, name, pass, discordId);
			accountList.add(account);
		}
		pStmt.close();
		return accountList;
		
	}
	
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
	
	public int delete (Account accout) throws SQLException{
		String sql = "DELETE FROM ACCOUNT WHERE ID=?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, accout.getId());
		int r = pStmt.executeUpdate();
		pStmt.close();
		return r;
	}
	
	
	
}
