package main.kotlin.tasks

import kotlin.math.abs

class NumberLine {
    var value: Int = 50
    val max = 99
    val min = 0
    var timesPassedZero = 0
    fun moveNext(amount: Int)
    {
        var i=0
        while(i<abs(amount))
        {
            i++

            val factor = if(amount<0) -1 else 1
            value += factor

            if(value>max)
            {
                value=0
            }
            if(value<min)
            {
                value=max
            }

            if(value == 0)
            {
                timesPassedZero++
            }
        }
    }
}