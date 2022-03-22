package com.example.a2_cards_deck;

abstract public class AbstractFileSystemNode implements FileSystemNode{
    public FileSystemNode parent;
    public String name;

    @Override
    public final FileSystemNode getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getFullPath() {
        FileSystemNode node = this;
        StringBuilder path = new StringBuilder(getName());
        while (node.getParent() != null) {
            node = node.getParent();
            path.insert(0, node.getName() + '/');
        }
        path.insert(0, node.getName() + '/');
        return path.toString();
    }
}
