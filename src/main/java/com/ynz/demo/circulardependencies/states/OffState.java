package com.ynz.demo.circulardependencies.states;

import com.ynz.demo.circulardependencies.Context;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("off")
@NoArgsConstructor
public class OffState implements State {

    private OnState onState;

    private Context context;

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Autowired
    public void setOnState(OnState onState) {
        this.onState = onState;
    }

    @Override
    public void doAction() {
        System.out.println("turn off Radio ---");

        //do something here
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //setup next state
        context.setNextState(onState);
    }
}
