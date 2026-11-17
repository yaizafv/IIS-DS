package es.uniovi.ds.lab.nodes.statements;

import es.uniovi.ds.lab.nodes.expressions.Variable;
import es.uniovi.ds.lab.visitor.Visitor;

public class Input implements Statement {

    // NOTE: they should be private with getters and setters, but are left public to streamline the class
    public Variable variable;

    public Input(Variable variable) {
        this.variable = variable;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visitInput(this);
    }

}
