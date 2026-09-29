package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Output extends AbstractInstruction {

    @Override
    protected void doExecute(State state) {
        System.out.println(state.pop());
    }
}
