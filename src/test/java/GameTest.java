import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


public class GameTest {
    Game game = new Game();

    HashMap<Integer, Player> players = new HashMap<>();
    ;
    Player player1 = new Player(12, "Ivanov", 35);
    Player player2 = new Player(15, "Petrov", 45);
    Player player3 = new Player(8, "Sidorov", 51);
    Player player4 = new Player(18, "Frolov", 35);

    @BeforeEach
    public void setup() {
        game.register(player1.getId(), player1);
        game.register(player2.getId(), player2);
        game.register(player3.getId(), player3);
        game.register(player4.getId(), player4);
    }

    // соревнования - первый не зарегистрирован
    @Test
    public void testСompetitionsNoRegFirst() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Petrovvv", "Frolov"));
    }

    // соревнования - второй не зарегистрирован
    @Test
    public void testСompetitionsNoRegSecond() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Petrov", "Frolovww"));
    }

    // соревнования - оба не зарегистрированы
    @Test
    public void testСompetitionsNoRegFirstandSecond() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Petrovsd", "Frolovww"));
    }

    // соревнования - победа 1-го
    @Test
    public void testСompetitionsVictoryFirst() {
        int excepted = 1;
        int actual = game.round("Petrov", "Frolov");
        Assertions.assertEquals(excepted, actual);
    }

    // соревнования - победа 2-го
    @Test
    public void testСompetitionsVictorySecond() {
        int excepted = 2;
        int actual = game.round("Petrov", "Sidorov");
        Assertions.assertEquals(excepted, actual);
    }

    // соревнования - ничья
    @Test
    public void testСompetitionsVictoryDraw() {
        int excepted = 0;
        int actual = game.round("Ivanov", "Frolov");
        Assertions.assertEquals(excepted, actual);
    }
}
