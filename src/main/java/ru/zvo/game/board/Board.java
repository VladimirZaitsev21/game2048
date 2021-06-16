package ru.zvo.game.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {

    private final int weight;
    private final int height;
    private final Map<Key, Integer> board = new HashMap<>();

    public Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public abstract void fillBoard(List<Integer> list);

    public abstract List<Key> availableSpace();

    public abstract void addItem(Key key, Integer value);

    public abstract Key getKey(int i, int j);

    public abstract Integer getValue(Key key);

    public abstract List<Key> getColumn(int j);

    public abstract List<Key> getRow(int i);

    public abstract boolean hasValue(Integer value);

    public abstract List<Integer> getValues(List<Key> keys);

}
