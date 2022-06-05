package model.entity;

public class Account {
	private String id;
	private String name;
	private String pass;
	private String discordId;
	
	
	public Account(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Account(String id, String name, String pass, String discordId) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.discordId = discordId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDiscordId() {
		return discordId;
	}
	public void setDiscordId(String discordId) {
		this.discordId = discordId;
	}
	
	
}
