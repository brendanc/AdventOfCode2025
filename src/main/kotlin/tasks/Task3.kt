package main.kotlin.tasks

class Task3 : BaseTask() {
    override fun part1() {
        println("Hello world! This is task 3.1")
        val input = readInput()
        val banks = input.lines();
        var total : Long = 0;
        for(bank in banks) {
            val jolt = getMaxJoltage(bank)
            println("Bank $bank => $jolt")
            total += jolt
        }
        println("Total joltage: $total")
    }

    override fun part2() {
        println("Hello world! This is task 3.2")
        val input = readInput()
        val banks = input.lines();
        var total : Long = 0;
        for(bank in banks) {
            val jolt = getMaxJoltage(bank, 12)
            println("Bank $bank => $jolt")
            total += jolt
        }
        println("Total joltage: $total")
    }

    fun getMaxJoltage(bank: String, digits : Int = 2): Long{
        var answerString = ""
        val numbers = bank.toCharArray().map {it.digitToInt()}
        var lastMaxIndex = 0

        while(answerString.length < digits)
        {
            // find next max digit
            // pass in last max digit index and digits remaining
            val nextMaxAnswer = findNextMaxDigit(numbers.drop(lastMaxIndex),lastMaxIndex,digits - answerString.length)
            lastMaxIndex = nextMaxAnswer.first+1
            answerString += nextMaxAnswer.second.toString()
        }
        return answerString.toLong()
    }

    fun findNextMaxDigit(numbers: List<Int>, lastMaxDigitIndex: Int, digitsRemaining: Int) : Pair<Int,Int>{
        //987654321111111
        val lastIndex = numbers.size - digitsRemaining+1
        var max = 0
        var maxIndex = 0
        for(i in 0 until lastIndex){
            if(numbers[i] > max)
            {
                max = numbers[i]
                maxIndex = i
            }
        }
        return Pair(maxIndex + lastMaxDigitIndex, max)
    }

}