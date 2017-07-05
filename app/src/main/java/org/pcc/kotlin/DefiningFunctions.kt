package org.pcc.kotlin

/**
 * Created by ptyagi on 7/4/17.
 */

/**
 * Function with 2 Int parameters and Return type of Int
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun executeDefiningFunctions1(): Int {
    val result = sum(1, 2)
    return result
}

fun main(args: Array<String>) {
    print("sum of 1 and 2 is ")
    println(sum(1, 2))
}