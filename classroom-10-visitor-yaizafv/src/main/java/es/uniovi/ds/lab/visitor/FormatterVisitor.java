package es.uniovi.ds.lab.visitor;

import static java.lang.System.out;

import es.uniovi.ds.lab.nodes.Program;
import es.uniovi.ds.lab.nodes.expressions.*;
import es.uniovi.ds.lab.nodes.statements.*;

public class FormatterVisitor implements Visitor {

    @Override
    public Object visitProgram(Program program) {
        for (Statement statement : program.statements)
            statement.accept(this);
        return null;
    }

    @Override
    public Object visitInput(Input input) {
        out.print("input ");
        visitVariable(input.variable);
        out.println(";");
        return null;
    }

    @Override
    public Object visitPrint(Print print) {
        out.print("print ");
        print.expression.accept(this);
        out.println(";");
        return null;
    }

    @Override
    public Object visitArithmetic(Arithmetic arithmetic) {
        arithmetic.left.accept(this);
        out.print(" " + arithmetic.operator + " ");
        arithmetic.right.accept(this);
        return null;
    }

    @Override
    public Object visitVariable(Variable variable) {
        out.print(variable.name);
        return null;
    }

}
