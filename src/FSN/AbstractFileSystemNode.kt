package FSN

abstract class AbstractFileSystemNode : FileSystemNode {
    private var name: String = ""
    private var root: FileSystemNode? = null

    final override fun getRoot(): FileSystemNode? = root

    override fun setRoot(root: FileSystemNode) {
        this.root = root
    }

    override fun setName(name: String) {
        this.name = name
    }

    override fun getName(): String = name

    final override fun getPath(): String {
        val result = root?.getPath() ?: ""
        return String.format("%s/%s", result, getName());
    }
}