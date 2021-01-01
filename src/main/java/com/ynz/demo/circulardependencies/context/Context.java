package com.ynz.demo.circulardependencies.context;

import com.ynz.demo.circulardependencies.states.State;

public abstract class Context {
    protected State currentState;

    abstract public void setNextState(State state);
}
