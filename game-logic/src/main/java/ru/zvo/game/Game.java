package ru.zvo.game;

import org.springframework.stereotype.Component;
import ru.zvo.exception.NotEnoughSpaceException;
import ru.zvo.game.board.Board;
import ru.zvo.game.board.Direction;
import ru.zvo.game.board.Key;

@Component
public interface Game {

    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem() throws NotEnoughSpaceException;

    Board<Key, Integer> getGameBoard();

    boolean hasWin();

}
