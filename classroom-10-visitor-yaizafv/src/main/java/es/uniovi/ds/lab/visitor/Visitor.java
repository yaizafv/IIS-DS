package es.uniovi.ds.lab.visitor;

import es.uniovi.ds.lab.nodes.Program;
import es.uniovi.ds.lab.nodes.expressions.*;
import es.uniovi.ds.lab.nodes.statements.*;

public interface Visitor {

    Object visitProgram(Program program);

    Object visitInput(Input input);

    Object visitPrint(Print print);

    Object visitArithmetic(Arithmetic arithmetic);

    Object visitVariable(Variable variable);

}
