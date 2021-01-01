package com.ynz.demo.circulardependencies.context;

import com.ynz.demo.circulardependencies.states.State;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component("radio")
@DependsOn("off")
public class RadioContext extends Context {

    @Autowired
    public RadioContext(@Qualifier("off") State offState) {
        super.currentState = offState;
    }

    @Override
    public void setNextState(State state) {
        this.currentState = state;
    }

    public void pressButton() {
        super.currentState.doAction();
    }
}
