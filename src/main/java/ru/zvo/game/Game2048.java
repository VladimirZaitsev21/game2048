package ru.zvo.game;

import ru.zvo.game.board.Board;
import ru.zvo.game.board.Direction;
import ru.zvo.game.utils.GameHelper;

import java.util.Random;

public class Game2048 implements Game {

    private final GameHelper helper = new GameHelper();
    private final Random random = new Random();
    private final Board board;

    public Game2048(Board board) {
        this.board = board;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
