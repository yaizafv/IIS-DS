package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Push extends AbstractInstruction {

    private int value;

    public Push(int value) {
        this.value = value;
    }

    @Override
    protected void doExecute(State state) {
        state.push(value);
    }
}
