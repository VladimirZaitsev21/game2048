package ru.zvo.game;

import ru.zvo.game.board.Board;
import ru.zvo.game.board.Direction;
import ru.zvo.game.board.Key;
import ru.zvo.game.board.SquareBoard;
import ru.zvo.game.utils.GameHelper;

import java.util.*;

public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    private final GameHelper helper = new GameHelper();
    private final Random random = new Random();

    @Override
    public void init() {
        List<Integer> list = new ArrayList<>(GAME_SIZE * GAME_SIZE);
        for (int i = 0; i < GAME_SIZE * GAME_SIZE; i++) {
            list.add(null);
        }
        board.fillBoard(list);
        addItem();
        addItem();
    }

    @Override
    public boolean canMove() {
        if (board.availableSpace().size() == 0) {
            return checkMovePossibility();
        } else {
            return true;
        }
    }

    private boolean checkMovePossibility() {
        List<List<Key>> keys = new ArrayList<>();
        List<List<Integer>> lines = new ArrayList<>();
        List<List<Integer>> linesAfterMerging = determineBoardValuesAfterMove(Direction.LEFT, keys, lines);
        if (!lines.equals(linesAfterMerging)) {
            return true;
        } else {
            keys = new ArrayList<>();
            lines = new ArrayList<>();
            linesAfterMerging = determineBoardValuesAfterMove(Direction.TOP, keys, lines);
            return !lines.equals(linesAfterMerging);
        }
    }
    @Override
    public boolean move(Direction direction) {
        List<List<Key>> keys = new ArrayList<>();
        List<List<Integer>> lines = new ArrayList<>();
        List<List<Integer>> linesAfterMerging = determineBoardValuesAfterMove(direction, keys, lines);
        if (!lines.equals(linesAfterMerging)) {
            putItemsToBoard(keys, linesAfterMerging);
            addItem();
            return true;
        } else {
            return false;
        }
    }

    private List<List<Integer>> determineBoardValuesAfterMove(Direction direction, List<List<Key>> keys, List<List<Integer>> lines) {
        List<List<Integer>> linesAfterMerging = new ArrayList<>();
        switch (direction) {
            case TOP:
                fillColumnsKeys(keys);
                linesAfterMerging = mergeLinesByKeys(keys, lines, false);
                break;
            case LEFT:
                fillRowsKeys(keys);
                linesAfterMerging = mergeLinesByKeys(keys, lines, false);
                break;
            case BOTTOM:
                fillColumnsKeys(keys);
                linesAfterMerging = mergeLinesByKeys(keys, lines, true);
                break;
            case RIGHT:
                fillRowsKeys(keys);
                linesAfterMerging = mergeLinesByKeys(keys, lines, true);
                break;
            default:
                break;
        }
        return linesAfterMerging;
    }

    private void putItemsToBoard(List<List<Key>> keys, List<List<Integer>> lines) {
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.get(i).size(); j++) {
                board.addItem(keys.get(i).get(j), lines.get(i).get(j));
            }
        }
    }

    private List<List<Integer>> mergeLinesByKeys(List<List<Key>> keys, List<List<Integer>> lines, boolean isReverseNeeded) {
        List<List<Integer>> linesAfterMerging = new ArrayList<>();
        fillLinesWithValues(keys, lines);
        if (isReverseNeeded) {
            lines.forEach(Collections::reverse);
        }
        lines.forEach(x -> linesAfterMerging.add(helper.moveAndMergeEqual(x)));
        if (isReverseNeeded) {
            lines.forEach(Collections::reverse);
            linesAfterMerging.forEach(Collections::reverse);
        }
        return linesAfterMerging;
    }

    private void fillRowsKeys(List<List<Key>> lines) {
        for (int i = 0; i < GAME_SIZE; i++) {
            lines.add(board.getRow(i));
        }
    }

    private void fillColumnsKeys(List<List<Key>> lines) {
        for (int i = 0; i < GAME_SIZE; i++) {
            lines.add(board.getColumn(i));
        }
    }

    private void fillLinesWithValues(List<List<Key>> keyLines, List<List<Integer>> lines) {
        for (int i = 0; i < keyLines.size(); i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < keyLines.get(i).size(); j++) {
                line.add(board.getValue(keyLines.get(i).get(j)));
            }
            lines.add(line);
        }
    }

    @Override
    public void addItem() {
        double randomValue = random.nextDouble();
        int cellValue = 4;
        if (randomValue > 0.1) {
            cellValue = 2;
        }
        Key key = getRandomCoordinates(board.availableSpace());
        board.addItem(key, cellValue);
    }

    private Key getRandomCoordinates(List<Key> availableSpace) {
        int keyNumber = random.nextInt(availableSpace.size());
        return availableSpace.get(keyNumber);
    }

    @Override
    public Board<Key, Integer> getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
