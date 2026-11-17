package es.uniovi.ds.lab.nodes.expressions;

import es.uniovi.ds.lab.visitor.Visitor;

public class Arithmetic implements Expression {

    // NOTE: they should be private with getters and setters, but are left public to streamline the class
    public Expression left, right;
    public String operator;

    public Arithmetic(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visitArithmetic(this);
    }
}
