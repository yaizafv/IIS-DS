package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public abstract class AbstractInstruction implements Instruction {

    public void execute(State state) {
        doExecute(state);
        state.setIP(state.getIP() + 1);
    }

    protected abstract void doExecute(State state);
}
