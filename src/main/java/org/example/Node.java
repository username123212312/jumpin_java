package org.example;


import java.util.ArrayList;
import java.util.List;

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
}

