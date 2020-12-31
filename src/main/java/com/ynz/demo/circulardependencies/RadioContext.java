package com.ynz.demo.circulardependencies;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component("radio")
public class RadioContext extends Context {

    @Override
    public void setNextState(State state) {
        this.currentState = state;
    }

    public void radioAction(){
        super.currentState.doAction();
    }
}
