package ru.zvo.game;

import ru.zvo.exception.NotEnoughSpaceException;
import ru.zvo.game.board.Board;
import ru.zvo.game.board.Direction;

public interface Game {

    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem() throws NotEnoughSpaceException;

    Board getGameBoard();

    boolean hasWin();

}
