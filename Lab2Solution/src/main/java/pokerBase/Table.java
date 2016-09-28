package pokerBase;

import java.util.ArrayList;
import java.util.UUID;

public class Table {

	private UUID TableID;
	private ArrayList<Player> players = new ArrayList<Player>();

	public UUID getTableID() {
		return TableID;
	}

//	public void setTableID(UUID tableID) {
//		TableID = tableID;
//	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Table() {
		TableID = UUID.randomUUID();
	}

	public void AddPlayerToTable(Player p) {
		p.setPlayerPosition(players.size());
		players.add(p);
		return;
	}

}
