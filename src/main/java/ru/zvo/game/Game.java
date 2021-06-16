package ru.zvo.game;

import ru.zvo.game.board.Board;
import ru.zvo.game.board.Direction;

public interface Game {

    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem();

    Board getGameBoard();

    boolean hasWin();

}
