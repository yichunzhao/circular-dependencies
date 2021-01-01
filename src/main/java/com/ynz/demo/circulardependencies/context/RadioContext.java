package com.ynz.demo.circulardependencies.context;

import com.ynz.demo.circulardependencies.context.Context;
import com.ynz.demo.circulardependencies.states.State;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component("radio")
public class RadioContext extends Context {

    @Override
    public void setNextState(State state) {
        this.currentState = state;
    }

    public void pressButton() {
        super.currentState.doAction();
    }
}
