package main.kotlin.tasks

import main.kotlin.util.InputReader


class Task1 : BaseTask() {
    override fun part1() {
        println("Hello world! This is task 1.1")
        val input = readInput()
        val instructions = input.lines();

        var password = 0
        println(" - The dial starts by pointing at 50")
        val numberLine = NumberLine()
        for(instruction in instructions)
        {
            val direction = instruction.take(1)
            val factor = if(direction == "L") -1 else 1
            val amount = instruction.drop(1).toInt() * factor
            numberLine.moveNext(amount)

            if(numberLine.value == 0)
            {
                password += 1
            }


            println(" - The dial is rotated [$instruction] to point at ${numberLine.value}")
        }
        println("The password is: $password")

    }

    override fun part2() {
        println("Hello world! This is task 1.2")
    }
}
