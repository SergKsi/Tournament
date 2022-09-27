import java.util.HashMap;

public class Game {
    // Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде HashMap.
    HashMap<Integer, Player> players = new HashMap<>(); // храним всех зарегистрированных игроков в HashMap

    // дата-класс игрока player (id, name, strength)
    // players - массив
    // player - элемент массива

    // Метод регистрации игрока.
    // Если игрок НЕ зарегистрирован, то он НЕ сможет играть в турнире.
    public void register(Integer key, Player player) {
        players.put(key, player);
    }

    // Метод соревнования между двумя игроками.

    // Если хотя бы один из игроков незарегистрирован,
    // должно выкинуться исключение NotRegisteredException (сами создайте его класс).

    // Обратите внимание, что игроки передаются методу через имя - полную информацию
    // об игроке нужно будет найти в коллекции зарегистрированных игроков
    // (см. аналог в виде findById из прошлых дз).
    // Выигрывает тот игрок, у которого больше strength (сила);
    // если сила одинаковая, то будет ничья. Метод должен возвращать одно число - 0 в случае ничьи,
    // 1 в случае победы первого игрока и 2 в случае победы второго игрока.

    public int round(String playerName1, String playerName2) {
        // игрок  playerName1 или игрок playerName2 не зарегистрированы
        Player player1 = null;
        Player player2 = null;
        for (Integer key : players.keySet()) {
            if (players.get(key).getName().equals(playerName1)) {
                player1 = players.get(key);
            }
            if (players.get(key).getName().equals(playerName2)) {
                player2 = players.get(key);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
