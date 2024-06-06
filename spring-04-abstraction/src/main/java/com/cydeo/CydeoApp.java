package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import com.cydeo.service.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        // Here is a hard coded comment, in the real life this will come from outside
        Comment comment = new Comment();
        comment.setAuthor("Emre");
        comment.setText("my comment coming from database");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.publishNotification(comment);
    }
}
