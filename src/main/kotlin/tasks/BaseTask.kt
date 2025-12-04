package main.kotlin.tasks

import main.kotlin.util.InputReader

abstract class BaseTask {
    abstract fun part1()
    abstract fun part2()

    fun readSampleInput() : String
    {
        return readInput("sample.")
    }

    fun readInput(prefix:String = ""): String {
        // 1. Get the current stack trace elements
        val stackTrace = Thread.currentThread().stackTrace

        // 2. Find the calling method
        // We look for the first element whose class is NOT BaseTask
        // The index 0 is Thread.getStackTrace()
        // The index 1 is ReadInputForThisPart()
        // The index 2 should be the actual calling function (e.g., Task1.part1)
        var callerElement = stackTrace[0]
        for(stack in stackTrace)
        {
            if(stack.methodName.contains("part"))
            {
                callerElement = stack
                break
            }
        }

        // 3. Extract the calling class name and method name
        val fullClassName = callerElement.className // e.g., main.kotlin.tasks.Task1
        val callingMethodName = callerElement.methodName // e.g., part1

        // 4. Infer the file parts based on the names
        val taskFolder = fullClassName.substringAfterLast('.')
        val partFileName = "$prefix$callingMethodName.txt"


        // 5. Construct the final filename
        val finalFileName = "$taskFolder/$partFileName"

        // 6. Read the input
        return InputReader().readToString(finalFileName)
    }
}