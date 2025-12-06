package main.kotlin

import main.kotlin.tasks.BaseTask
import main.kotlin.tasks.Task1
import main.kotlin.tasks.Task2
import main.kotlin.tasks.Task3
import main.kotlin.tasks.Task4

class TaskResolver {
    fun resolveTask(taskNumber: Int) : BaseTask
    {
        when(taskNumber) {
            1 -> return Task1()
            2 -> return Task2()
            3 -> return Task3()
            4 -> return Task4()
            else -> throw IllegalArgumentException("Task $taskNumber not yet supported")
        }
    }
}