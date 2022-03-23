package com.example.a2_cards_deck;

public class File extends AbstractFileSystemNode {
    private String extension = null;

    public File(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String getName() {
        return super.getName() + '.' + extension;
    }
}
