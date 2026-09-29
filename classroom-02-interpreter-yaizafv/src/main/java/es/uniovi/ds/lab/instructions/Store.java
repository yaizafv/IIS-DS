package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Store extends AbstractInstruction {

    @Override
    protected void doExecute(State state) {
        int value = state.pop();
        int address = state.pop();

        state.write(address, value);
    }
}
