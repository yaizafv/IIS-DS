package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Load extends AbstractInstruction {

    protected void doExecute(State context) {
        context.push(context.read(context.pop()));
    }
}
