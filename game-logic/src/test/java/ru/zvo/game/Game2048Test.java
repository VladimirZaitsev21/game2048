package ru.zvo.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.zvo.game.Game2048;
import ru.zvo.game.board.Board;
import ru.zvo.game.board.Key;
import ru.zvo.game.utils.GameHelper;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Game2048Test {


    @Mock
    Board<Key, Integer> board;

    @Mock
    Random random;

    @Mock
    GameHelper helper;

    @InjectMocks
    Game2048 game;

    @Captor
    ArgumentCaptor<List<Integer>> captor;

    @Test
    public void testInit() {
        doNothing().when(board).fillBoard(captor.capture());
        when(board.availableSpace()).thenReturn(Arrays.asList(new Key(1, 1)));
        game.init();
        verify(board).fillBoard(anyList());
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            integers.add(null);
        }
        assertEquals(integers, captor.getValue());
    }

    @Test
    public void testCanMoveTrue() {
        List<Key> returnedResult = new ArrayList<>();
        returnedResult.add(new Key(1, 1));
        returnedResult.add(new Key(2, 2));
        when(board.availableSpace()).thenReturn(returnedResult);
        assertTrue(game.canMove());
    }

    @Test
    public void testCanMoveFalse() {
        when(board.availableSpace()).thenReturn(Collections.emptyList());
        assertFalse(game.canMove());
    }
}
