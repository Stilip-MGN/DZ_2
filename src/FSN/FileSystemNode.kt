package FSN

interface FileSystemNode {
    fun getRoot(): FileSystemNode?
    fun getName(): String
    fun getPath(): String
    fun setRoot(root:FileSystemNode)
    fun setName(name: String)

}