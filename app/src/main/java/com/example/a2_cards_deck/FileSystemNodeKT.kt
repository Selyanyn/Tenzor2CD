package com.example.a2_cards_deck

interface FileSystemNodeKT {
    fun getParent(): FileSystemNodeKT?
    fun getName(): String
    fun getFullPath(): String
}