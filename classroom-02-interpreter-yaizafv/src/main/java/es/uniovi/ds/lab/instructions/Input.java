package es.uniovi.ds.lab.instructions;

import java.util.*;

import es.uniovi.ds.lab.vm.*;

public class Input extends AbstractInstruction {

    private Scanner console = new Scanner(System.in);

    @Override
    protected void doExecute(State state) {
        System.out.print("Enter an integer: ");
        state.push(console.nextInt());
    }
}
