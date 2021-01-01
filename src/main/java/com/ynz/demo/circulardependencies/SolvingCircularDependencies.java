package com.ynz.demo.circulardependencies;

import com.ynz.demo.circulardependencies.states.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class SolvingCircularDependencies {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext appletContext = new AnnotationConfigApplicationContext(AppConfig.class);
        RadioContext radio = appletContext.getBean("radio", RadioContext.class);
        State onState = appletContext.getBean("on", State.class);

        radio.setCurrentState(onState);

        IntStream.range(1, 10).forEach(i -> radio.pressButton());
    }
}
