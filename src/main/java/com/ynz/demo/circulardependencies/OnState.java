package com.ynz.demo.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("on")
public class OnState implements State {
    @Autowired
    private OffState offState;

    private Context context;

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void doAction() {
        if (context.getCurrentState() instanceof OnState) {

            context.setCurrentState(this);
            System.out.println("Turn on power ...");

            //do something here
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            context.setNextState(offState);
        }

    }
}
