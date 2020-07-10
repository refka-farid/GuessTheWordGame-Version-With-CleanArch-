package com.example.android.guesstheword

typealias BooleanMatrix = Array<BooleanArray>

object LongestPalindromeSubstring {
    // This function prints the longest palindrome substring
    // of str[].
    fun from(str: String): String {
        var maxLength = 1

        if (str.isEmpty()) return "**** empty string ****"
        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        val n = str.length
        val matrix: BooleanMatrix = Array(n) {
            BooleanArray(n)
        }

        // All substrings of length 1 are palindromes
        for (i in 0 until n) {
            matrix[i][i] = true
        }


        // check for substring of length 2.
        var start = 0
        for (i in 0 until n - 1) {
            if (str[i] == str[i + 1]) {
                matrix[i][i + 1] = true
                start = i//todo ?????
                maxLength = 2
            }
        }

        // Check for lengths greater than 2
        // k is length of substring
        for (k in 3..n) {

            // Fix the starting index
            for (i in 0 until n - k + 1) {
                // Get the ending index of substring from
                // starting index i and length k
                val j = i + k - 1

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (matrix[i + 1][j - 1] && str[i] ==
                        str[j]) {
                    matrix[i][j] = true
                    if (k > maxLength) {
                        start = i
                        maxLength = k
                    }
                }
            }
        }
        print("Longest palindrome substring is: ")
        return str.substring(start, start + maxLength)
    }
    // Driver program to test above functions
}

fun main(args: Array<String>) {
    val string = "-2.b7*b5a0bad"
    //val string = "forgeeksskeegfor"
    //val string = "MANAMAM"
    println(LongestPalindromeSubstring.from(string))

    for( i in 0 ..10){

    }



}
