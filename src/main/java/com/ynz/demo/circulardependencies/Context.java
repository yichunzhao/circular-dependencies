package com.ynz.demo.circulardependencies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Context {
    protected State currentState;
    abstract public void setNextState(State state);
}
