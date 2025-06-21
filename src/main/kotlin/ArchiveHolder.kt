class ArchiveHolder {
    fun showArchiveHolder(archives: MutableList<Archive>){
        var exit = false
        while (!exit) {
            val menuItems = mutableMapOf<String, () -> Unit>()
            menuItems ["Создайте архив"] = { createArchive(archives)}
            for (archive in archives){
                menuItems [archive.name] = {
                    NotesMenu().showNotesMenu(archive)
                }
            }
            menuItems ["Выход"] = {
                exit = true
            }
            Menu("Список архивов:", menuItems).show()
        }
    }
    fun createArchive(archives: MutableList<Archive>){
        println("Введите название архива:")
        val name = readlnOrNull()?.takeIf { it.isNotBlank() }?: run {
            println("Название архива не может быть пустым")
            return
        }
            archives.add(Archive(name))
        }
    }
