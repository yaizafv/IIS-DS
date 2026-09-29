package es.uniovi.ds.lab.vm;

import java.util.List;

public class VirtualMachine {

    private State state;
    private List<Instruction> program;

    public VirtualMachine(List<Instruction> program) {
        this.program = program;
        this.state = new State();
    }

    public void run() {
        while (state.getIP() < program.size())
            program.get(state.getIP()).execute(state);
    }

}
