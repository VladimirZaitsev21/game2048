package ru.zvo.application;

import ru.zvo.game.board.Board;
import ru.zvo.game.Game;
import ru.zvo.game.Game2048;
import ru.zvo.game.board.SquareBoard;

public class TestClass {

    public static void main(String[] args) {
        Board board = new SquareBoard(4);
        Game game2048 = new Game2048(board);
        System.out.println(game2048.canMove());
    }

}
