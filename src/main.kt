import FSN.File
import FSN.Folder

fun main() {
    val file1 = File("file1", ".txt")
    val file2 = File("file2", ".exe")
    val folder1 = Folder("folder1", file1, file2)

    val folder2 = Folder("folder2")

    val root = Folder("Root", folder1, folder1)

    println(file2.getPath())
    println((folder1.getChildren()[1] as File).getExtension())
}


