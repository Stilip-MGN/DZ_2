package FSN

class Folder(name: String, vararg args: FileSystemNode) : AbstractFileSystemNode(name, null) {
    private var children = ArrayList<FileSystemNode>()

    init {
        for (arg in args) {
            arg.setRoot(this)
            children.add(arg)
        }
    }

    fun getChildren() = children
}

