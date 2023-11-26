package test

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RepositoryTests : TasksRepositoryMemory() {

    var repository = TasksRepositoryMemory();
    val firstTask = Task(name = "First Task", priority = Priority.LOW, completed = false)
    val secondTask = Task(name = "Second Task", priority = Priority.HIGH, completed = false)
    val thirdTask = Task(name = "Third Task", priority = Priority.HIGH, completed = false)
    val firstTaskGo = repository.addTask(firstTask)
    val secondTaskGo = repository.addTask(secondTask)
    val thirdTaskGo = repository.addTask(thirdTask)

    @Test
    fun testSetStatus() {
        repository.completeTask(2)
        getTaskById(2)?.completed?.let { assertTrue(it, "Ошибка смены статуса") }
    }

    @Test
    fun testReturnInitialStatus() {
        repository.uncompleteTask(2)
        getTaskById(2)?.completed?.let { assertFalse(it, "Ошибка смены статуса") }
    }

    @Test
    fun testDeleteTask() {
        repository.deleteTask(2)
        assertEquals(repository.getTaskById(2), null, "Ошибка удаления объекта")
    }

    @Test
    fun testAddingNewTask() {
        val newTask = Task(name = "Huge Task", priority = Priority.MEDIUM, completed = false);
        repository.addTask(newTask)
        assertEquals(newTask.name, "Huge Task", "Имя добалвенной таски совпадает")
    }

}