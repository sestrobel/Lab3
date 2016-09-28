package pokerBase;

import java.util.ArrayList;
import java.util.UUID;

public class Game {

	private UUID GameID;
	private UUID TableID;
	private ArrayList<Player> GamePlayers = new ArrayList<Player>();
	// Methods: AddPlayerToGame(Table, Player)

	public Game() {
		GameID = UUID.randomUUID();
	}

	public Game(ArrayList<Player> gamePlayers) {
		GameID = UUID.randomUUID();
		GamePlayers = gamePlayers;
	}

	public UUID getGameID() {
		return GameID;
	}

	// public void setGameID(UUID gameID) {
	// GameID = gameID;
	// }
	public UUID getTableID() {
		return TableID;
	}

	 public void setTableID(UUID tableID) {
	 TableID = tableID;
	 }
	public ArrayList<Player> getGamePlayers() {
		return GamePlayers;
	}

	public void setGamePlayers(ArrayList<Player> gamePlayers) {
		GamePlayers = gamePlayers;
	}
	
	public void AddPlayerToGame(Table t, Player p) {
		TableID = t.getTableID();
		t.AddPlayerToTable(p);
		GamePlayers.add(p);
		return;
		
	}
}
