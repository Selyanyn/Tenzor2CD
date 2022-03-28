package com.example.a2_cards_deck

class FileKT(private var extension: String) : AbstractFileSystemNodeKT() {

    fun getExtension(): String {
        return extension
    }

    override fun getName(): String {
        return super.getName() + '.' + extension
    }
}