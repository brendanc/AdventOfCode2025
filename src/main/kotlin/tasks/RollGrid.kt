package main.kotlin.tasks

import javax.swing.Spring.height

class RollGrid(val height: Int, val width: Int) {
    val obstacleGrid: Array<Array<Obstacle?>> = Array(height) { // rows
        Array(width) { null } // columns, initially all null
    }

    fun readInputIntoGrid(input: String)
    {
        for((row, line) in input.lines().withIndex())
        {
            for((column, char) in line.withIndex())
            {
                obstacleGrid[row][column] = Obstacle(char)
            }
        }
    }

    fun findAdjacentObstacles(x: Int, y: Int): List<Char>
    {
        val obstacleList = mutableListOf<Obstacle>()
        val pointList = mutableListOf<Pair<Int,Int>>()
        pointList.add(Pair(x-1, y-1))
        pointList.add(Pair(x-1, y))
        pointList.add(Pair(x-1, y+1))
        pointList.add(Pair(x, y-1))
        pointList.add(Pair(x, y+1))
        pointList.add(Pair(x+1, y-1))
        pointList.add(Pair(x, y))
        pointList.add(Pair(x+1, y+1))

        for(point in pointList)
        {
            if(isInBounds(point.first, point.second))
            {
                if (obstacleGrid[y][x] != null) {
                    obstacleGrid[y][x]?.let { obstacleList.add(it) }
                }
            }
        }

        return obstacleList.map { it.item }
    }

    fun isInBounds(x: Int, y: Int): Boolean
    {
        if(x < 0 || y < 0 || x >= height || y >= width)
            return false
        return true
    }
}

class Obstacle(val item: Char)