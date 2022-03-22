package com.example.a2_cards_deck;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode {
    public ArrayList<AbstractFileSystemNode> children;

    public Folder(AbstractFileSystemNode ... nodes) {
        this.children = new ArrayList<AbstractFileSystemNode>();
        for (AbstractFileSystemNode node: nodes) {
            node.parent = this;
            this.children.add(node);
        }
    }

    public ArrayList<AbstractFileSystemNode> getChildren() {
        return children;
    }
}
