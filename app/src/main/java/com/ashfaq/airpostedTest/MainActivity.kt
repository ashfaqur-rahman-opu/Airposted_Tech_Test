package com.ashfaq.airpostedTest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Solution 1
        val arr1 = intArrayOf(6, 4, 3, 4, 1, 7, 5, 5)
        println("Duplicate numbers: ")
        for (i in arr1.indices) {
            for (j in i + 1 until arr1.size) {
                if (arr1[i] == arr1[j]) println(arr1[j])
            }
        }

        //Solution 2
        val arr = intArrayOf(1, 3, 1, 4, 2, 3, 5, 4)
        println("FrogRiverWithHashmap: " + solution(5, arr))
        println("FrogRiverWithoutHashmap: " + solution1(5, arr))

        //Solution 3
        var a = 10
        var b = 5
        a += b
        b = a - b
        a -= b
        println("After swapping: a = $a, b = $b")

        //Solution 4
        val str = "Hello I am Ashfaq"
        println("Total No. of words : " + countWords(str))
    }

    private fun solution(X: Int, A: IntArray): Int {
        val position = HashSet<Int>()
        try {
            for (x in A.indices) {
                position.add(A[x])
                if (position.size == X) {
                    return x
                }
            }
        } catch (e: Exception) {
            return -1
        }
        return -1
    }

    private fun solution1(X: Int, A: IntArray): Int {
        var jumpCount = X
        val position = IntArray(X + 1)
        for (i in A.indices) {
            if (position.size >= A[i]) {
                if (position[A[i]] == 0) jumpCount--
                if (jumpCount == 0) return i
                position[A[i]]++
            }
        }
        return -1
    }

    private fun countWords(inputString: String?): Int {
        if (inputString == null || inputString.isEmpty()) {
            return 0
        }
        val words = inputString.split("\\s+").toTypedArray()
        return words.size
    }
}