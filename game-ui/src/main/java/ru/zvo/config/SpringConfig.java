package ru.zvo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.zvo.game.board.Board;
import ru.zvo.game.board.Key;
import ru.zvo.game.board.SquareBoard;
import ru.zvo.view.Game2048Panel;

import javax.swing.*;
import java.util.Random;

@Configuration
@ComponentScan("ru.zvo")
public class SpringConfig {

    @Bean
    public JFrame jFrame(Game2048Panel game2048Panel) {
        JFrame game = new JFrame();
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(340, 360);
        game.setResizable(false);

        game.add(game2048Panel);

        game.setLocationRelativeTo(null);
        game.setVisible(true);
        return game;
    }

    @Bean
    public Board<Key, Integer> squareBoard() {
        return new SquareBoard<>(4);
    }
    @Bean
    public Random random() {
        return new Random();
    }

}
