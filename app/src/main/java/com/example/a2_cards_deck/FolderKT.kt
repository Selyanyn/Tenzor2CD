package com.example.a2_cards_deck

class FolderKT(vararg nodes: AbstractFileSystemNodeKT) : AbstractFileSystemNodeKT() {
    var children: ArrayList<AbstractFileSystemNodeKT> = ArrayList()

    init {
        for (node in nodes) {
            node.setParent(this)
            children.add(node)
        }
    }
}