package com.example.a2_cards_deck

abstract class AbstractFileSystemNodeKT: FileSystemNodeKT {
    private var parent: FileSystemNodeKT? = null
    override fun getParent(): FileSystemNodeKT? {
        return parent
    }
    fun setParent(node: FileSystemNodeKT) {
        parent = node
    }
    private var name: String = ""
    override fun getName(): String {
        return name
    }
    fun setName(name: String) {
        this.name = name
    }

    override fun getFullPath(): String {
        var node: FileSystemNodeKT = this
        val path = StringBuilder(getName())
        while (node.getParent() != null) {
            node = node.getParent()!!
            path.insert(0, node.getName() + '/')
        }
        return path.toString()
    }
}