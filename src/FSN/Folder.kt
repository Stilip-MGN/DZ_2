package FSN


class Folder(name: String, vararg args: FileSystemNode) : AbstractFileSystemNode() {
    private var children = ArrayList<FileSystemNode>()

    init {
        setName(name)
        for (arg in args) {
            arg.setRoot(this)
            children.add(arg)
        }
    }

    fun getChildren() = children
}