class Menu (
    private val title: String,
    private val items: Map<String, () -> Unit>,
) {
    fun show() {
        var shouldContinue = true
        while (shouldContinue){
            println(title)
            val itemsList = items.entries.toList()
            for ((index,item) in itemsList.withIndex()){
                println("$index.${item.key}")
            }
            val input = readLine()
            if (input.isNullOrBlank()){
                println("Ошибка: введите номер пункта меню")
                continue
            }
            val choice = input.toIntOrNull()
            when {
                choice == null -> {
                    println("Не верный ввод: нужно ввести число")
                }
                choice < 0 || choice>= items.size -> {
                    println("Не верный ввод: выберите число от 0 до ${items.size -1}")
                } else -> {
                    itemsList[choice].value()
                    shouldContinue = false
                }
                }
            }
        }
    }
