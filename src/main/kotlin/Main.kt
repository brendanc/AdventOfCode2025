
package main.kotlin

import main.kotlin.tasks.Task1

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: kotlin Main <task.part> (e.g., 1.1, 1.2, 2.1)")
        return
    }

    val input = args[0]
    val parts = input.split(".")

    if (parts.size != 2) {
        println("Invalid format. Please use format: <task>.<part> (e.g., 1.1)")
        return
    }

    val taskNumber = parts[0].toIntOrNull()
    val partNumber = parts[1].toIntOrNull()

    if (taskNumber == null || partNumber == null) {
        println("Invalid task or part number")
        return
    }

    when (taskNumber) {
        1 -> {
            val task = Task1()
            when (partNumber) {
                1 -> task.part1()
                2 -> task.part2()
                else -> println("Task 1 only has parts 1 and 2")
            }
        }
        else -> println("Task $taskNumber not yet implemented")
    }
}
