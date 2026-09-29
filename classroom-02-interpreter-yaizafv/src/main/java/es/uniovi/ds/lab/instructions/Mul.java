package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Mul extends AbstractInstruction {

    @Override
    protected void doExecute(State state) {
        state.push(state.pop() * state.pop());
    }
}
