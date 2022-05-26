package es.hulk.domino.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private static List<Player> playerList = new ArrayList<>();

    public static void addPlayer(Player player) {
        player.setId(player.getId() + 1);
        playerList.add(player);
    }

    public static Player getWinner() {
        for (Player player : playerList) if (player.isWinner()) return player;
        return null;
    }


}
