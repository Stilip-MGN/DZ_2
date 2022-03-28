package FSN

class File(name: String, private var extension: String) : AbstractFileSystemNode(name, null) {
    fun getExtension() = extension

    override fun getName(): String {
        return super.getName() + getExtension()
    }
}