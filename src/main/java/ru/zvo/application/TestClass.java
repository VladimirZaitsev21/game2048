package ru.zvo.application;

import ru.zvo.game.board.Board;
import ru.zvo.game.Game;
import ru.zvo.game.Game2048;
import ru.zvo.game.board.SquareBoard;
import ru.zvo.game.utils.GameHelper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TestClass {

    public static void main(String[] args) {
//        Board board = new SquareBoard(4);
//        Game game2048 = new Game2048(board);
//        System.out.println(game2048.canMove());

        GameHelper gameHelper = new GameHelper();
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(3);
        list.add(2);
//        list.add(null);
//        list.add(4);
//        list.add(5);
        List<Integer> listAfterProcess = gameHelper.moveAndMergeEqual(list);
        listAfterProcess.forEach(System.out::println);

//        Board board = new SquareBoard(2);
//        board.fillBoard(asList(1, 2, 3, null));
    }

}
