class NotesMenu {
    fun  showNotesMenu(archive: Archive){
        var shouldReturn = false
        while (!shouldReturn){
            val menuItems = mutableMapOf<String, () -> Unit>()
            menuItems["Создайте заметку"] = { createNote(archive)}
            for (note in archive.notes){
                menuItems[note.title] = {showNote(note)}
            }
            menuItems ["Назад"] = {shouldReturn = true}
            Menu ("Список заметок в архиве '${archive.name}':", menuItems).show()
        }
    }
    private fun createNote(archive: Archive) {
        val title = readInput("Введите название заметки:") ?: return
        val content = readInput("Введите текст заметки:") ?: return
        archive.notes.add(Note(title,content))
    }
    private fun showNote(note: Note){
        println("Заметка: ${note.title}\n${note.content}\n")
        readlnOrNull()
    }
    private fun readInput(prompt: String): String? {
        println(prompt)
        return readlnOrNull()?.takeIf{it.isNotBlank()} ?: run {
            println("Не может быть пустым")
            null
        }
    }
}