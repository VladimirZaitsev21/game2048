package ru.zvo.game.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.zvo.game.board.Key;
import ru.zvo.game.board.SquareBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SquareBoardTest {

    SquareBoard<Integer> squareBoard;

    @BeforeEach
    public void initSquareBoard() {
        squareBoard = new SquareBoard<>(4);
    }

    @Nested
    class testFillBoard {

        @Test
        public void testFillBoardWrongListSize() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 17; i++) {
                list.add(i);
            }
            assertThrows(RuntimeException.class,
                    () -> squareBoard.fillBoard(list)
            );
        }

        @Test
        public void testFillBoardLessSize() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            assertThrows(RuntimeException.class,
                    () -> squareBoard.fillBoard(list)
            );
        }
    }

    @Nested
    class testAvailableSpace {

        @Test
        public void testAvailableSpaceWithEmptyBoard() {
            List<Key> result = squareBoard.availableSpace();
            assertIterableEquals(result, Collections.emptyList());
        }

        @Test
        public void testAvailableSpaceNotEmpty() {
            List<Integer> initList = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (i % 2 == 0) {
                    initList.add(i);
                } else {
                    initList.add(null);
                }
            }
            squareBoard.fillBoard(initList);
            assertEquals(8, squareBoard.availableSpace().size());
        }
    }

    @Nested
    class testGetValue {

        @Test
        public void testGetNonExistingValue() {
            assertNull(squareBoard.getValue(new Key(100, 100)));
        }

        @Test
        public void testGetExistingNullValue() {
            List<Integer> initList = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (i % 2 == 0) {
                    initList.add(i);
                } else {
                    initList.add(null);
                }
            }
            squareBoard.fillBoard(initList);
            assertNull(squareBoard.getValue(new Key(0, 1)));
        }

        @Test
        public void  testGetExistingValue() {
            List<Integer> initList = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (i % 2 == 0) {
                    initList.add(i);
                } else {
                    initList.add(null);
                }
            }
            squareBoard.fillBoard(initList);
            assertNotNull(squareBoard.getValue(new Key(0, 0)));
        }
    }

}
