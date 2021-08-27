package ru.zvo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.zvo.config.SpringConfig;
import ru.zvo.view.Game2048Panel;

import javax.swing.*;
import java.util.ResourceBundle;

public class PlayGame {

    private static final Logger logger = LoggerFactory.getLogger(PlayGame.class);

    public static void main(String[] args) {
        ResourceBundle artifactBundleInfo = ResourceBundle.getBundle("artifact_info");
        ResourceBundle gitBundleInfo = ResourceBundle.getBundle("git");
        logger.info("ARTIFACT INFO:");
        logger.info(artifactBundleInfo.getString("groupId"));
        logger.info(artifactBundleInfo.getString("artifactId"));
        logger.info(artifactBundleInfo.getString("version"));
        logger.info("GIT INFO:");
        logger.info(gitBundleInfo.getString("git.commit.id.full"));
        logger.info(gitBundleInfo.getString("git.commit.message.full"));
        logger.info(gitBundleInfo.getString("git.commit.user.email"));
        logger.info(gitBundleInfo.getString("git.commit.user.name"));
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
