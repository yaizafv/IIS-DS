package es.uniovi.ds.lab.loader;

import java.io.*;
import java.util.*;

import es.uniovi.ds.lab.instructions.*;
import es.uniovi.ds.lab.vm.Instruction;

public class BasicProgramLoader {
    public List<Instruction> loadProgram(Reader reader) throws IOException {

        BufferedReader file = new BufferedReader(reader);
        List<Instruction> program = new ArrayList<>();

        String line;
        while ((line = file.readLine()) != null) {
            if (!line.isBlank())
                program.add(creaInstruccion(line));
        }
        file.close();

        return program;
    }

    private Instruction creaInstruccion(String linea) {

        String[] word = linea.split(" ");

        return switch (word[0]) {
            case "add" -> new Add();
            case "sub" -> new Sub();
            case "mul" -> new Mul();
            case "load" -> new Load();
            case "store" -> new Store();
            case "input" -> new Input();
            case "output" -> new Output();
            case "push" -> new Push(Integer.parseInt(word[1]));
            case "jmp" -> new Jump(Integer.parseInt(word[1]));
            case "jmpg" -> new JumpGreater(Integer.parseInt(word[1]));
            default -> throw new IllegalArgumentException("Unknown instruction: " + linea);
        };
    }
}
