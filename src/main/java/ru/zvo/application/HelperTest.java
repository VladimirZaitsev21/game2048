package ru.zvo.application;

import ru.zvo.game.utils.GameHelper;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
public class HelperTest {
    private final static GameHelper helper = new GameHelper();

    public static void main(String[] args) {
        assertEquals(helper.moveAndMergeEqual(asList(1, 2, null, 3)), asList(1, 2, 3, null));
        assertEquals(helper.moveAndMergeEqual(asList(2, 2, null, 3)), asList(4, 3, null, null));
        assertEquals(helper.moveAndMergeEqual(asList(2, 2, 4, 4)), asList(4, 8, null, null));
        assertEquals(helper.moveAndMergeEqual(asList(2, 2, 2, 3)), asList(4, 2, 3, null));
        assertEquals(helper.moveAndMergeEqual(asList(2, null, null, 2)), asList(4, null, null, null));
    }


    public static void assertEquals(List list1, List list2) {
        if (!list1.equals(list2)) throw new RuntimeException("List1: " + list1 + " not equals List2: " + list2);
    }
}

