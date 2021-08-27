package ru.zvo.game.utils;

import org.junit.jupiter.api.Test;
import ru.zvo.game.utils.GameHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameHelperTest {

    GameHelper helper = new GameHelper();

    @Test
    public void testMergeEqualsShouldReturnNewList() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            integers.add(i);
        }
        assertNotSame(integers, helper.moveAndMergeEqual(integers));
    }

    @Test
    public void testMergeEqualsOfNulls() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integers.add(null);
        }
        assertSame(integers, helper.moveAndMergeEqual(integers));
    }

    @Test
    public void testMergeEqualsWithoutMerging() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integers.add(i);
        }
        assertIterableEquals(integers, helper.moveAndMergeEqual(integers));
    }

    @Test
    public void testMergeEqualsSequential() {
        assertIterableEquals(Arrays.asList(4, 4, null, null), helper.moveAndMergeEqual(Arrays.asList(2, 2, 4, null)));
    }

    @Test
    public void testMergeEqualsMoveOnly() {
        assertIterableEquals(Arrays.asList(2, 8, null, null), helper.moveAndMergeEqual(Arrays.asList(2, null, null, 8)));
    }

    @Test
    public void testMergeEqualsBoth() {
        assertIterableEquals(Arrays.asList(32, null, null, null), helper.moveAndMergeEqual(Arrays.asList(16, null, null, 16)));
    }

    @Test
    public void testMergeEqualsEmpty() {
        List<Integer> emptyList = Collections.emptyList();
        assertSame(emptyList, helper.moveAndMergeEqual(emptyList), "If list is empty should return this list!");
    }

}
