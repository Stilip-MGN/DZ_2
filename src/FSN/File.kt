package FSN

class File(name: String, extension: String) : AbstractFileSystemNode() {
    private var extension: String

    init {
        setName(name)
        this.extension = extension
    }

    fun getExtension() = extension

    override fun getName(): String {
        return super.getName() + getExtension()
    }
}