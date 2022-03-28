package FSN

abstract class AbstractFileSystemNode(private var name: String, private var root: FileSystemNode?) : FileSystemNode {
    override fun getName() = name

    final override fun getPath(): String {
        val result = root?.getPath() ?: ""
        return String.format("%s/%s", result, getName());
    }

    final override fun getRoot() = root

    final override fun setRoot(root: FileSystemNode?) {
        this.root = root
    }
}