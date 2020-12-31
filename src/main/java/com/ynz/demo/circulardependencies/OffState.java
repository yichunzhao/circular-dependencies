package com.ynz.demo.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("off")
public class OffState implements State {
    @Autowired
    private OnState onState;

    private Context context;

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void doAction() {
        System.out.println("turn off Radio ....");
        if (context.getCurrentState() instanceof OffState) {
            context.setCurrentState(this);

            //do something here
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            context.setNextState(onState);
        }

    }
}
