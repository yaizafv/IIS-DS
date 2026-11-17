package es.uniovi.ds.lab.nodes.expressions;

import es.uniovi.ds.lab.visitor.Visitor;

public class Variable implements Expression {

    // NOTE: they should be private with getters and setters, but are left public to streamline the class
    public String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visitVariable(this);
    }
}
