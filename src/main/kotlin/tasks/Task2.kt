package main.kotlin.tasks

import java.math.BigInteger

class Task2: BaseTask() {

    override fun part1() {
        println("Hello world! This is task 2.1")
        val input = readInput()
        val numbers = parseInputToListOfNumbers(input)
        var invalidTotal : Long = 0
        for (number in numbers) {
            if(numberIsValid(number) == false) {
                invalidTotal += number
            }
        }

        println("Found $invalidTotal invalid total")
    }

    override fun part2() {
        println("Hello world! This is task 2.2")
        val input = readInput()
        val numbers = parseInputToListOfNumbers(input)
        var invalidTotal : Long = 0
        for (number in numbers) {
            if(numberIsValid(number) == false) {
                invalidTotal += number
            }
            else
            {
                if(numberIsRepeatingInvalid(number)) {
                    invalidTotal += number
                }
            }
        }
        println("Found $invalidTotal invalid total")
    }

    fun parseInputToListOfNumbers(input: String): List<Long> {
        val ranges = input.split(",")
        val numbers = mutableListOf<Long>()
        for(range in ranges) {
            val parts = range.split("-")
            val start = parts[0].toLong()
            val end = parts[1].toLong()
            for(i in start..end) {
                numbers.add(i)
            }

        }
        return numbers
    }

    fun numberIsValid(input : Long) : Boolean {
        val numAsString = input.toString()
        val numLength = numAsString.length
        if(numLength % 2 != 0)
        {
            return true
        }
        val half = numLength / 2
        val part1 = numAsString.take(half)
        val part2 = numAsString.drop(half)
        return part1 != part2
    }

    fun numberIsRepeatingInvalid(input: Long) : Boolean {
        val numAsString = input.toString()
        val numLength = numAsString.length
        val half = numLength / 2 + 1
        for(i in 1 until half) {
            val part = numAsString.take(i)
            val replaceTest = numAsString.replace(part,"")
            if(replaceTest == "")
            {
                return true
            }
        }
        return false
    }
}