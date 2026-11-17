package es.uniovi.ds.lab.executor;

import java.util.*;

import es.uniovi.ds.lab.nodes.Program;
import es.uniovi.ds.lab.nodes.expressions.*;
import es.uniovi.ds.lab.nodes.statements.*;
import es.uniovi.ds.lab.visitor.Visitor;

/*
// Input
    input heigth;
    input width;
    print heigth * width;

// Output
    Type value for heigth: 5
    Type value for width: 10
    50
*/

/*
Requirements:
- All variables are of `int` type.
- If you access an uninitialized variable, it defaults to 0.
- Only has addition, subtraction, multiplication, and division.
*/

public class ExecutorVisitor implements Visitor {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, Integer> variables = new HashMap<>();

    @Override
    public Object visitProgram(Program program) {
        Object result = null;
        for (var statement : program.statements)
            statement.accept(this);
        return result;
    }

    @Override
    public Object visitInput(Input input) {
        System.out.print("Enter value for " + input.variable.name + ": ");
        int value = getUserInput();
        variables.put(input.variable.name, value);
        return null;
    }

    @Override
    public Object visitPrint(Print print) {
        int value = (int) print.expression.accept(this);
        System.out.println(value);
        return null;
    }

    @Override
    public Object visitArithmetic(Arithmetic arithmetic) {
        int a = (int) arithmetic.left.accept(this);
        int b = (int) arithmetic.right.accept(this);

        return switch (arithmetic.operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new UnsupportedOperationException("Unknown operator: " + arithmetic.operator);
        };
    }

    @Override
    public Object visitVariable(Variable variable) {
        return variables.getOrDefault(variable.name, 0);
    }

    // Auxiliary method to get an integer input from the user
    private int getUserInput() {
        return scanner.nextInt();
    }
}
