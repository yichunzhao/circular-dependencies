package com.ynz.demo.circulardependencies;

import com.ynz.demo.circulardependencies.config.AppConfig;
import com.ynz.demo.circulardependencies.context.RadioContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class SolvingCircularDependencies {

    public static void main(String[] args) {
        ApplicationContext appletContext = new AnnotationConfigApplicationContext(AppConfig.class);
        RadioContext radio = appletContext.getBean("radio", RadioContext.class);

        IntStream.range(1, 10).forEach(i -> radio.pressButton());
    }
}
