package com.ave.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {
    private Main main;
    private UUID uuid;
    private String rank;
    private int coins;

    public CustomPlayer(Main main, UUID uuid) throws SQLException {
        this.uuid = uuid;
        this.main = main;
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("SELECT RANK, COINS FROM players WHERE UUID = ?;");
            statement.setString(1, uuid.toString());
            ResultSet rs = statement.executeQuery();
            if(rs.next()) { //If exist in database then load
                rank = rs.getString("RANK");
                coins = rs.getInt("COINS");
            } else {
                rank = "GUEST";
                coins = 0;
                PreparedStatement statement1 = main.getDatabase().getConnection().prepareStatement("INSERT INTO players (ID, UUID, RANK, COINS) VALUES(" +
                        "default," + "'" + uuid + "'," + "'" + rank + "'," + coins + ");");
                statement1.executeUpdate();
            }
    }

    public String getRank() { return rank; }
    public int getCoin() { return coins; }

    public void setRank(String rank) {
        this.rank = rank;
        try {
            PreparedStatement ps = main.getDatabase().getConnection().prepareStatement("UPDATE players SET RANK = '" +  rank + "' WHERE UUID = '" + uuid + "';");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setCoins(int coins) {
        this.coins = coins;
        try {
            PreparedStatement ps = main.getDatabase().getConnection().prepareStatement("UPDATE players SET COINS = " +  coins + " WHERE UUID = '" + uuid + "';");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
