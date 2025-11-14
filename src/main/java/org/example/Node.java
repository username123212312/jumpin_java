package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Node {
    List<Rabbit> rabbits = new ArrayList();
    Node parent;
    int depth;

    public Node(List<Rabbit> rabbits) {
        for(Rabbit r : rabbits) {
            this.rabbits.add(new Rabbit(r.getRow(), r.getCol()));
        }

        this.parent = null;
        this.depth = 0;


    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return depth == node.depth && Objects.equals(rabbits, node.rabbits) && Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rabbits, parent, depth);
    }
}

