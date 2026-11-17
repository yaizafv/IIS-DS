package es.uniovi.ds.lab.python;

import static java.lang.System.*;

import es.uniovi.ds.lab.nodes.expressions.*;
import es.uniovi.ds.lab.nodes.statements.*;
import es.uniovi.ds.lab.visitor.Visitor;

/*
// Input
    input heigth;
    input width;
    print heigth * width;

// Python output
    heigth = int(input())
    width = int(input())
    print(heigth * width)
*/

public class PythonVisitor implements Visitor {

    @Override
    public Object visitProgram(es.uniovi.ds.lab.nodes.Program program) {

        for (var statement : program.statements)
            statement.accept(this);
        return null;
    }

    @Override
    public Object visitInput(Input input) {
        input.variable.accept(this);
        System.out.println(" = int(input())");
        return null;
    }

    @Override
    public Object visitPrint(Print print) {
        out.print("print(");
        print.expression.accept(this);
        out.println(")");
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
