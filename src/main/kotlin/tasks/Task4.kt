package main.kotlin.tasks

class Task4 : BaseTask() {
    override fun part1() {
        println("Hello world! This is task 4.1")
        val input = readInput()
        val h = input.lines().size
        val w = input.lines().first().length
        val grid = RollGrid(h,w)
        grid.readInputIntoGrid(input)
        var total = 0
        for(x in 0 until w)
        {
            for(y in 0 until h)
            {
                val item = grid.obstacleGrid[y][x]
                if(item?.item == '@')
                {
                    val adjacents = grid.findAdjacentObstacles(x, y)
                    val rolls = adjacents.map{it  == '@'}
                    if(rolls.size > 3)
                    {
                        total++
                    }
                }
            }
        }
        println("Total rols ==> $total")
    }

    override fun part2() {
        TODO("Not yet implemented")
    }
}