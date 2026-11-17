package es.uniovi.ds.lab.nodes;

import es.uniovi.ds.lab.visitor.Visitor;

public interface Node {
    Object accept(Visitor visitor);
}
