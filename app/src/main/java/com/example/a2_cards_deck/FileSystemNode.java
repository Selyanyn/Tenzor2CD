package com.example.a2_cards_deck;

public interface FileSystemNode {
    public FileSystemNode getParent();
    public String getName();
    public String getFullPath();
}
