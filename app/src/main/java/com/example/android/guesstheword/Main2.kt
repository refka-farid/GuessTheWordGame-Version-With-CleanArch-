package com.example.android.guesstheword


val given = arrayOf(2, 7, 11, 15)
fun twoSum(given: Array<Int>, target: Int): String {
    var solution = ""
//    for (i in  0 .. given.lastIndex) {
    for (i in given.indices) {
        for (j in (i + 1)..given.lastIndex) {
            if (given[i] + given[j] == target) {
                solution = "[$i, $j]"
            }
        }
    }
    return solution
}


// map in this exemple want a function with this signature : (int :Int)-> list<Int>
val numbers = listOf(1, 2, 77, 3, 4, 88, 5, 8, 9, 55, 11, 22, 44, 10, 112)

fun Int.isPair(): Boolean = this.rem(2) == 0

fun sumInts(vararg ints: Int): Int =
        ints.reduce { x, y ->
            x + y
        }


fun main(args: Array<String>) {

    println(twoSum(given, 17))
//    val refList = listOf<Any>(5.0, 55.0, 77.0, 0.5)
//
//    refList.toMutableList().apply {
//        val d = this[0]
//        this[1] = 20
//    }.also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//
//    }.toList().also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//    }
//
//    refList.also {
//        println(it)//{5.0 , 55.0 , 77.0 , 0.5}
//    }

//    var refList = listOf<Any>(5.0, 55.0, 77.0, 0.5)
//
//    refList=refList.toMutableList().apply {
//        val d = this[0]
//        this[1] = 20
//    }.also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//
//    }.toList().also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//    }
//
//    refList.also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//    }


//    val refList = mutableListOf<Any>(5.0, 55.0, 77.0, 0.5)
//
//    refList.toMutableList().apply {
//        val d = this[0]
//        this[1] = 20
//    }.also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//
//    }.toList().also {
//        println(it)//{5.0 , 20 , 77.0 , 0.5}
//    }
//
//    refList.also {
//        println(it)//{5.0 , 55.0 , 77.0 , 0.5}
//    }


    val refList: MutableList<Any> = mutableListOf<Any>(5.0, 55.0, 77.0, 0.5).apply {//this:MutableList<Any>
        ->
        reverse()
        reverse()
    }
    var refList1: MutableList<Any>
    refList.toMutableList().apply {//this:MutableList<Any>
        ->
        val d = this[0]
        this[1] = 20
    }.also { it: MutableList<Any> ->
        it.set(1, 100)
        println(it)//{5.0 , 100, 77.0 , 0.5}

    }.also {
        refList1 = refList
    }.toList().also { it: List<Any> ->
        println(it)//{5.0 , 100 , 77.0 , 0.5}
    }
    println(refList1)
    refList.let {
        it[1] = 30
        it
    }.also {
        println(it)//{5.0 , 30, 77.0 , 0.5}
    }

    val list1 = mutableListOf("5")// list1 is a reference on the anonymous object created by calling this factoryFunction mutableListOf("")
    val list2 = list1
    val list3 = list1
    // we have created two other references that points on list1 if we ever update one of these references they all have to change
    println(list1)   //[5]
    println(list2)   //[5]
    println(list3)   //[5]

    list3[0]="KO"
    println(list1)   //[KO]
    println(list2)   //[KO]
    println(list3)   //[KO]

    list2[0]="jiji"
    println(list1)  //[jiji]
    println(list2)  //[jiji]
    println(list3)  //[jiji]
    val intRange = 1..222
    intRange.first
    intRange.last

//
//    val x: MutableList<String> = listOf("a", "b", "a", "a", "a", "a", "a", "c", "d").filterIndexed { index, s ->
//        s == "a" && index.rem(2) == 0
//    }.toMutableList().apply {//this:MutableList<String>
//        ->
//        add("zizi")
//    }.also { it: MutableList<String> ->
//        println(it)//[a, a, a, a, zizi]
//    }
//
//    sumInts(1, 2, 4).also { it: Int ->
//        println(it)
//    }
//
//    listOf(1).also { it: List<Int> ->
//        println(it)
//    }
//    listOf("Ahmed",
//            "Hammadi",
//            "Aymen",
//            "Badii",
//            "Zoubayer",
//            "Bilel",
//            "Jamil",
//            "Kamal")
//            .groupBy { it: String ->
//                it.first().toString()
//            }
//            .flatMap { it: Map.Entry<String, List<String>> ->
//                listOf(it.key, *it.value.toTypedArray())
//            }.sorted()
//            .also {
//                println(it)
//            }
//
//    listOf("Ahmed",
//            "Hammadi",
//            "Aymen",
//            "Badii",
//            "Zoubayer",
//            "Bilel",
//            "Jamil",
//            "Kamal").reduce { acc, s ->
//        val firstChart = acc[0].toString()
//        val newFirstChart = s[0].toString()
//        "$firstChart $acc $newFirstChart $s"
//    }.split(" ").distinct()
//            .sorted()
//            .also {
//                println(it)
//            }
//    listOf("Ahmed",
//            "Hammadi",
//            "Aymen",
//            "Badii",
//            "Zoubayer",
//            "Bilel",
//            "Jamil",
//            "Kamal").groupingBy { it.first().toString() }
//            .also {
//                println(it)
//            }
////    listOf("Ahmed",
////            "Hammadi",
////            "Aymen",
////            "Badii",
////            "Zoubayer",
////            "Bilel",
////            "Jamil",
////            "Kamal")
////            .groupBy {
////                it.first()
////            }
////            .map {
////                it.value.sortedDescending().toMutableList().apply {
////                    add(it.key.toString())
////                }.sortedDescending()
////            }.also {
////                println(it)
////            }
//}
//
////fun main(args: Array<String>) {
////    val flatMap = listOf<Any>(95252, 5555, 00.00).flatMap {
////        listOf(it)
////    }
////    listOf<Any>(95252, 5555, 00.00).flatMapTo(flatMap.toMutableList()) {
////        listOf(it)
////    }
////}
//
//interface Expendable {
//    fun isExpendable(): Boolean {
//        return false
//    }
//}
//
//fun myNumber(number: Int): Int {
//    return 0
//}
//
//val myNumber: (number: Int) -> Int = {
//    it
//}
//
//val myFun: () -> Boolean = {
//    false
//}
//
//lateinit var myFun2: () -> Boolean
//
//enum class StudentResult : () -> Int {
//    FAIL {
//        override fun invoke(): Int = 5
//    },
//    SUCCESS {
//        override fun invoke(): Int = 10
//    },
//    CONTROL {
//        override fun invoke(): Int = 9
//    },
//    FIRED {
//        override fun invoke(): Int = 0
//    };
//
//    // this fun is not static it for all instances(FAIL,SUCCESS,CONTROL,FIRED which are singletons objects  )
//    fun doItEnum() {
//        println(" Yes I m do It ")
//    }
//
//    companion object {
//        fun printAll() {
//            val values1 = values()
//            values1.forEach {
//                println("it")
//            }
//            val values = enumValues<StudentResult>()
//            values.forEach {
//                println("it")
//            }
//        }
//    }
//}
//
//abstract class SchoolHolidaysAbstract(daysCount: Int) {
//    class AutumnHoliday : SchoolHolidaysAbstract(15) {
//        override fun containsCatchingUp(): Boolean = true
//    }
//
//    class WinterHoliday(isForced: Boolean) : SchoolHolidaysAbstract(15) {
//        override fun containsCatchingUp() = false
//    }
//
//    class SpringHoliday(isForced: Boolean) : SchoolHolidaysAbstract(15) {
//        override fun containsCatchingUp() = false
//    }
//
//    class SummerHoliday : SchoolHolidaysAbstract(15) {
//        override fun containsCatchingUp() = true
//    }
//
//    object PublicHoliday : SchoolHolidaysAbstract(10) {
//        override fun containsCatchingUp() = false
//    }
//
//    fun hasStarted(): Boolean {
//        return false
//    }
//
//    abstract fun containsCatchingUp(): Boolean;
//
//}
//
//class AutumnHolidayAbstract22 : SchoolHolidaysAbstract(15) {
//    override fun containsCatchingUp() = TODO()
//}
//
//fun enjoyHolidaysAbstract(holiday: SchoolHolidaysAbstract) {
//    val containsCatchUp = when (holiday) {
//        is SchoolHolidaysAbstract.AutumnHoliday -> {
//
//        }
//
//        is SchoolHolidaysAbstract.WinterHoliday -> {
//
//        }
//
//        is SchoolHolidaysAbstract.SpringHoliday -> {
//
//        }
//
//        is SchoolHolidaysAbstract.SummerHoliday -> {
//
//        }
//
//        is SchoolHolidaysAbstract.PublicHoliday -> {
//
//        }
//        is AutumnHolidayAbstract22 -> {
//
//        }
//        // here we must add an else branch because we consume an abstract class
//        else -> {
//
//        }
//    }
//}
//
//fun enjoyHolidaysSealed(holiday: SchoolHolidaysSealed) {
//    val containsCatchUp = when (holiday) {
//        is SchoolHolidaysSealed.AutumnHoliday -> {
//
//        }
//
//        is SchoolHolidaysSealed.WinterHoliday -> {
//
//        }
//
//        is SchoolHolidaysSealed.SpringHoliday -> {
//
//        }
//
//        is SchoolHolidaysSealed.SummerHoliday -> {
//
//        }
//
//        is SchoolHolidaysSealed.PublicHoliday -> {
//
//        }
//        is AutumnHoliday22 -> {
//
//        }
//        // here we don't else branch because we consume a sealed class
//    }
//}
//
//fun enjoyHolidaysEnum(studentResult: StudentResult) {
//    val result = when (studentResult) {
//        StudentResult.FAIL -> {
//            val studentResult1 = studentResult()// we can invoke the enum because it implement anonymous function
//            5
//        }
//        StudentResult.SUCCESS -> -1
//        StudentResult.CONTROL -> {
//            val studentResult1 = studentResult()
//            studentResult.doItEnum()
//        }
//        StudentResult.FIRED -> {
//            val studentResult1 = studentResult()
//            StudentResult.printAll()
//        }
//    }
//}
////sealed (fermé)  class is like abstract class (could have abstract methods). but it's sealed(closed ) for extra classes that are not in the same file
//// in sealed class constructor must be private
//
//sealed class SchoolHolidaysSealed(daysCount: Int) {
//    class AutumnHoliday : SchoolHolidaysSealed(15) {
//        override fun containsCatchingUp(): Boolean = true
//    }
//
//    class WinterHoliday(isForced: Boolean) : SchoolHolidaysSealed(15) {
//        override fun containsCatchingUp() = false
//    }
//
//    class SpringHoliday(isForced: Boolean) : SchoolHolidaysSealed(15) {
//        override fun containsCatchingUp() = false
//    }
//
//    class SummerHoliday : SchoolHolidaysSealed(15) {
//        override fun containsCatchingUp() = true
//    }
//
//    object PublicHoliday : SchoolHolidaysSealed(10) {
//        override fun containsCatchingUp() = false
//    }
//
//    fun hasStarted(): Boolean {
//        return false
//    }
//
//    abstract fun containsCatchingUp(): Boolean
//
//}
//
//class AutumnHoliday22 : SchoolHolidaysSealed(15) {
//    override fun containsCatchingUp() = TODO()
//}
//
//// Manager to avoid in naming class in clean code
//class StudentSubscription : Expendable {
//    fun subscribe() {}
//
//    override fun isExpendable(): Boolean {
//        val expendable = super.isExpendable()
//        return !expendable
//    }
//
//    companion object {
//        const val SUBSCRIPTION_MAX_COUNT = 10
//    }
//}
//
//// we shouldn't use "Data" in naming class in clean code
//data class Student(
//        val schoolBranch: String,
//        val name: String,
//        val age: Int
//) : Expendable
//
//object StudentSubscribed : Expendable {
//    override fun isExpendable(): Boolean {
//        val expendable = super.isExpendable()
//        return Random.nextBoolean().and(!expendable)
//        // return Random.nextBoolean() and !expendable
//        // return Random.nextBoolean() && !expendable
//    }
//}
//
//object StudentUnsubscribed : Expendable, () -> Int {
//    override fun invoke(): Int = Random.nextFloat().roundToInt()
//}
//
//
//annotation class Decoration
//
//@Decoration
//abstract class Human {
//    abstract fun standUp()
}
//external
//tailrec
//internal


