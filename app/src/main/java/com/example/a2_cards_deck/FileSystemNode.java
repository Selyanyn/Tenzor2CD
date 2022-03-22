package com.example.a2_cards_deck;

public interface FileSystemNode {
    FileSystemNode parent = null;
    String name = null;

    public FileSystemNode getParent();
    public String getName();
    public String getFullPath();
}
