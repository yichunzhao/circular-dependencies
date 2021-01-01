package com.ynz.demo.circulardependencies.states;

import com.ynz.demo.circulardependencies.context.Context;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("on")
@NoArgsConstructor
public class OnState implements State {

    private OffState offState;

    private Context context;

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Autowired
    public void setOffState(OffState offState) {
        this.offState = offState;
    }

    @Override
    public void doAction() {
        System.out.println(" Turn on power ........ ");

        //do something here
        try {
            Thread.sleep(1000);
            System.out.println(" ... Power on ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //switch to next state
        context.setNextState(offState);
    }
}
