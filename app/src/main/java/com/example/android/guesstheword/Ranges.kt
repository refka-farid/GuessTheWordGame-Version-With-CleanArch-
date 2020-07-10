package com.example.android.guesstheword

import java.sql.Date

class Ranges {

    data class User(val age: Int) : Comparable<User> {
        override fun compareTo(other: User): Int = age.compareTo(other.age)

        //..
        operator fun rangeTo(other: User) = UserRange(this, other)

//    operator fun inc(): User {
//        return User(this.age + 1)
//    }
    }

    data class UserRange(override val start: User,
                         override val endInclusive: User) : ClosedRange<User>, Iterable<User> {
        override fun iterator(): Iterator<User> = UserIterator(start, endInclusive)
    }

    data class UserIterator(private val start: User,
                            private val endInclusive: User) : Iterator<User> {
        var initialValue = start

        override fun hasNext(): Boolean = initialValue <= endInclusive

        override fun next(): User {
            return initialValue.also {
                val nextUser = User(initialValue.age + 1) // or just ++ initialValue if we
                initialValue = nextUser
            }
            //the best is to use return initialValue++
        }
    }

}

fun main(args: Array<String>) {
//
//    val now = Date(System.currentTimeMillis())
//    println(now.toString())
//    val start = Date.valueOf("2017-01-01")
//    val end = Date.valueOf("2017-12-31")
//    val range: ClosedRange<Date> = start..end
//    println(range)
//    val isIn = now in range
//    println(isIn)

    val range2 = 5..20
    val range3: IntProgression = 5 downTo -1

    val userClosedRangeFrom2To5: Ranges.UserRange = Ranges.User(2)..Ranges.User(5)
    println(userClosedRangeFrom2To5)

    val user3 = Ranges.User(3)
    val user0 = Ranges.User(0)

    val isUser3In = user3 in userClosedRangeFrom2To5
    println("isUser3In $isUser3In")
    val isUser0In = user0 in userClosedRangeFrom2To5
    println("isUser0In $isUser0In")

    for (user in userClosedRangeFrom2To5) { // because UserRange is Iterator<User>
        println("user: $user")
    }

    val arrayOf: Array<Int> = arrayOf(2, 5, 55, 555, 4)
    val b = 4 in arrayOf
    //for(i in arrayOf)
}
