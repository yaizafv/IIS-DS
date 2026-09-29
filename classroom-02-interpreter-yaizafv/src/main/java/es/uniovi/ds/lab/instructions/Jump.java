package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class Jump implements Instruction {

    private int address;

    public Jump(int address) {
        this.address = address;
    }

    @Override
    public void execute(State state) {
        state.setIP(address);
    }

}
