
import data.TasksRepositoryMemory
import menu.addTaskFromMenu
import menu.taskActions



fun renderMenu(): Int {
    println("=========================================================")
    val actions = listOf(
        "Add task", "Delete task", "List all tasks", "List non-completed tasks",
        "Complete task", "Uncomplete task", "Quit"
    )
    actions.forEachIndexed { index, action ->
        println("${index + 1}. $action")
    }
    print("Make your choice: ")
    return readln().toIntOrNull() ?: 0
}

fun main() {
    println("Otus Todo List\n")
    val repository = TasksRepositoryMemory()
    while (true) {
        val action = renderMenu()
        try {
            val func = taskActions[Actions.values()[action - 1]]
            func?.call(repository)
        } catch (e: ArrayIndexOutOfBoundsException) {
            //just skip
        }
    }
}

/*class Tests {
    @Test
    fun addTask_addsNewTaskToList() {
        // Arrange
        val repository = object : TasksRepository() {
            private val tasks = mutableListOf<Task>()

            override fun getTasks(completed: Boolean): List<Task> {
                return tasks.filter { it.completed == completed }
            }

            override fun addTask(task: Task): Int {
                val newId = tasks.size + 1
                tasks.add(task.copy(id = newId))
                return newId
            }

            override fun deleteTask(id: Int) {
                tasks.removeIf { it.id == id }
            }

            override fun completeTask(id: Int) {
                tasks.find { it.id == id }?.completed = true
            }

            override fun uncompleteTask(id: Int) {
                tasks.find { it.id == id }?.completed = false
            }
        }

        val firstTask = Task(name = "First Task", priority = Priority.LOW)
        val secondTask = Task(name = "Second Task", priority = Priority.HIGH)
        val thirdTask = Task(name = "Third Task", priority = Priority.HIGH)
        val taskList = listOf(firstTask, secondTask, thirdTask)

        // Act создание тасок
        val firstTaskGo = repository.addTask(firstTask)
        val secondTaskGo = repository.addTask(secondTask)
        val thirdTaskGo = repository.addTask(thirdTask)

        //завершили вторую
        repository.completeTask(2)
        //проверили
        assertTrue(secondTask.completed, "Вторая таска должна быть completed")
        //обратно вернули статус
        repository.uncompleteTask(2)
        //проверили
        assertFalse(secondTask.completed, "У второй таски должен быть изменён статус на uncompleted")

//вывели только завершённые
        repository.getTasks(false)

        // Assert
        /*  assertEquals(1, newTaskId, )
          assertEquals(1, repository.getTasks().size)
          assertEquals(taskToAdd.copy(id = 1), repository.getTasks()[0])*/
        /*   println(firstTask.id)
           println(firstTask.name)
           println(firstTask.completed)*/

        println(repository.getTasks(false))

        println("123")
        println(firstTask.id)
        println(repository.getTasks(false))

    }*/
