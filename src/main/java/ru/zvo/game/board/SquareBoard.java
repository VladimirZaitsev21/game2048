package ru.zvo.game.board;

import java.util.*;

public class SquareBoard  extends Board {

    private final int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    public void fillBoard(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.put(new Key(i, j), list.get(i * size + j));
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        List<Key> keys = new ArrayList<>();
        for (Map.Entry<Key, Integer> entry: board.entrySet()) {
            if(entry.getValue() == null) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.putIfAbsent(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        for (Key key: board.keySet()) {
            if (key.getI() == i && key.getJ() == j) {
                return key;
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        List<Key> keys = new ArrayList<>(board.size());
        for (Key key: board.keySet()) {
            if (key.getJ() == j) {
                keys.add(key);
            }
        }
        keys.sort(Comparator.comparingInt(Key::getI));
        return keys;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> keys = new ArrayList<>(board.size());
        for (Key key: board.keySet()) {
            if (key.getI() == i) {
                keys.add(key);
            }
        }
        keys.sort(Comparator.comparingInt(Key::getJ));
        return keys;
    }

    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        keys.forEach(x -> values.add(board.get(x)));
        return values;
    }
}
