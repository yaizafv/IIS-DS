/**
 * # IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the exercise and should NEVER be taken as an example of proper use of exceptions,
 * assertions, and tests. All of the above, which should be done in a real program, has been
 * intentionally omitted to simplify the exercise.
 */

package es.uniovi.ds.lab.main;

import java.io.FileReader;
import java.util.List;

import es.uniovi.ds.lab.loader.BasicProgramLoader;
import es.uniovi.ds.lab.vm.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BasicProgramLoader loader = new BasicProgramLoader();
        List<Instruction> program = loader.loadProgram(new FileReader("fibonacci.txt"));

        var virtualMachine = new VirtualMachine(program);
        virtualMachine.run();
    }
}
