package es.uniovi.ds.lab.instructions;

import es.uniovi.ds.lab.vm.*;

public class JumpGreater implements Instruction {

    private int address;

    public JumpGreater(int address) {

        this.address = address;
    }

    @Override
    public void execute(State state) {
        int b = state.pop();
        int a = state.pop();
        if (a > b)
            state.setIP(address);
        else
            state.setIP(state.getIP() + 1);
    }

}
