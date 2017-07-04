package org.pcc.kotlin

import android.util.Log

/**
 * Created by ptyagi on 7/4/17.
 */

/**
 * Function with 2 Int parameters and Return type of Int
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun executeDefiningFunctions1() {
    val result = sum(3, 5)
    Log.d("Test", result.toString())
}

fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
}